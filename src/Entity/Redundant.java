package Entity;

public class Redundant {
    private String userid;
    private String groupid;
    private int permission;

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getGroupid() {
        return groupid;
    }

    public void setGroupid(String groupid) {
        this.groupid = groupid;
    }

    public int getPermission() {
        return permission;
    }

    public void setPermission(int permission) {
        this.permission = permission;
    }

    @Override
    public String toString() {
        return "Redundant{" +
                "userid='" + userid + '\'' +
                ", groupid='" + groupid + '\'' +
                ", permission=" + permission +
                '}';
    }
}
