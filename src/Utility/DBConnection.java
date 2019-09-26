package Utility;

import java.sql.*;

public class DBConnection
{
    private final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    private final String DB_URL = "jdbc:mysql//localhost/test?&useSSL=false";
    private final String USER_NAME = "root";
    private final String PASSWORD = "ig0ic0adgeia";

    public static Connection getConnection(){
        Connection conn = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql//localhost/test?&useSSL=false", "root","ig0ic0adgeia");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return conn;
    }
}