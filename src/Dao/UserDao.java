package Dao;

import Entity.User;
import java.util.List;

public interface UserDao {
    User getUAndP(String sql);
    User getInfo(String sql);
}
