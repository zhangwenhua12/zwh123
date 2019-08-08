package ZServlet;

import DaoImp.CousedaoImpl;
import Entity.Course;
import Entity.User;
import org.json.simple.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = {"/course"})
public class CourseServlet extends HttpServlet {
    CousedaoImpl cousedao=new CousedaoImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user=(User) request.getSession().getAttribute("userinfo");
        String username=user.getUsername();
        /*String name=request.getParameter("name");*/
        System.out.println(username);
        List<Course> list=cousedao.getAll(username);
        for (Course course:list){
            System.out.println(course);
        }
        if(list.size()>0){
            request.getSession().setAttribute("flag",true);
        }else {
            request.getSession().setAttribute("flag",false);
        }
        request.getSession().setAttribute("course",list);
        request.getRequestDispatcher("/WEB-INF/jsp/showcourse.jsp").forward(request,response);

    }
}
