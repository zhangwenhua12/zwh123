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
import java.util.List;

@WebServlet(urlPatterns = "/post.do")
public class postServlet extends HttpServlet {
    BbsDao bbsDao;

    public postServlet() {
        bbsDao = factory.getInstance("bbsdao", BbsDao.class);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = (User) request.getSession().getAttribute("userinfo");
        String groupname = request.getParameter("groupname");
//        System.out.println(groupname);
//        获取群组名称的帖子信息
        String post_sql = "select post.*,name from grouping,post,user where grouping.groupid = post.groupid " +
                "and username = posterid and groupname = '" + groupname + "';";
        List<Post> list = bbsDao.postsQuery(post_sql);
        //        获取登陆者的权限
        String permissions_sql = "select permissions from redundant,grouping where grouping.groupid = redundant.groupid and " +
                "groupname = '" + groupname + "'" + "and userid = '" + user.getUsername() + "' ;";
        int permissions = bbsDao.permissions(permissions_sql);
        //        用个蠢办法获得群组id
        String groupid_sql = "select redundant.groupid from redundant,grouping where grouping.groupid = redundant.groupid" +
                " and groupname = '" + groupname + "'" + "and userid = '" + user.getUsername() + "' ;";
        System.out.println(groupid_sql);
        String groupid = bbsDao.groupid(groupid_sql);
//        将前面存放第一个群组帖子信息的Session覆盖
        request.getSession().setAttribute("post",list);
//        将前面存放第一个群组id的Session覆盖
        request.getSession().setAttribute("groupid",groupid);
        //        将前面存放第一个群组权限的Session覆盖
        request.getSession().setAttribute("permissions", permissions);
        request.getRequestDispatcher("WEB-INF/jsp/bbs/bbs_index.jsp").forward(request,response);
    }
}
