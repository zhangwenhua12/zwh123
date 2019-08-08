package Servlet;

import Dao.DaoTest;
import DaoImp.TestDaoImp;
import Entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(value="/test")
public class TestServlet extends HttpServlet {
    DaoTest daoTest=new TestDaoImp();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String useremail=request.getParameter("exampleInputEmail");
        String userpassword=request.getParameter("exampleInputPassword");
        String testcn=request.getParameter("exampleInputName");
        System.out.println(useremail);
        System.out.println(userpassword);
        System.out.println(testcn);
        request.getRequestDispatcher("index.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<User> list=daoTest.getString();
        for(User user:list) {
            System.out.println(user);
        }
        request.setAttribute("list",list);
        request.getRequestDispatcher("index.jsp").forward(request,response);
    }
}
