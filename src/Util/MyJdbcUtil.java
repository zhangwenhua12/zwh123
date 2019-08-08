package Util;

import java.lang.reflect.Field;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class MyJdbcUtil {


    /*private static JdbcUtil util=new JdbcUtil();

    public static Object selectOne(String sql,Class type){

    }

    public static Object selectmany(String sql,Class type)  {

        try {
            return util.executeQuery(new StatementCallback() {
                List list=new ArrayList();
                Object obj=type.newInstance();
                Field[] fields=type.getDeclaredFields();
                @Override
                public Object doYourStatement(Statement statement) throws SQLException {
                    ResultSet rs=statement.executeQuery(sql);
                    while(rs.next()){
                        list.add(obj)
                    }
                    return null;
                }
            })
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }*/

}
