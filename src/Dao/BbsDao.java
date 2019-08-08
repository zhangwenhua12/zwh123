package Dao;

import Entity.Admin;
import Entity.Comment;
import Entity.Post;

import java.util.List;

public interface BbsDao {
    List<String> groupQuery(String sql);
    List<Post> postsQuery(String sql);
    List<Comment> commentsQuery(String sql);
    Comment commentQuery(String sql);
    int permissions(String sql);
    Post postQuery(String sql);
    int add(String sql);
    int delete(String sql);
    List<Admin> adminQuery(String sql);
    int Update(String sql);
    String groupid(String sql);
}
