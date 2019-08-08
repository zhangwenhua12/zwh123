package Entity;

public class Comment {
    private String commentid; //评论ID
    private String commentname; //评论人姓名
    private String commentcontent; //评论内容
    private String commenttime;  //评论时间

    public Comment() {
    }

    public Comment(String commentid, String commentname, String commentcontent, String commenttime) {
        this.commentid = commentid;
        this.commentname = commentname;
        this.commentcontent = commentcontent;
        this.commenttime = commenttime;
    }

    public String getCommentid() {
        return commentid;
    }

    public void setCommentid(String commentid) {
        this.commentid = commentid;
    }

    public String getCommentname() {
        return commentname;
    }

    public void setCommentname(String commentname) {
        this.commentname = commentname;
    }

    public String getCommentcontent() {
        return commentcontent;
    }

    public void setCommentcontent(String commentcontent) {
        this.commentcontent = commentcontent;
    }

    public String getCommenttime() {
        return commenttime;
    }

    public void setCommenttime(String commenttime) {
        this.commenttime = commenttime;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "commentid='" + commentid + '\'' +
                ", commentname='" + commentname + '\'' +
                ", commentcontent='" + commentcontent + '\'' +
                ", commenttime='" + commenttime + '\'' +
                '}';
    }
}