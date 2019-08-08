package Servlet;

import Dao.FileDao;
import DaoImp.FileDaoImp;
import Entity.MyFile;
import org.json.simple.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

@WebServlet(name = "GetNoteServlet" ,value="/getNote")

public class GetNoteServlet extends HttpServlet {
    FileDao fileDao=new FileDaoImp();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println(request.getParameter("fileid"));
        int fileid=Integer.parseInt(request.getParameter("fileid"));
        System.out.println("进入getnode");
        MyFile file=fileDao.getFileByFileId("select * from filesys where fileid='"+fileid+"';");
        String filePath=request.getServletContext().getRealPath("/")+"uploadFile/";
        String fathdir=filePath+file.getUsername();
        BufferedReader in=new BufferedReader(new FileReader(new File(fathdir,file.getFilename())));
        String string="";
        String temp="";
        while((temp=in.readLine())!=null){
            string=string+temp;
        }
        in.close();
        System.out.println("getnote  note:"+string);


        /*
        任务：根据id，将文件名以及文件里面的内容返回到编辑界面，
        1.根据传入的id，查询数据库，得到用户名（父目录）以及文件名，通过io流得到文件内容。
        2，将文件名以及文件内容已json格式返回到用户页面。设置给编辑器。
        * */

        PrintWriter out=response.getWriter();
        JSONObject json=new JSONObject();
        json.put("message","成功");
        String[] fileps=file.getFilename().split("\\.");
        System.out.println(fileps[0]);
        json.put("filename",fileps[0]);//返回去掉文件后缀的文件名
        json.put("content",string);
        out.write(json.toJSONString());

      /*  request.getRequestDispatcher("/showfiles").forward(request,response);*/
        out.close();
      /*  response.sendRedirect("/showfiles");*/
    }
}
