package Dao;

import Entity.Schedule;

import java.util.List;

public interface Scheduledao {
    List<Schedule> getAllSchedule();
    List<Schedule> findById(String name);
    int addSchedule(Schedule schedule);
    int updateSchedule(String sql, String studentid,String examname,String update_examname, Object... params);
    Schedule findIdAndName(String studentid,String examname);
    int deleteSchedule(String studentid,String examname);
}
