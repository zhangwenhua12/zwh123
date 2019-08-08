package LSL_Servlet.bbsServlet;

import Dao.BbsDao;
import factory.factory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/deletepost")
public class deletePostServlet extends HttpServlet {
    BbsDao bbsDao;

    public deletePostServlet() {
        bbsDao = factory.getInstance("bbsdao", BbsDao.class);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String postid = request.getParameter("postid");
        String del_sql = "delete from post where postid = '" + postid +"';";
        String delete_sql = "delete from comment where postid = '"+postid + "';";
        int result1 = bbsDao.delete(delete_sql);
        int result = bbsDao.delete(del_sql);
        if (result != 0&&result1!=0) {
            System.out.println("删除成功!");
            request.getRequestDispatcher("bbs_index.do").forward(request, response);
        } else {
            System.out.println("我也不知道啥子错!");
        }
    }
}
