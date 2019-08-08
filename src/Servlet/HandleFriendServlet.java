package Servlet;

import Dao.FriendDao;
import DaoImp.FriendDaoImp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "HandleFriendServlet",value="/handlefriend")
public class HandleFriendServlet extends HttpServlet {
    FriendDao friendDao=new FriendDaoImp();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /*得到用户id，好友id以及结果，根据结果，进行对数据库的操作。
        if是yes：将关系表中的相应的记录标识改为2，同时，添加一条记录{请求好友id，好友id，用户记录}
        if是no：就删除该条记录。
        转发到ShowBlankServlet上。
        * */
        String friendid=request.getParameter("friendid");
        String userid=request.getParameter("userid");
        String ans=request.getParameter("ans");
        System.out.println("HandleFriend: friendid:"+friendid+" userid:"+userid+" ans:"+ans);
        String sqlyes="update relationship set relationstate="+2+" where friendid='"+friendid+"' and userid='"+userid+"';";
        String insert="insert into relationship (userid,friendid,relationstate) values ('"+friendid+"','"+userid+"',"+2+");";
        String deletfriend="delete relationship where friendid='"+friendid+"' and userid='"+userid+"';";

        if(ans.equals("yes")){
            friendDao.changeRelationship(sqlyes);
            friendDao.changeRelationship(insert);
        }else{
            friendDao.changeRelationship(deletfriend);
        }

        request.getRequestDispatcher("/showblank").forward(request,response);

    }
}
