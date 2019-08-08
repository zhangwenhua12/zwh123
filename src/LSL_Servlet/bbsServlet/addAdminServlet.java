package LSL_Servlet.bbsServlet;

import Dao.BbsDao;
import factory.factory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/addAdmin")
public class addAdminServlet extends HttpServlet {
    BbsDao bbsDao;

    public addAdminServlet() {
        bbsDao = factory.getInstance("bbsdao", BbsDao.class);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String adminid = request.getParameter("adminid");
        String groupid = request.getParameter("groupid");
        System.out.println(groupid);
        String update_sql = "update redundant set permissions = '" + 1 + "'where userid = '" + adminid + "'and groupid = '" + groupid + "';";
        int result = bbsDao.Update(update_sql);
        if (result != 0) {
            System.out.println("添加管理员成功!");
            request.getRequestDispatcher("showNormalAdmin").forward(request, response);
        } else {
            System.out.println("我也不知道啥错!");
        }
    }
}
