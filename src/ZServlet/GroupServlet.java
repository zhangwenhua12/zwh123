package ZServlet;

import DaoImp.ZbbsDaoImpl;
import Entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = {"/group"})
public class GroupServlet extends HttpServlet {
    ZbbsDaoImpl zbbsDao=new ZbbsDaoImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user=(User) request.getSession().getAttribute("userinfo");
        String username=user.getUsername();
        String sql="select groupname from grouping where groupcreid='"+username+"'";
        List list=zbbsDao.findGroupname(sql);
        request.getSession().setAttribute("list",list);
        request.getRequestDispatcher("/WEB-INF/jsp/bbs.jsp").forward(request,response);
    }
}
