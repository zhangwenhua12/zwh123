package Servlet;

import Dao.FileDao;
import DaoImp.FileDaoImp;
import Entity.MyFile;
import Entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ShowEditorServlet",value="/showfiles")
public class ShowEditorServlet extends HttpServlet {
    FileDao fileDao=new FileDaoImp();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //显示富文本编辑器页面，同时将用户的所有的笔记的相关信息查询出来返回到页面。
        HttpSession session=request.getSession();
        String username=((User)session.getAttribute("userinfo")).getUsername();
        String sql="select * from filesys where username='"+ username+"';";

        List<MyFile> files=fileDao.getFileByUser(sql);
        /*System.out.println("查询到的文件个数"+files.size());
        System.out.println("文件详情：");
        for(MyFile file:files){
            System.out.println(file);
        }*/
        request.setAttribute("files",files);
        request.getRequestDispatcher("/WEB-INF/jsp/myeditor.jsp").forward(request,response);
    }
}
