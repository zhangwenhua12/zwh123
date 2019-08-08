package Util;

import java.sql.*;

public class JdbcUtil {
    private Statement sm=null;

    public final Object executeQuery(StatementCallback statcall) {
        Connection con= null;
        Object result=null ;
        try {
            con = ConnectionFactory.getInstance().getConnection();
            sm=con.createStatement();
            result=statcall.doYourStatement(sm);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                sm.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return result;
    }
}
