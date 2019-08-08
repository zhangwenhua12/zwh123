package DaoImp;

import Dao.FriendDao;
import Entity.Friend;
import Util.JdbcUtil;
import Util.StatementCallback;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class FriendDaoImp implements FriendDao {
    private JdbcUtil util=new JdbcUtil();
    @Override
    public Friend getOneFriend(String sql) {
        return (Friend) util.executeQuery(new StatementCallback() {
            @Override
            public Object doYourStatement(Statement statement) throws SQLException {
                ResultSet rs=statement.executeQuery(sql);
                rs.next();
                Friend friend=new Friend();
                friend.setFriendid(rs.getString("friendid"));
                friend.setUserid(rs.getString("userid"));
                friend.setRelationstate(rs.getInt("relationstate"));
                return friend;
            }
        });

    }

    @Override
    public List<Friend> getAllFriend(String sql) {


        return (List<Friend>)util.executeQuery(new StatementCallback() {
            @Override
            public Object doYourStatement(Statement statement) throws SQLException {
                List<Friend> list=new ArrayList<>();
                ResultSet rs=statement.executeQuery(sql);
                while(rs.next()){
                    Friend friend=new Friend(rs.getString("userid"),rs.getString("friendid"),rs.getInt("relationstate"));
                    list.add(friend);
                }
                return list;
            }
        });
    }

    @Override
    public boolean changeRelationship(String sql) {

        return (boolean)util.executeQuery(new StatementCallback() {
            @Override
            public Object doYourStatement(Statement statement) throws SQLException {
                return statement.execute(sql);
            }
        });
    }
}
