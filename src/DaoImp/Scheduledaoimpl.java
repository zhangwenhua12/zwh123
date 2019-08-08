package DaoImp;

import Dao.Scheduledao;
import Entity.Schedule;
import Util.LSL_JDBCUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Scheduledaoimpl implements Scheduledao {
    private PreparedStatement ps;
    private Connection connection;
    private ResultSet rs;

    public Scheduledaoimpl() {
        connection = LSL_JDBCUtil.getConnection();
    }

    public List<Schedule> getAllSchedule() {
        List<Schedule> list = new ArrayList<>();
        try {
            ps = connection.prepareStatement("select * from examschedule");
            rs = ps.executeQuery();
            while (rs.next()) {
                Schedule schedule = new Schedule();
                schedule.setStudentid(rs.getString("studentid"));
                schedule.setExamname(rs.getString("examname"));
                schedule.setExamtime(rs.getString("examtime"));
                schedule.setRemark(rs.getString("remark"));
                schedule.setExamplace(rs.getString("examplace"));
                schedule.setCreatetime(rs.getString("createtime"));
                list.add(schedule);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public List<Schedule> scheduleSet(String sql, Object... params) {
        List<Schedule> list = new ArrayList<>();
        try {
            ps = connection.prepareStatement(sql);
            for (int i = 0; i < params.length; i++) {
                ps.setObject((i + 1), params[i]);
            }
            rs = ps.executeQuery();
            while (rs.next()) {
                Schedule schedule = new Schedule();
                schedule.setStudentid(rs.getString("studentid"));
                schedule.setExamname(rs.getString("examname"));
                schedule.setRemark(rs.getString("remark"));
                schedule.setExamtime(rs.getString("examtime"));
                schedule.setExamplace(rs.getString("examplace"));
                schedule.setCreatetime(rs.getString("createtime"));
                list.add(schedule);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public List<Schedule> findById(String name) {
        String find_sql = "select * from examschedule where studentid = ?";
        return scheduleSet(find_sql, name);
    }

    public Schedule findIdAndName(String studentid, String examname) {
        String sql = "select * from examschedule where studentid = ? and examname = ?";
        try {
            ps = connection.prepareStatement(sql);
            ps.setString(1, studentid);
            ps.setString(2, examname);
            rs = ps.executeQuery();
            if (rs.next()) {
                Schedule schedule = new Schedule();
                schedule.setStudentid(rs.getString("studentid"));
                schedule.setRemark(rs.getString("remark"));
                schedule.setExamname(rs.getString("examname"));
                schedule.setExamtime(rs.getString("examtime"));
                schedule.setCreatetime(rs.getString("createtime"));
                schedule.setExamplace(rs.getString("examplace"));
                return schedule;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
/*    public Schedule loginSchedule(String name, String pwd) {
        String login_sql = "select * from examschedule where logname = ? and password = ?";
        return memberSet(login_sql, name, pwd);
    }*/

    public int addSchedule(Schedule schedule) {
        int result = 0;
        String register_sql = "insert into examschedule(studentid,examname,examtime,remark,examplace,createtime) values(?,?,?,?,?,?)";
        Schedule  schedule1 = findIdAndName(schedule.getStudentid(),schedule.getExamname());
            if (schedule1 == null) {
                try {
                    ps = connection.prepareStatement(register_sql);
                    ps.setString(1, schedule.getStudentid());
                    ps.setString(2, schedule.getExamname());
                    ps.setString(3, schedule.getExamtime());
                    ps.setString(4, schedule.getRemark());
                    ps.setString(5, schedule.getExamplace());
                    ps.setString(6, schedule.getCreatetime());
                    result = ps.executeUpdate();
//            }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        return result;
    }

    public int updateSchedule(String sql, String studentid, String examname,String update_examname, Object... params) {
        int result = 0;
        System.out.println(3);
        System.out.println(examname);
        System.out.println(update_examname);
        if(!examname.equals(update_examname)) {
            Schedule schedule = findIdAndName(studentid, update_examname);
            if (schedule == null) {
                try {
                    System.out.println(2);
                    ps = connection.prepareStatement(sql);
                    ps.setString(1,update_examname);
                    for (int i = 0; i < params.length; i++) {
                        ps.setObject((i + 2), params[i]);
                    }
                    ps.setString((params.length + 2), studentid);
                    ps.setString(params.length + 3,examname);
                    result = ps.executeUpdate();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }else {
            try {
                System.out.println(1);
                ps = connection.prepareStatement(sql);
                ps.setString(1,update_examname);
                for (int i = 0; i < params.length; i++) {
                    ps.setObject(i + 2, params[i]);
                }
                ps.setString((params.length + 2), studentid);
                ps.setString((params.length + 3), examname);
                System.out.println(ps);
                result = ps.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    public int deleteSchedule(String studentid, String examname) {
        int result = 0;
        String del_sql = "delete from examschedule where studentid =? and examname = ?";
        try {
            ps = connection.prepareStatement(del_sql);
            ps.setString(1, studentid);
            ps.setString(2, examname);
            result = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
/*    public List<Member> find(int page) {
        List<Member> list = new ArrayList<>();
        String find_sql = "select * from examschedule order by pic asc limit ?,?";
        try {
            ps = connection.prepareStatement(find_sql);
            ps.setInt(1, ((page - 1) * Member.PAGE_SIZE));
            ps.setInt(2, Member.PAGE_SIZE);
            rs = ps.executeQuery();
            while (rs.next()) {
                Member member = new Member();
                member.setName(rs.getString("logname"));
                member.setPwd(rs.getString("password"));
                member.setPhone(rs.getString("phone"));
                member.setEmail((rs.getString("email")));
                member.setIntroduce(rs.getString("message"));
                member.setPic(rs.getString("pic"));
                list.add(member);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public int findCount() {
        int count = 0;
        String sql = "select count(*) from examschedule";
        try {
            Statement statement = connection.createStatement();
            rs = statement.executeQuery(sql);
            if (rs.next()) {
                count = rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }*/
}

