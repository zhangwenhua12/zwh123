package DaoImp;

import Dao.Coursedao;
import Entity.Course;
import Util.ZJDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CousedaoImpl implements Coursedao {
    private Connection conn;
    private PreparedStatement ps;
    private ResultSet rs;
    public CousedaoImpl(){
        conn= ZJDBCUtil.getConn();
    }
    @Override
    public List< Course> getAll(String name) {
        String selcouse_sql="select * from coursetable where studentid=?";
        List<Course> list=new ArrayList<>();
        try {
            ps=conn.prepareStatement(selcouse_sql);
            ps.setString(1,name);
            rs=ps.executeQuery();
            while (rs.next()){
                Course course=new Course();
                course.setClassNo(rs.getInt("classNo"));
                course.setMon(rs.getString("mon"));
                course.setTue(rs.getString("tue"));
                course.setWed(rs.getString("wed"));
                course.setThu(rs.getString("thu"));
                course.setFri(rs.getString("fri"));
                course.setSat(rs.getString("sat"));
                course.setSun(rs.getString("sun"));
                list.add(course);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }


        return list;
    }

    @Override
    public Boolean CreateCouser(String name) {
        String create_sql="insert into coursetable(studentid,classNo) values(?,?)";
        boolean flag=false;
        try {
            ps=conn.prepareStatement(create_sql);
           for(int i=1;i<=5;i++){
               ps.setString(1,name);
               ps.setInt(2,i);
               flag=ps.execute();
           }
           if(flag){
               return flag;
           }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return flag;
    }

    @Override
    public Boolean deleteCouser(String name) {
        boolean flag=false;

        String detele_sql="delete from coursetable where studentid=?";
        try {
            ps=conn.prepareStatement(detele_sql);
            ps.setString(1,name);
            //ps.execute();
            int result=ps.executeUpdate();
            if(result==5){
                flag=true;
                System.out.println("deleIMpl***");
                return flag;
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }
        return flag;
    }

    @Override
    public int updaetCouser(String name,Course course) {
        int result=0;
        String updateCouser_sql="update coursetable set mon=?,tue=?,wed=?,thu=?,fri=?,sat=?,sun=? where studentid=? and classNo=?";
        try {
            ps=conn.prepareStatement(updateCouser_sql);
                ps.setString(1,course.getMon());
                ps.setString(2,course.getTue());
                ps.setString(3,course.getWed());
                ps.setString(4,course.getThu());
                ps.setString(5,course.getFri());
                ps.setString(6,course.getSat());
                ps.setString(7,course.getSun());
                ps.setString(8,name);
                System.out.println("UpdateCouser**"+course.getClassNo());
                ps.setInt(9,course.getClassNo());
                result=ps.executeUpdate();
               return result;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }


}
