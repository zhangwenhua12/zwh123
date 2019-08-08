package DaoImp;

import Dao.ZUserdao;
import Entity.User;
import Util.ZJDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ZUserdaoImpl implements ZUserdao {
    private Connection conn;
    private PreparedStatement ps;
    private ResultSet rs;
    public ZUserdaoImpl(){
        conn= ZJDBCUtil.getConn();
    }
    public int updateMember(String sql,String username, Object... params) {
        int result = 0;
        try {
                ps = conn.prepareStatement(sql);
                for (int i = 0; i < params.length; i++) {
                    ps.setObject((i + 1), params[i]);
                }
                ps.setString((params.length+1),username);
                result = ps.executeUpdate();
            System.out.println(result);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 注册用户
     * @param user
     * @return
     */

    @Override
    public boolean InsertUser(User user) {
        int result=0;
        String insert_sql="insert into user(username,password,name,sex,collage,major,grade,classno,phone,email) values(?,?,?,?,?,?,?,?,?,?)";
        try {
            ps=conn.prepareStatement(insert_sql);
            ps.setString(1,user.getUsername());
            ps.setString(2,user.getPassword());
            ps.setString(3,user.getName());
            ps.setString(4,user.getSex());
            ps.setString(5,user.getCollage());
            ps.setString(6,user.getMajor());
            ps.setInt(7,user.getGrade());
            ps.setInt(8,user.getClassno());
            ps.setString(9,user.getPhone());
            ps.setString(10,user.getEmail());
            result=ps.executeUpdate();
            if (result>0){
                return true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * 根据用户名查找
     * @param name
     * @return
     */
    @Override
    public boolean findname(String name) {
        String getlogname_sql="select * from user where username=?";
        try {
            ps=conn.prepareStatement(getlogname_sql);
            ps.setString(1,name);
            rs=ps.executeQuery();
            System.out.println(rs);
            if (rs.next()){
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }


    @Override
    public User updateUser(User user) {
        int r;
        String update_sql="update user(name,sex,collage,grade,major,classno,phone,email) set name=?,sex=?,collage=?,grade=?,major=?,classno=?,phone=?,email=? where username=?";
        try{
            ps=conn.prepareStatement(update_sql);
            ps.setString(1,user.getName());
            ps.setString(2,user.getSex());
            ps.setString(3,user.getCollage());
            ps.setInt(4,user.getGrade());
            ps.setString(5,user.getMajor());
            ps.setInt(6,user.getClassno());
            ps.setString(7,user.getPhone());
            ps.setString(8,user.getEmail());
            ps.setString(9,user.getUsername());
            r=ps.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }

        return null;
    }
}
