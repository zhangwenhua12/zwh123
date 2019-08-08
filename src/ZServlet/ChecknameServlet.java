package ZServlet;

import DaoImp.ZUserdaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = {"/Checkname"})
public class ChecknameServlet extends HttpServlet {
    ZUserdaoImpl zUserdao=new ZUserdaoImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name=request.getParameter("username");
        boolean flag=zUserdao.findname(name);
        String resu="";
        if(flag){
            resu="exist";

        }else {
            resu="";
        }
        PrintWriter out=response.getWriter();
        out.write(resu);
        out.flush();
        out.close();

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
