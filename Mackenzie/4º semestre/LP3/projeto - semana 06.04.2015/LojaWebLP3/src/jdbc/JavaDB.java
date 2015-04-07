package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import org.apache.derby.jdbc.ClientDataSource;

/**
 *
 * @author 31358535
 */
public class JavaDB extends DataSource{
    
    
    private JavaDB jDataSource;
    private Connection conn;
    private PreparedStatement stm; // statement
    
    public JavaDB () {
        ClientDataSource ds = new ClientDataSource();
        ds.setDatabaseName(DB_NAME);
        ds.setServerName(DB_SERVER);
        ds.setPortNumber(DB_PORT);
    }
    @Override
    public Connection getConnection() {
        return jDataSource.getConnection(DB_USER, DB_PASS);
    }
    @Override
    public Connection getConnection (String db_user, String db_pass) {
        try {
            conn = DriverManager.getConnection("jdbc:derby://"+DB_SERVER+"/"
            +DB_NAME+"/"+db_pass+","+db_pass);
            return conn;
        } catch (SQLException ex) {
            return null;
        }
    }
    @Override
    public PreparedStatement prepare(String sql) {
        try {
            return stm = conn.prepareStatement(sql);
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(JavaDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    @Override
    public void closeStatement() throws SQLException {
        stm.close();
    }
    @Override
    public void closeConnection() throws SQLException {
        conn.close();
    }
}
