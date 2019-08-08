package Dao;

import Entity.User;

public interface ZUserdao {
    User updateUser(User user);
    int updateMember(String sql,String username, Object... params);
    //增加用户
    boolean InsertUser(User user);
    //根据用户名查找用户
    boolean findname(String name);


}
