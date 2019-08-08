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
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "CheckFileNameServlet",value="/checkfilename")
public class CheckFileNameServlet extends HttpServlet {
    FileDao fileDao=new FileDaoImp();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username=request.getParameter("username");
        String filename=request.getParameter("filename");
        System.out.println("checkfilename:  username"+username);
        System.out.println("checkfilename: filename"+filename);
        String sql="select * from filesys where username='"+username+"';";
        List<MyFile> files=fileDao.getFileByUser(sql);
        boolean flag=false;

        for( MyFile file:files){//检查文件名是否冲突
            System.out.println(file.getFilename()+"检查文件冲突"+filename+".html");
            String string=filename+".html";
            if(file.getFilename().equals(string)){
                flag=true;
                break;
            }
        }

        System.out.println("checkfilename:  flag:"+flag);
        JSONObject jsonobj=new JSONObject();
        if(flag){
            jsonobj.put("message", "该文件已存在，提交将会覆盖");
        }else{
            jsonobj.put("message","");
        }

        PrintWriter out=response.getWriter();
        out.print(jsonobj.toJSONString());
        out.close();
    }
}
