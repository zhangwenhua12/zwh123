package Util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
    private String classDriverName="com.mysql.cj.jdbc.Driver";
    private String url="jdbc:mysql://localhost:3306/stuhelp?characterEncoding=utf8&useSSL=false&serverTimezone=UTC&rewriteBatchedStatements=true";
    private String username="root";
    private String password="123456";
    private static ConnectionFactory connectionFactory=null;

    private ConnectionFactory(){
        try {
            Class.forName(classDriverName);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static ConnectionFactory getInstance(){
        if(null==connectionFactory){
            connectionFactory=new ConnectionFactory();
        }
        return connectionFactory;
    }

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url,username,password);
    }
}
