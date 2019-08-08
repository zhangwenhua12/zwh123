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
import java.util.ArrayList;
import java.util.List;

@WebServlet(urlPatterns = {"/createCouser"})
public class CreateCouserServlet extends HttpServlet {
    CousedaoImpl cousedao=new CousedaoImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       User user=(User) request.getSession().getAttribute("userinfo");
       String username=user.getUsername();
       List<Course> courses=cousedao.getAll(username);
       if(courses.size()!=0){
           response.sendRedirect("/course");
           System.out.println("已经存在课表");
       }else if(courses.size()==0){
           //没有课表，需要创建
           cousedao.CreateCouser(username);
           response.sendRedirect("/course");
       }

    }
}
