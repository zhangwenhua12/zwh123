package Servlet;

import Entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {"/update.do"})
public class UpdateServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name=request.getParameter("username");
        String sex=request.getParameter("sex");
        String dep=request.getParameter("dep");//学院
        String cep=request.getParameter("cep");//年级
        String major=request.getParameter("major");//专业
        String class1=request.getParameter("class1");//班级
        String phone=request.getParameter("phone");
        String email=request.getParameter("email");
        System.out.println(name+" "+sex+" "+dep+" "+cep+" "+major+" "+class1+" "+phone+" "+email);
        String username=(String) request.getSession().getAttribute("username");
        User user=new User();
        user.setUsername(username);
        user.setName(name);
        user.setSex(sex);
        user.setMajor(major);
        




    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
