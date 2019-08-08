package Dao;
import Entity.Course;
import Entity.User;

import java.util.List;

public interface Coursedao {
   //获取课表信息
   List< Course> getAll(String name);

   //创建课表
   Boolean CreateCouser(String name);
   //删除课表
   Boolean deleteCouser(String name);
   //修改课表
   int updaetCouser(String name,Course course);




}
