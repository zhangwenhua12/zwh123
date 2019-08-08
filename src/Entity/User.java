package Entity;

public class User {
    private String username;
    private String password;
    private String name;
    private String sex;
    private String collage;
    private String major;
    private int grade;
    private int classno;
    private String phone;
    private String email;
    private String introduce;
    private int identity;
    private int isPhoneS;
    private int isEmailS;

    public User() {
    }

    public User(String username, String password, String name, String sex, String collage, String major, int grade, int classno, String phone, String email, String introduce, int identity, int isPhoneS, int isEmailS) {

        this.username = username;
        this.password = password;
        this.name = name;
        this.sex = sex;
        this.collage = collage;
        this.major = major;
        this.grade = grade;
        this.classno = classno;
        this.phone = phone;
        this.email = email;
        this.introduce = introduce;
        this.identity = identity;
        this.isPhoneS = isPhoneS;
        this.isEmailS = isEmailS;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getCollage() {
        return collage;
    }

    public void setCollage(String collage) {
        this.collage = collage;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public int getClassno() {
        return classno;
    }

    public void setClassno(int classno) {
        this.classno = classno;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }

    public int getIdentity() {
        return identity;
    }

    public void setIdentity(int identity) {
        this.identity = identity;
    }

    public int getIsPhoneS() {
        return isPhoneS;
    }

    public void setIsPhoneS(int isPhoneS) {
        this.isPhoneS = isPhoneS;
    }

    public int getIsEmailS() {
        return isEmailS;
    }

    public void setIsEmailS(int isEmailS) {
        this.isEmailS = isEmailS;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", collage='" + collage + '\'' +
                ", major='" + major + '\'' +
                ", grade=" + grade +
                ", classno=" + classno +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", introduce='" + introduce + '\'' +
                ", identity=" + identity +
                ", isPhoneS=" + isPhoneS +
                ", isEmailS=" + isEmailS +
                '}';
    }
}
