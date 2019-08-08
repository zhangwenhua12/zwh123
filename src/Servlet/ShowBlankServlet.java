package Servlet;

import Dao.FriendDao;
import DaoImp.FriendDaoImp;
import Entity.Friend;
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

@WebServlet(name = "ShowBlankServlet",value="/showblank")
public class ShowBlankServlet extends HttpServlet {

    private FriendDao friendDao=new FriendDaoImp();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //显示主页之前，可能有很多好提前做好的逻辑，现在第一点就是显示别人的请求好友消息提示。
        List<Friend> list=new ArrayList<>();
        HttpSession session=request.getSession();
        String username=((User)session.getAttribute("userinfo")).getUsername();
        list=friendDao.getAllFriend("select * from relationship where userid='"+username+"' and relationstate="+1+";");
        System.out.println(list.size());
        for(Friend friend:list){
            System.out.println(friend);
        }
        session.setAttribute("req",list);//将请求好友消息放在session中。

        request.getRequestDispatcher("/WEB-INF/jsp/blank.jsp").forward(request,response);

    }
}
