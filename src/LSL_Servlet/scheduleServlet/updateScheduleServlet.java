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
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet(urlPatterns = "/updateSchedule.do")
public class updateScheduleServlet extends HttpServlet {
    Scheduledao scheduledao;

    public updateScheduleServlet() {
        scheduledao = factory.getInstance("scheduledao", Scheduledao.class);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String examname = request.getParameter("examname");
        String examtime = request.getParameter("examtime");
        String remark = request.getParameter("remark");
        String examplace = request.getParameter("examplace");
        Date d = new Date();
        SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
        String createtime = date.format(d);
        Schedule schedule = (Schedule) request.getSession().getAttribute("updateschedule");
        String sql = "update examschedule set examname = ?,examtime = ?,remark = ?,examplace = ?,createtime=? where studentid=? and examname = ?";
        int result = scheduledao.updateSchedule(sql,schedule.getStudentid(),schedule.getExamname(),examname,examtime,remark,examplace,createtime);
        System.out.println(result);
        if(result!=0){
            System.out.println("修改成功！");
            schedule = scheduledao.findIdAndName(schedule.getStudentid(),examname);
            System.out.println(schedule);
//            request.getSes  sion().setAttribute("updateschedule",schedule);
            request.getRequestDispatcher("/querySchedule.do").forward(request,response);
        }else {
            System.out.println("修改失败!");
            request.getRequestDispatcher("WEB-INF/jsp/schedule/querySchedule.jsp").forward(request, response);
        }
    }
}
