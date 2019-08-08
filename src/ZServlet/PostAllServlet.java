package ZServlet;

import DaoImp.ZbbsDaoImpl;
import Entity.PostAll;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = {"/postall"})
public class PostAllServlet extends HttpServlet {
    ZbbsDaoImpl zbbsDao=new ZbbsDaoImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String groupname=request.getParameter("groupname");
        String sql="select p1.* ,name from post as p1,grouping,user where p1.groupid=grouping.groupid and grouping.groupname='"+groupname+"' and grouping.groupcreid=user.username  ";
        List<PostAll> list=zbbsDao.findPostAll(sql);
        request.getSession().setAttribute("postlist",list);
        System.out.println(list);
        request.getRequestDispatcher("/WEB-INF/jsp/bbs.jsp").forward(request,response);




    }
}
