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
import java.util.List;

@WebServlet(urlPatterns = "/post")
public class showPostServlet extends HttpServlet {
    BbsDao bbsDao;

    public showPostServlet() {
        bbsDao = factory.getInstance("bbsdao", BbsDao.class);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        获取页面发过来的topic
        String topic = request.getParameter("topic");
        User user = (User) request.getSession().getAttribute("userinfo");
//        System.out.println(topic);
//        获取当topic时的Post对象
        String post_sql = "select * from post,user where username = posterid and topic = '" + topic + "';";
        Post post = bbsDao.postQuery(post_sql);
//        System.out.println(post);
//        获取在该帖子下的所有评论
        String commenter_sql = "select comment.*,name from comment,post,user where comment.postid = post.postid " +
                "and commenterid = username and topic = '" + topic + "';";
        List<Comment> list1 = bbsDao.commentsQuery(commenter_sql);
//        System.out.println(list1);
//        获取在该帖子下的登录者的评论
        String mycomment_sql = "select comment.*,name from comment,post,user where comment.postid = post.postid and username = commenterid and topic = '" + topic + "' " +
                "and commenterid = '" + user.getUsername() + "';";
        List<Comment> list2 = bbsDao.commentsQuery(mycomment_sql);
//        System.out.println(list2);
//        获取登陆者的信息
        String sql = "select post.*,name from post,user where username = posterid and  posterid= '" + user.getUsername() + "';";
        Post post1 = bbsDao.postQuery(sql);
        System.out.println(post1);
        request.getSession().setAttribute("usering", post1);
        request.getSession().setAttribute("showpost", post);
        request.getSession().setAttribute("showcomment", list1);
        request.getSession().setAttribute("showmycomment", list2);
        request.getRequestDispatcher("WEB-INF/jsp/bbs/showPost.jsp").forward(request, response);
    }

}
