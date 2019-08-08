package LSL_Servlet.bbsServlet;

import Dao.BbsDao;
import Dao.UserDao;
import Entity.Post;
import Entity.User;
import factory.factory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/addpost")
public class addPostServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        String postidmax_sql = "select post.*,name from post,user where username = posterid and postid = (select max(postid) from post)";
//        Post post =bbsDao.postQuery(postidmax_sql);
//        System.out.println(post);
        request.getRequestDispatcher("WEB-INF/jsp/bbs/addpost.jsp").forward(request,response);
    }
}
