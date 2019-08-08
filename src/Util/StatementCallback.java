package Util;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public interface StatementCallback {
    Object doYourStatement(Statement statement) throws SQLException;
}
