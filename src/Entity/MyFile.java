package Entity;

import java.util.Date;

public class MyFile {
    private int id;
    private String username;
    private String filename;
    private Double size;
    private Date createtime;

    public MyFile(int id, String username, String filename, Double size, Date createtime) {
        this.id = id;
        this.username = username;
        this.filename = filename;
        this.size = size;
        this.createtime = createtime;
    }

    public MyFile() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public Double getSize() {
        return size;
    }

    public void setSize(Double size) {
        this.size = size;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    @Override
    public String toString() {
        return "MyFile{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", filename='" + filename + '\'' +
                ", size=" + size +
                ", createtime=" + createtime +
                '}';
    }
}
