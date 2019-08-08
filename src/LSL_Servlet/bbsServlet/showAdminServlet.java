package LSL_Servlet.bbsServlet;

import Dao.BbsDao;
import Entity.Admin;
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

@WebServlet(urlPatterns = "/showadmin")
public class showAdminServlet extends HttpServlet {
    BbsDao bbsDao;

    public showAdminServlet() {
        bbsDao = factory.getInstance("bbsdao", BbsDao.class);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
String groupid = request.getParameter("groupid");
String query_sql = "select redundant.*,name,groupname from redundant,user,grouping where redundant.groupid = grouping.groupid" +
        " and userid = username and redundant.groupid = '"+groupid+"' and permissions = '"+1+"';";
    List<Admin> list = bbsDao.adminQuery(query_sql);
        System.out.println(list);
        User user = (User) request.getSession().getAttribute("userinfo");
        request.getSession().setAttribute("adminlist",list);
        request.getRequestDispatcher("WEB-INF/jsp/bbs/deleteAdmin.jsp").forward(request,response);
    }
}
