package Util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class ZJDBCUtil {
    public static ResourceBundle bundle;
    static {
        //默认获取src资源文件，xxx.properties
        //根据文件名获取
        bundle = ResourceBundle.getBundle("db");
    }

    public static Connection getConn(){ String driver=bundle.getString("driver");
        Connection conn=null;
        try {
            Class.forName(bundle.getString("driver"));
            conn= DriverManager.getConnection(bundle.getString("url"),bundle.getString("username"),bundle.getString("password"));
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return  conn;
    }
}
