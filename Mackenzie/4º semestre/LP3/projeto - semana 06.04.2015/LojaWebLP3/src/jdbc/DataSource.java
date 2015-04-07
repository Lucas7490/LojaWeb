package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author 31358535
 */
public abstract class DataSource {
    protected static String DB_SERVER = "localhost"; // <<- olhar aqui
    protected static int DB_PORT = 1527; // <<- olhar aqui
    protected static String DB_NAME = "Loja_db"; // <<- olhar aqui
    protected static String DB_USER = "mackenzielp3"; // <<- olhar aqui
    protected static String DB_PASS = "mackenzielp3";
    
    public abstract Connection getConnection();
    public abstract Connection getConnection (String db_user, String db_pass);
    public abstract PreparedStatement prepare(String sql);
    public abstract void closeStatement() throws SQLException;
    public abstract void closeConnection() throws SQLException;
}
