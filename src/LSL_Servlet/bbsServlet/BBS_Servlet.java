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

@WebServlet(urlPatterns = "/bbs_index.do")
public class BBS_Servlet extends HttpServlet {
    BbsDao bbsDao;

    public BBS_Servlet() {
        bbsDao = factory.getInstance("bbsdao", BbsDao.class);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        System.out.println("进入servlet");
        User user = (User) request.getSession().getAttribute("userinfo");
        //获取所有群组的名称
        String group_sql = "select groupname from grouping,redundant where redundant.groupid = grouping.groupid and userid ='"
                + user.getUsername() + "';";
        List list = bbsDao.groupQuery(group_sql);
//        System.out.println(list);
//        System.out.println(list.get(0));
        //获取第一个群组的帖子信息
        if (list.size()>0) {
        String firstpost_sql = "select post.*,name from grouping,post,user where grouping.groupid = post.groupid " +
                "and username = posterid and groupname = '" + list.get(0) + "';";
//        System.out.println(firstpost_sql);
        List list1 = bbsDao.postsQuery(firstpost_sql);
        System.out.println(list1);
        //        获取登陆者的权限
        String permissions_sql = "select permissions from redundant,grouping where grouping.groupid = redundant.groupid" +
                " and groupname = '" + list.get(0) + "'" + "and userid = '" + user.getUsername() + "' ;";
        System.out.println(permissions_sql);
        int permissions = bbsDao.permissions(permissions_sql);
//        用个蠢办法获得群组id
        String groupid_sql = "select redundant.groupid from redundant,grouping where grouping.groupid = redundant.groupid" +
                " and groupname = '" + list.get(0) + "'" + "and userid = '" + user.getUsername() + "' ;";
        System.out.println(groupid_sql);
        String groupid = bbsDao.groupid(groupid_sql);
        //用Session对象存下来
        request.getSession().setAttribute("post", list1);
        request.getSession().setAttribute("group", list);
        request.getSession().setAttribute("permissions", permissions);
        request.getSession().setAttribute("groupid",groupid);
        }
        request.getRequestDispatcher("WEB-INF/jsp/bbs/bbs_index.jsp").forward(request, response);
    }
}
