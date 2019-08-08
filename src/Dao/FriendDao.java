package Dao;

import Entity.Friend;

import java.util.List;

public interface FriendDao {
    Friend getOneFriend(String sql);
    List<Friend> getAllFriend(String sql);
    boolean changeRelationship(String sql);
}
