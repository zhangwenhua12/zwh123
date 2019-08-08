package DaoImp;

import Dao.FileDao;
import Entity.MyFile;
import Util.JdbcUtil;
import Util.StatementCallback;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class FileDaoImp implements FileDao {
    JdbcUtil util=new JdbcUtil();

    @Override
    public MyFile getFileByUserAndFname(String sql) {
        return (MyFile)util.executeQuery(new StatementCallback() {
            @Override
            public Object doYourStatement(Statement statement) throws SQLException {
                ResultSet rs= statement.executeQuery(sql);
                if(rs.next()){
                    return new MyFile(rs.getInt("fileid"),rs.getString("username"),rs.getString("filename"),rs.getDouble("size"),rs.getDate("createtime"));
                }else {
                    return null;
                }
            }
        });
    }

    @Override
    public List<MyFile> getFileByUser(String sql) {

        return (List<MyFile>) util.executeQuery(new StatementCallback() {
            List<MyFile> list=new ArrayList<>();
            @Override
            public Object doYourStatement(Statement statement) throws SQLException {
                ResultSet rs= statement.executeQuery(sql);
                while(rs.next()){
                     list.add(new MyFile(rs.getInt("fileid"),rs.getString("username"),rs.getString("filename"),rs.getDouble("size"),rs.getDate("createtime")));
                }
                return list;
            }
        });
    }

    @Override
    public MyFile getFileByFileId(String sql) {
        return (MyFile)util.executeQuery(new StatementCallback() {
            @Override
            public Object doYourStatement(Statement statement) throws SQLException {
                ResultSet rs= statement.executeQuery(sql);
                if(rs.next()){
                    return new MyFile(rs.getInt("fileid"),rs.getString("username"),rs.getString("filename"),rs.getDouble("size"),rs.getDate("createtime"));
                }else {
                    return null;
                }
            }
        });
    }

    @Override
    public boolean insetone(String sql) {
        return (boolean)util.executeQuery(new StatementCallback() {
            @Override
            public Object doYourStatement(Statement statement) throws SQLException {
                return statement.execute(sql);
            }
        });
    }

    @Override
    public boolean updateByFileId(String sql) {
        return (boolean)util.executeQuery(new StatementCallback() {
            @Override
            public Object doYourStatement(Statement statement) throws SQLException {
                return statement.execute(sql);
            }
        });
    }
}
