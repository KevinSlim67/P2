package db;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public interface SQL {
    public void insert(Connection c) throws SQLException;

    public static List<String> returnAll(Statement statement) throws SQLException {
        return null;
    }

    public void delete(Connection c) throws SQLException;

}
