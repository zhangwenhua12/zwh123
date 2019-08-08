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
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet(urlPatterns = "/addSchedule.do")
public class addScheduleServlet extends HttpServlet {
    Scheduledao scheduledao;
    public addScheduleServlet(){
        scheduledao = factory.getInstance("scheduledao",Scheduledao.class);
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String examname = request.getParameter("examname");
        String remark = request.getParameter("remark");
        String examtime = request.getParameter("examtime");
        String examplace = request.getParameter("examplace");
        Date d = new Date();
        SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
        String createtime = date.format(d);
        User user = (User) request.getSession().getAttribute("userinfo");
        Schedule schedule = new Schedule(user.getUsername(),examname,examtime,remark,examplace,createtime);
        int result = scheduledao.addSchedule(schedule);
        if(result!=0){
            System.out.println("添加成功!");
            request.getRequestDispatcher("querySchedule.do").forward(request,response);
        }else {
            System.out.println("添加失败!");
            request.getRequestDispatcher("WEB-INF/jsp/schedule/addSchedule.jsp").forward(request,response);
        }
    }
}
