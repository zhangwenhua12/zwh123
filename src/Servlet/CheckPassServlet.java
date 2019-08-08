package Servlet;

import Dao.UserDao;
import DaoImp.UserDaoImp;
import Entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(value = "/checklogin")
public class CheckPassServlet extends HttpServlet {
    private UserDao userDao=new UserDaoImp();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name=req.getParameter("Name");
        String  password=req.getParameter("Password");
        User user=userDao.getUAndP("select username,password from user where username='"+name+"';");
        if(user.getPassword().equals(password)){
            User userinfo=userDao.getInfo("select * from user where username='"+name+"';");
            HttpSession session = req.getSession();
            if(session.getAttribute("userinfo")==null||!((User)session.getAttribute("userinfo")).getName().equals(name)) {
                session.setAttribute("userinfo", userinfo);
            }
            /*req.getRequestDispatcher("/showblank").forward(req,resp);*/
           resp.sendRedirect("/showblank");
           /* req.getRequestDispatcher("/WEB-INF/jsp/blank.jsp").forward(req,resp);*///这里不应该直接跳转到主页，应该跳转到一个servlet上，这样就可以在进入主页前
            //进行一些逻辑处理，比如显示添加好友请求提示好友请求。
        }else{
            /*将错误信息返回到登录界面*/
            req.getRequestDispatcher("/WEB-INF/jsp/404jsp");
        }
    }
}
