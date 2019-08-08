package Util;

import java.sql.*;
import java.util.ResourceBundle;

public class LSL_JDBCUtil {
        public static PreparedStatement ps;
        public static Connection connection;
        public static ResultSet rs;
        public static ResourceBundle bundle;

        static {
            bundle = ResourceBundle.getBundle("db");
        }

        public static Connection getConnection() {
            String driver = bundle.getString("driver");
            try {
                Class.forName(driver);
                connection = DriverManager.getConnection(bundle.getString("url"), bundle.getString("username"),
                        bundle.getString("password"));
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return connection;
        }
    }

