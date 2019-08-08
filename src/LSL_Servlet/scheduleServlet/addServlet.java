package LSL_Servlet.scheduleServlet;

import Dao.Scheduledao;
import factory.factory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/add.do")
public class addServlet extends HttpServlet {
    Scheduledao scheduledao;
    public addServlet(){
        scheduledao = factory.getInstance("scheduledao", Scheduledao.class);
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("进入了addservlet");
        request.getRequestDispatcher("WEB-INF/jsp/schedule/addSchedule.jsp").forward(request,response);
    }
}
