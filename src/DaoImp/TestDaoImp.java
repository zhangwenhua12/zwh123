package DaoImp;

import Dao.DaoTest;
import Entity.User;
import Util.JdbcUtil;
import Util.StatementCallback;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class TestDaoImp implements DaoTest{
    JdbcUtil jdbcUtil=new JdbcUtil();
    @Override
    public List<User> getString() {
        String sql="select * from user";
        List<User> list= new ArrayList<>();
        User user=new User();
        jdbcUtil.executeQuery(new StatementCallback() {
            @Override
            public Object doYourStatement(Statement statement) throws SQLException {
                ResultSet resultSet=statement.executeQuery(sql);
                while(resultSet.next()){
                    user.setUsername(resultSet.getString("username"));
                    user.setPassword(resultSet.getString("password"));
                    user.setName(resultSet.getString("name"));
                    user.setSex(resultSet.getString("sex"));
                    list.add(user);
                }
                return list;
            }

        });
        return list;
    }
}
