package LSL_Servlet.scheduleServlet;

import Dao.Scheduledao;
import Entity.Schedule;
import Entity.User;
import factory.factory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/querySchedule.do")
public class queryScheduleServlet extends HttpServlet {
    Scheduledao scheduledao;

    public queryScheduleServlet() {
        scheduledao = factory.getInstance("scheduledao", Scheduledao.class);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = (User) request.getSession().getAttribute("userinfo");
//        System.out.println(user);
        List<Schedule> list = scheduledao.findById(user.getUsername());
//        System.out.println(list);
        boolean flag = true;
        request.getSession().setAttribute("flag", flag);
        if (list != null) {
            request.getSession().setAttribute("querylist", list);
        } else {
            flag = false;
            request.getSession().setAttribute("flag", flag);
        }
        request.getRequestDispatcher("WEB-INF/jsp/schedule/querySchedule.jsp").forward(request, response);
    }
}
