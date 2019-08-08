package Servlet;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "UserInfoServlet" ,value="/jumpuserinfo")
public class UserInfoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /*String username=request.getParameter("username");


        if(username!=null){*/
//            try {
//                Object result=new JSONParser().parse(username);
//                if(result instanceof JSONObject){
//                    re=(JSONObject)result;
//                }else if( result instanceof JSONArray){
//                    res=(JSONArray)result;
//                }
//            } catch (ParseException e) {
//                e.printStackTrace();
//            }
//            response.setContentType("text/json;charset=UTF-8");
//            response.setCharacterEncoding("UTF-8");
//            PrintWriter out=response.getWriter();
//            String json=res.toJSONString();
//            System.out.println(json);
//            out.println(json);
//            out.close();
//            request.getRequestDispatcher("/WEB-INF/jsp/userinfo.jsp").forward(request,response);

       /* }else{
            request.getRequestDispatcher("/login.jsp");
        }*/
        request.getRequestDispatcher("/WEB-INF/jsp/userinfo.jsp").forward(request,response);
    }
}
