package Dao;

import Entity.MyFile;

import java.io.File;
import java.util.List;

public interface FileDao {
    MyFile getFileByUserAndFname(String sql);
    List<MyFile> getFileByUser(String sql);
    MyFile getFileByFileId(String sql);
    boolean insetone(String sql);
    boolean updateByFileId(String sql);
}
