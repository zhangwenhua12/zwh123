package Entity;

public class Post {
    private String posterName; //发帖人姓名
    private String posttime;  //发帖时间
    private int commentnum;  //评论数量
    private String topic;  //帖子标题
    private String content;   //帖子内容
    private String groupid;  //群组ID
    private String postid; //帖子ID

    public Post() {
    }

    public Post(String posterName, String posttime, int commentnum, String topic, String content, String groupid, String postid) {
        this.posterName = posterName;
        this.posttime = posttime;
        this.commentnum = commentnum;
        this.topic = topic;
        this.content = content;
        this.groupid = groupid;
        this.postid = postid;
    }

    public String getPosterName() {
        return posterName;
    }

    public void setPosterName(String posterName) {
        this.posterName = posterName;
    }

    public String getPosttime() {
        return posttime;
    }

    public void setPosttime(String posttime) {
        this.posttime = posttime;
    }

    public int getCommentnum() {
        return commentnum;
    }

    public void setCommentnum(int commentnum) {
        this.commentnum = commentnum;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getGroupid() {
        return groupid;
    }

    public void setGroupid(String groupid) {
        this.groupid = groupid;
    }

    public String getPostid() {
        return postid;
    }

    public void setPostid(String postid) {
        this.postid = postid;
    }

    @Override
    public String toString() {
        return "Post{" +
                "posterName='" + posterName + '\'' +
                ", posttime='" + posttime + '\'' +
                ", commentnum=" + commentnum +
                ", topic='" + topic + '\'' +
                ", content='" + content + '\'' +
                ", groupid='" + groupid + '\'' +
                ", postid='" + postid + '\'' +
                '}';
    }
}