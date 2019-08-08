package Servlet;

import Dao.FriendDao;
import Dao.UserDao;
import DaoImp.FriendDaoImp;
import DaoImp.UserDaoImp;
import Entity.User;
import org.json.simple.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "CheckUsernameServlet",value={"/checkUsername","/addfriend"})
public class CheckUsernameServlet extends HttpServlet {
    UserDao userDao=new UserDaoImp();
    FriendDao friendDao=new FriendDaoImp();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /*
        * 发送好友请求，根据用户id和发送过来的好友id，
        * 在relationship表中插入一行(好友id,用户id,1)
        * 跳转回
        * 如果插入成功，提示用户提示用户好友请求发送成功。
        * */
        String friendid=request.getParameter("friendid");
        String username=((User)request.getSession().getAttribute("userinfo")).getUsername();
        String sql="insert into relationship (userid,friendid,relationstate) values('"+friendid+"','"+username+"',"+1+");";
        boolean flag=friendDao.changeRelationship(sql);
        JSONObject json=new JSONObject();
        if(flag==true){
            json.put("message","yes");
        }else{
            json.put("message","no");
        }
        PrintWriter out=response.getWriter();
        out.write(json.toJSONString());
        request.getRequestDispatcher("/WEB-INF/jsp/friend.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
           /*
        通过input框输入的用户名，查询user表是否存在该用户，如果不存在给出提示
        * */
       /* request.getRequestDispatcher("/WEB-INF/jsp/")//直接跳转回去就是了*/
        String inputuname=request.getParameter("friendid");
        String sql="select * from user where username='"+inputuname+"';";
        User user=userDao.getUAndP(sql);
        JSONObject json=new JSONObject();
        if(user.getUsername()==null){
            json.put("message","不存在用户");
        }else{
            json.put("message","");
        }
        PrintWriter  out=response.getWriter();
        out.write(json.toJSONString());
       /* request.getRequestDispatcher("/WEB-INF/jsp/friend.jsp").forward(request,response);*/
        out.close();
    }
}
