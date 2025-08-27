package br.com.fiap.dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
    public static Connection openConnection() {
        Connection con = null;
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            String url = "jdbc:oracle:thin:@oracle.fiap.com.br:1521:orcl"; // Adjust host, port, and SID/service name
            final String username = "rm564063";
            final String password = "100407";
            con = DriverManager.getConnection(url, username, password);
            System.out.println("Sucess Connection");
        } catch (ClassNotFoundException e) {
            System.out.println("Error: Connection not possible - not found" + e.getMessage());
        } catch (SQLException e) {
            System.out.println("SQL error:" + e.getMessage());
        }
        return con;
    }
    public static void closeConnection(Connection con) {
        try {
            con.close();
            System.out.println("Connection was closed");
        } catch (SQLException e) {
            System.out.println("SQL error:" + e.getMessage());
        }
    }
}
