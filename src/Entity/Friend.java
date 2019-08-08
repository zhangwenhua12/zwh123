package Entity;

public class Friend {
    private String userid;
    private String friendid;
    private int relationstate;

    public Friend(String userid, String friendid, int relationstate) {
        this.userid = userid;
        this.friendid = friendid;
        this.relationstate = relationstate;
    }

    public Friend() {
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getFriendid() {
        return friendid;
    }

    public void setFriendid(String friendid) {
        this.friendid = friendid;
    }

    public int getRelationstate() {
        return relationstate;
    }

    public void setRelationstate(int relationstate) {
        this.relationstate = relationstate;
    }

    @Override
    public String toString() {
        return "Friend{" +
                "userid='" + userid + '\'' +
                ", friendid='" + friendid + '\'' +
                ", relationstate=" + relationstate +
                '}';
    }
}
