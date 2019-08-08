package LSL_Servlet.bbsServlet;

import Dao.BbsDao;
import Entity.Post;
import Entity.User;
import factory.factory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet(urlPatterns = "/sendpost")
public class sendPostServlet extends HttpServlet {
    BbsDao bbsDao;

    public sendPostServlet() {
        bbsDao = factory.getInstance("bbsdao", BbsDao.class);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String topic = request.getParameter("topic");
        String content = request.getParameter("content");
        String groupid = (String) request.getSession().getAttribute("groupid");
        String postidmax_sql = "select post.*,name from post,user where username = posterid and postid = (select max(postid) from post)";
        Post post1 = bbsDao.postQuery(postidmax_sql);
        System.out.println(post1);
        Date d = new Date();
        SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
        String posttime= date.format(d);
        User user = (User) request.getSession().getAttribute("userinfo");
        int postid = Integer.parseInt(post1.getPostid()) + 1;
        String add_sql = "insert into post value('" + postid + "','" + groupid + "','" + user.getUsername() + "','" +posttime + "','"
                + 0 + "','" + topic + "','" + content + "')";
        System.out.println(add_sql);
        int result = bbsDao.add(add_sql);
        if (result != 0) {
            System.out.println("发送成功!");
            request.getRequestDispatcher("bbs_index.do").forward(request, response);
        } else {
            System.out.println("我也不知道啥子错!");
        }
    }
}
