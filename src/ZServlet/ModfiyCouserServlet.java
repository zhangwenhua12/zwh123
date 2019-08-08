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

@WebServlet(urlPatterns = {"/modfiyCouse"})
public class ModfiyCouserServlet extends HttpServlet {
    CousedaoImpl cousedao=new CousedaoImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user=(User) request.getSession().getAttribute("userinfo");
        String username=user.getUsername();
        int result=0;
        for (int i=1;i<=5;i++){
            String mon=request.getParameter("mon"+i);
            String tue=request.getParameter("tue"+i);
            String wed=request.getParameter("wed"+i);
            String thu=request.getParameter("thu"+i);
            String fri=request.getParameter("fri"+i);
            String sta=request.getParameter("sta"+i);
            String sun=request.getParameter("sun"+i);
            System.out.println(mon+" "+tue+" "+wed);
            Course course=new Course(i,mon,tue,wed,thu,fri,sta,sun);
             result=cousedao.updaetCouser(username,course);
        }
        if (result>0){
            System.out.println("修改成功");
            response.sendRedirect("/course");
        }




    }
}
