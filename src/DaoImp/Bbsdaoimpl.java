package DaoImp;

import Dao.BbsDao;
import Entity.Admin;
import Entity.Comment;
import Entity.Post;
import Util.LSL_JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Bbsdaoimpl implements BbsDao {
    private PreparedStatement ps;
    private Connection connection;
    private ResultSet rs;

    //创建数据库连接
    public Bbsdaoimpl() {
        connection = LSL_JDBCUtil.getConnection();
    }

    /**
     * 对群组进行查询,返回List
     *
     * @param sql
     * @return
     */
    public List<String> groupQuery(String sql) {
        List<String> list = new ArrayList();
        try {
            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(rs.getString("groupname"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    /**
     * 查询多个帖子,返回List
     *
     * @param sql
     * @return
     */
    public List<Post> postsQuery(String sql) {
        List<Post> list = new ArrayList<>();
        try {
            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Post post = new Post();
                post.setPosterName(rs.getString("name"));
                post.setTopic(rs.getString("topic"));
                post.setCommentnum(rs.getInt("commentnum"));
                post.setContent(rs.getString("content"));
                post.setGroupid(rs.getString("groupid"));
                post.setPosttime(rs.getString("posttime"));
                post.setPostid(rs.getString("postid"));
                list.add(post);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    /**
     * 查询单个帖子,返回Post对象
     *
     * @param sql
     * @return
     */
    public Post postQuery(String sql) {
        Post post = new Post();
        try {
            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();
            if (rs.next()) {
                post.setPosterName(rs.getString("name"));
                post.setContent(rs.getString("content"));
                post.setTopic(rs.getString("topic"));
                post.setCommentnum(rs.getInt("commentnum"));
                post.setPosttime(rs.getString("posttime"));
                post.setGroupid(rs.getString("groupid"));
                post.setPostid(rs.getString("postid"));
                return post;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    /**
     * 查询多个评论,返回List
     *
     * @param sql
     * @return
     */
    public List<Comment> commentsQuery(String sql) {
        List<Comment> list = new ArrayList<>();
        try {
            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Comment comment = new Comment();
                comment.setCommentid(rs.getString("commentid"));
                comment.setCommentname(rs.getString("name"));
                comment.setCommentcontent(rs.getString("commentcontent"));
                comment.setCommenttime(rs.getString("commenttime"));
                list.add(comment);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    /**
     * 查询单个评论,返回Comment对象
     *
     * @param sql
     * @return
     */
    public Comment commentQuery(String sql) {
        Comment comment = new Comment();
        try {
            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();
            if (rs.next()) {
                comment.setCommentid(rs.getString("commentid"));
                comment.setCommentname(rs.getString("name"));
                comment.setCommentcontent(rs.getString("commentcontent"));
                comment.setCommenttime(rs.getString("commenttime"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return comment;
    }

    /**
     * 查询某人群组的权限，返回权限值
     *
     * @param sql
     * @return
     */
    public int permissions(String sql) {
        int result = 0;
        try {
            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();
            if (rs.next()) {
                result = rs.getInt("permissions");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 获取groupid,返回群组ID
     * @param sql
     * @return
     */
    public String groupid(String sql){
        String result = null;
        try {
            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();
            if(rs.next()){
                result = rs.getString("groupid");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
    /**
     * 增加操作,返回result(成功返回1，失败返回0)
     *
     * @param sql
     * @return
     */
    public int add(String sql) {
        int result = 0;
        try {
            ps = connection.prepareStatement(sql);
            result = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 删除操作,返回result(成功返回1，失败返回0)
     *
     * @param sql
     * @return
     */
    public int delete(String sql) {
        int result = 0;
        try {
            ps = connection.prepareStatement(sql);
            result = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 查询多个管理员,返回List
     *
     * @param sql
     * @return
     */
    public List<Admin> adminQuery(String sql) {
        List<Admin> list = new ArrayList<>();
        try {
            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Admin admin = new Admin();
                admin.setAdminid(rs.getString("userid"));
                admin.setAdminName(rs.getString("name"));
                admin.setGroupid(rs.getString("groupid"));
                admin.setGroupname(rs.getString("groupname"));
                list.add(admin);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    /**
     * 修改操作,返回result(成功返回1，失败返回0)
     *
     * @param sql
     * @return
     */
    public int Update(String sql) {
        int result = 0;
        try {
            ps = connection.prepareStatement(sql);
            result = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
}
