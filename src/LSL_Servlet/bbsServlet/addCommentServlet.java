package LSL_Servlet.bbsServlet;

import Dao.BbsDao;
import Entity.Comment;
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

@WebServlet(urlPatterns = "/addcomment")
public class addCommentServlet extends HttpServlet {
    BbsDao bbsDao;

    public addCommentServlet() {
        bbsDao = factory.getInstance("bbsdao", BbsDao.class);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
String newcomment = request.getParameter("newcomment");
Date d = new Date();
        SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
        String commenttime = date.format(d);
        Post post = (Post) request.getSession().getAttribute("showpost");
        User user = (User) request.getSession().getAttribute("userinfo");
        String commentidmax_sql = "select comment.*,name from comment,user where username = commenterid " +
                "and commentid = (select max(commentid) from comment)";
        Comment comment = bbsDao.commentQuery(commentidmax_sql);
        int commentid = Integer.parseInt(comment.getCommentid())+1;
        String addComment_sql = "insert into comment value('"+commentid+"','"+post.getGroupid()+"','"+
                post.getPostid()+ "','" +user.getUsername()+"','"+newcomment+"','"+commenttime+"');";
        System.out.println(addComment_sql);
        int result = bbsDao.add(addComment_sql);
        if(result!=0){
            System.out.println("添加评论成功!");
            String update_sql = "update post set commentnum = '"+(post.getCommentnum()+1)+"' where postid = '"+post.getPostid()
                    +"';";
            bbsDao.Update(update_sql);
            request.getRequestDispatcher("bbs_index.do").forward(request,response);
        }else {
            System.out.println("我也不知道啥子错!");
        }
    }
}
