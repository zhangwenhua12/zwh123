package LSL_Servlet.bbsServlet;

import Dao.BbsDao;
import Entity.Admin;
import factory.factory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/showNormalAdmin")
public class showNormalUserServlet extends HttpServlet {
    BbsDao bbsDao;

    public showNormalUserServlet() {
        bbsDao = factory.getInstance("bbsdao", BbsDao.class);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String groupid = request.getParameter("groupid");
        String sql = "select redundant.*,name,groupname from redundant,user,grouping where redundant.groupid = grouping.groupid" +
                        " and userid = username and redundant.groupid = '"+groupid+"' and permissions = '"+0+"';";
        List<Admin> list = bbsDao.adminQuery(sql);
        System.out.println(list);
        request.getSession().setAttribute("normalUser",list);
        request.getRequestDispatcher("WEB-INF/jsp/bbs/addAdmin.jsp").forward(request, response);
    }
}
