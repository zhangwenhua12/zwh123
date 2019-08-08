package ZServlet;

import DaoImp.CousedaoImpl;
import Entity.Course;
import Entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = {"/deleteCouser"})
public class DeteleServlet extends HttpServlet {
    CousedaoImpl cousedao=new CousedaoImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user=(User) request.getSession().getAttribute("userinfo");
        String username=user.getUsername();
        List<Course> courses=cousedao.getAll(username);
        System.out.println("delete-***"+courses.size());
        if (courses.size()>0){
            boolean flag=cousedao.deleteCouser(username);
            if(flag){
                System.out.println("delete-删除成功");
                response.sendRedirect("/course");
            }

        }

    }
}
