package Servlet;

import Dao.FileDao;
import DaoImp.FileDaoImp;
import Entity.MyFile;
import Entity.User;
import org.json.simple.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "ShowFriendFilesServlet",value="/showFriendfile")
public class ShowFriendFilesServlet extends HttpServlet {
    FileDao fileDao=new FileDaoImp();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       /*通过a标签传递过来的好友id，通过好友id查询文件表中该用户的所有文件，并通过request域
       传递到页面上
       * */
        String friendname=request.getParameter("friendid");
        System.out.println("showfriendServlet firendid:"+friendname);
        String sql="select * from filesys where username='"+ friendname+"';";

        List<MyFile> files=fileDao.getFileByUser(sql);
        System.out.println("showfriendServlet filenumber:"+files.size());
        request.setAttribute("friendfiles",files);
        JSONObject json = new JSONObject();
        json.put("length",files.size());
        String filesname="";
        for (int i = 0; i < files.size(); i++) {
            filesname=filesname+" "+files.get(i).getFilename();
        }
        json.put("length",files.size());
        json.put("files",filesname);
        json.put("username",files.get(files.size()-1).getUsername());
        PrintWriter writer= response.getWriter();
        writer.write(json.toJSONString());
        writer.close();

        //request.getRequestDispatcher("/showfriends").forward(request,response);
        /*response.sendRedirect("/showfriends");*/
    }
}
