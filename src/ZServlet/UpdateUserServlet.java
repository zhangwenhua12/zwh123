package ZServlet;

import DaoImp.ZUserdaoImpl;
import Entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {"/register.do"})
public class UpdateUserServlet extends HttpServlet {
    ZUserdaoImpl zUserdao=new ZUserdaoImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username=request.getParameter("username");
        String password=request.getParameter("password");
        String name=request.getParameter("name");
        String sex=request.getParameter("sex");
        String phone=request.getParameter("phone");
        String email=request.getParameter("email");
        String collage=request.getParameter("collage");
        String major=request.getParameter("major");
        String grade=request.getParameter("grade");
        String classno=request.getParameter("classno");
        System.out.println(username+" "+password+" " +name+" "+sex+" "+phone+" "+email+" "+collage+" "+classno+" "+major+" "+grade);
        User user=new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setName(name);
        user.setSex(sex);
        user.setPhone(phone);
        user.setEmail(email);
        user.setCollage(collage);
        user.setMajor(major);
        user.setGrade(Integer.parseInt(grade));
        user.setClassno(Integer.parseInt(classno));
        boolean flag=zUserdao.InsertUser(user);
        if(flag){
            System.out.println("注册成功");
            response.sendRedirect("login.jsp");
        }else {

        }



    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
