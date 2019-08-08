package LSL_Servlet.scheduleServlet;

import Dao.Scheduledao;
import factory.factory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/delete")
public class deleteServlet extends HttpServlet {
    Scheduledao scheduledao;
    public deleteServlet(){
        scheduledao = factory.getInstance("scheduledao", Scheduledao.class);
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String studentid = request.getParameter("studentid");
        String examname = request.getParameter("examname");
        scheduledao.deleteSchedule(studentid,examname);
        request.getRequestDispatcher("/querySchedule.do").forward(request,response);
    }
}
