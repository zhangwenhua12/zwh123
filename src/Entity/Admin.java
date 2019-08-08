package Entity;

public class Admin {
    private String adminName;//管理员姓名
    private String adminid;//管理员ID
    private String groupid;//群组ID
    private String groupname;//群组名称

    public Admin() {
    }

    public Admin(String adminName, String adminid, String groupid, String groupname) {
        this.adminName = adminName;
        this.adminid = adminid;
        this.groupid = groupid;
        this.groupname = groupname;
    }

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    public String getAdminid() {
        return adminid;
    }

    public void setAdminid(String adminid) {
        this.adminid = adminid;
    }

    public String getGroupid() {
        return groupid;
    }

    public void setGroupid(String groupid) {
        this.groupid = groupid;
    }

    public String getGroupname() {
        return groupname;
    }

    public void setGroupname(String groupname) {
        this.groupname = groupname;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "adminName='" + adminName + '\'' +
                ", adminid='" + adminid + '\'' +
                ", groupid='" + groupid + '\'' +
                ", groupname='" + groupname + '\'' +
                '}';
    }
}
