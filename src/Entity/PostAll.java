package Entity;

public class PostAll {
    String postid;
    String groupid;
    String posterid;
    String posttime;
    String commentnum;
    String topic;
    String content;
    String username;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPostid() {
        return postid;
    }

    public void setPostid(String postid) {
        this.postid = postid;
    }

    public String getGroupid() {
        return groupid;
    }

    public void setGroupid(String groupid) {
        this.groupid = groupid;
    }

    public String getPosterid() {
        return posterid;
    }

    public void setPosterid(String posterid) {
        this.posterid = posterid;
    }

    public String getPosttime() {
        return posttime;
    }

    public void setPosttime(String posttime) {
        this.posttime = posttime;
    }

    public String getCommentnum() {
        return commentnum;
    }

    public void setCommentnum(String commentnum) {
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

    public PostAll() {
    }

    public PostAll(String postid, String groupid, String posterid, String posttime, String commentnum, String topic, String content, String username) {
        this.postid = postid;
        this.groupid = groupid;
        this.posterid = posterid;
        this.posttime = posttime;
        this.commentnum = commentnum;
        this.topic = topic;
        this.content = content;
        this.username = username;
    }

    @Override
    public String toString() {
        return "PostAll{" +
                "postid='" + postid + '\'' +
                ", groupid='" + groupid + '\'' +
                ", posterid='" + posterid + '\'' +
                ", posttime='" + posttime + '\'' +
                ", commentnum='" + commentnum + '\'' +
                ", topic='" + topic + '\'' +
                ", content='" + content + '\'' +
                ", username='" + username + '\'' +
                '}';
    }
}
