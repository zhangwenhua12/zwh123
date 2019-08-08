package DaoImp;

import Dao.UserDao;
import Entity.User;
import Util.JdbcUtil;
import Util.StatementCallback;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UserDaoImp implements UserDao {
    JdbcUtil util=new JdbcUtil();
    @Override
    public User getUAndP(String sql) {
        return (User)util.executeQuery(new StatementCallback() {
            @Override
            public Object doYourStatement(Statement statement) throws SQLException {
                ResultSet rs=statement.executeQuery(sql);
                User user=new User();
                if(rs.next()) {
                    user.setUsername(rs.getString("username"));
                    user.setPassword(rs.getString("password"));
                }
                return user;
            }
        });
    }

    @Override
    public User getInfo(String sql) {
        return (User)util.executeQuery(new StatementCallback() {
            @Override
            public Object doYourStatement(Statement statement) throws SQLException {
                ResultSet rs=statement.executeQuery(sql);
                rs.next();
                return new User(
                        rs.getString("username"),
                        rs.getString("password"),
                        rs.getString("name"),
                        rs.getString("sex"),
                        rs.getString("collage"),
                        rs.getString("major"),
                        rs.getInt("grade"),
                        rs.getInt("classno"),
                        rs.getString("phone"),
                        rs.getString("email"),
                        rs.getString("introduction"),
                        rs.getInt("identity"),
                        rs.getInt("isphonesecret"),
                        rs.getInt("ismailsecret")
                );
            }
        });
    }
}
