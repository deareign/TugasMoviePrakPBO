package conn;

import com.mysql.cj.jdbc.MysqlDataSource;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class connector {
    private static Connection con;

    public static Connection connection() {
        if (con == null) {
            MysqlDataSource data = new MysqlDataSource();

            data.setDatabaseName("movie_db");
            data.setUser("root");
            data.setPassword("");
            try {
                con = data.getConnection();
                JOptionPane.showMessageDialog(null, "Koneksi ke database berhasil");
            } catch (SQLException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null, "Koneksi ke database gagal : " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        return con;
    }
}
