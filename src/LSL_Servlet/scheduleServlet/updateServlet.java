package LSL_Servlet.scheduleServlet;

import Dao.Scheduledao;
import Entity.Schedule;
import factory.factory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/update")
public class updateServlet extends HttpServlet {
    Scheduledao scheduledao;

    public updateServlet() {
        scheduledao = factory.getInstance("scheduledao", Scheduledao.class);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String studentid = request.getParameter("studentid");
        String examname = request.getParameter("examname");
        Schedule schedule = scheduledao.findIdAndName(studentid, examname);
        System.out.println(schedule);
        request.getSession().setAttribute("updateschedule", schedule);
        request.getRequestDispatcher("WEB-INF/jsp/schedule/updateSchedule.jsp").forward(request, response);
    }
}
