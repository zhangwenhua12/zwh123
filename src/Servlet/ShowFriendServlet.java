package Servlet;

import Dao.FriendDao;
import DaoImp.FriendDaoImp;
import Entity.Friend;
import Entity.MyFile;
import Entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "ShowFriendServlet",value="/showfriends")
public class ShowFriendServlet extends HttpServlet {
    FriendDao friendDao=new FriendDaoImp();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /*点击我的好友按钮之后，需要根据用户查到他的所有好友，也就是状态为2的，一一列出，
        * */
        HttpSession session=request.getSession();
        User user=(User)session.getAttribute("userinfo");
        String sql="select * from relationship where userid='"+user.getUsername()+"' and relationstate="+2+";";
        List<Friend> list=new ArrayList<>();
        list=friendDao.getAllFriend(sql);
        if(request.getAttribute("friendfiles")!=null) {
            for (MyFile file : (List<MyFile>) request.getAttribute("friendfiles")) {
                System.out.println("showfriend :file"+file);
            }
        }
        request.setAttribute("friends",list);
        request.getRequestDispatcher("/WEB-INF/jsp/friend.jsp").forward(request,response);

    }
}
