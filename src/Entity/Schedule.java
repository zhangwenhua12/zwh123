package Entity;

/**
 * 考试安排实体类
 */
public class Schedule {
    private String studentid; //学生ID
    private String examname;  //考试名称(一般为英文简写)
    private String examtime;  //考试时间
    private String remark;  //考试备注
    private String examplace; //考试地点
    private String createtime;  //创建该安排的时间

    public Schedule() {
    }

    public Schedule(String studentid, String examname, String examtime, String remark, String examplace, String createtime) {
        this.studentid = studentid;
        this.examname = examname;
        this.examtime = examtime;
        this.remark = remark;
        this.examplace = examplace;
        this.createtime = createtime;
    }

    public String getStudentid() {
        return studentid;
    }

    public void setStudentid(String studentid) {
        this.studentid = studentid;
    }

    public String getExamname() {
        return examname;
    }

    public void setExamname(String examname) {
        this.examname = examname;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getExamplace() {
        return examplace;
    }

    public void setExamplace(String examplace) {
        this.examplace = examplace;
    }

    public String getCreatetime() {
        return createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime;
    }

    public String getExamtime() {
        return examtime;
    }

    public void setExamtime(String examtime) {
        this.examtime = examtime;
    }

    @Override
    public String toString() {
        return "Schedule{" +
                "studentid='" + studentid + '\'' +
                ", examname='" + examname + '\'' +
                ", examtime='" + examtime + '\'' +
                ", remark='" + remark + '\'' +
                ", examplace='" + examplace + '\'' +
                ", createtime='" + createtime + '\'' +
                '}';
    }
}
