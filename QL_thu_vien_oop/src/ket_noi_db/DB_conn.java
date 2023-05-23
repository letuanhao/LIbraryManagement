package ket_noi_db;

import java.sql.*;

public class DB_conn {
    private Connection conn;
    static DB_conn DBconn;
    public static final String driverName = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    public static final String dbURL = "jdbc:sqlserver://localhost:1433;databaseName=QL_thu_vien;";
    public static final String dbUser = "username=minh;";
    public static final String dbPass = "password=minh";
    public DB_conn() {
        ReadFileTxt rd = new ReadFileTxt();
        rd.readfile();
        try {
            Class.forName(driverName);
            conn = DriverManager.getConnection(dbURL+dbUser+dbPass);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
    public static DB_conn getDBconn(){
        if(DBconn==null){
            DBconn=new DB_conn();
        }
        return DBconn;
    }
    public Connection getconn(){
        return conn;
    }
    public static void main(String[] args) {
        DB_conn.getDBconn();
    }
}
