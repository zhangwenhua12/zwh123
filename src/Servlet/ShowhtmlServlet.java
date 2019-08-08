package Servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ShowhtmlServlet",value="/showfriendhtml")
public class ShowhtmlServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String filename=request.getParameter("filename");
        String username=request.getParameter("fileowner");
        System.out.println("showfriendhtml  filename:"+filename+" fileowner"+username);
        request.getRequestDispatcher("/uploadFile/"+username+"/"+filename).forward(request,response);
    }
}
