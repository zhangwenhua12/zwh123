package LSL_Servlet.bbsServlet;

import Dao.BbsDao;
import Entity.Post;
import factory.factory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/deletemycomment")
public class deleteCommentServlet extends HttpServlet {
    BbsDao bbsDao;

    public deleteCommentServlet() {
        bbsDao = factory.getInstance("bbsdao", BbsDao.class);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String commentid = request.getParameter("commentid");
        String topic_sql = "select post.*,name from post,comment,user where username = posterid and post.postid = comment.postid" +
                " and commentid = '"+commentid+"';";
        Post post = bbsDao.postQuery(topic_sql);
//        String topic = post.getTopic();
        Post post1 = (Post) request.getSession().getAttribute("showpost");
        String sql = "delete from comment where commentid = '" + commentid + "';";
        int result = bbsDao.delete(sql);
        if (result != 0) {
            System.out.println("删除成功!");
            String update_sql = "update post set commentnum = '"+(post.getCommentnum()-1)+"' where postid = '"+post.getPostid()
                    +"';";
            bbsDao.Update(update_sql);
            request.getRequestDispatcher("bbs_index.do").forward(request, response);
        } else {
            System.out.println("我也不知道啥错!");
        }
    }
}
