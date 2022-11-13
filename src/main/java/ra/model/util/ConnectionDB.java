package ra.model.util;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionDB {
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/product_crud";
    private static final String USERNAME = "root";
    private static final String PASS = "Phamchithanh1";

    public static Connection openConnection() {
        Connection cnn = null;
        try {
            Class.forName(DRIVER);
            cnn = DriverManager.getConnection(URL, USERNAME, PASS);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return cnn;
    }

    public static void closeConnection(Connection cnn, CallableStatement callst) {

        if (cnn != null) {
            try {
                cnn.close();
            } catch (Exception ex) {
                throw new RuntimeException();
            }
        }
        if (callst != null) {
            try {
                callst.close();
            } catch (Exception ex) {
                throw new RuntimeException();
            }
        }

    }
}
