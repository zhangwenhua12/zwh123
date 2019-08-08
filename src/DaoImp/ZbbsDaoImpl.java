package DaoImp;

import Dao.ZbbsDao;
import Entity.PostAll;
import Util.ZJDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ZbbsDaoImpl implements ZbbsDao {
    private Connection conn;
    private PreparedStatement ps;
    private ResultSet rs;
    public ZbbsDaoImpl(){
        conn= ZJDBCUtil.getConn();
    }
    @Override
    public List findGroupname(String sql) {
        List list=new ArrayList();
        try {
            ps=conn.prepareStatement(sql);
            rs=ps.executeQuery();
            while (rs.next()){
                list.add(rs.getString("groupname"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public List<PostAll> findPostAll(String sql) {
        List<PostAll> list=new ArrayList<>();

        try {
            ps=conn.prepareStatement(sql);
            rs=ps.executeQuery();
            while (rs.next()){
                PostAll postAll=new PostAll();
                postAll.setPosterid(rs.getString("posterid"));
                postAll.setPosttime(rs.getString("posttime"));
                postAll.setTopic(rs.getString("topic"));
                postAll.setContent(rs.getString("content"));
                postAll.setUsername(rs.getString("name"));
                list.add(postAll);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
