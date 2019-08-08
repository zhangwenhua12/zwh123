package Dao;

import Entity.PostAll;

import java.util.List;

public interface ZbbsDao {
    //通过用户id获取分组名字
    List findGroupname(String sql);
    //通过用户分组名字获取贴子
    List<PostAll> findPostAll(String sql);
    //
}
