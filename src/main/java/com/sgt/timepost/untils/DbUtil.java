package com.sgt.timepost.untils;

import java.sql.*;

/**
 * Created by sgt on 2018/8/28 0028.
 */
public class DbUtil {

    private static Connection conn;
    private static PreparedStatement ps;
    private static ResultSet rs;

    public static Connection getConnection(){

        String Url = "jdbc:mysql://localhost:3306/smp";
        String User = "root";
        String Passwd = "123123";

        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(Url, User, Passwd);
            return conn;

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return null;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static ResultSet excuteQuery(String sql){

        if (getConnection() == null) {
            return null;
        }
        try {

            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }


    public static ResultSet excuteQuery(String sql,Object[] obj){

        if (getConnection() == null) {
            return null;
        }
        try {

            ps = conn.prepareStatement(sql);
            for (int i = 0; i <obj.length ; i++) {
                ps.setObject(i+1,obj[i]);
            }

            rs = ps.executeQuery();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }

    public static int executeUpdate(String sql) {
        int result = -1;
        if (getConnection() == null) {
            return result;
        }
        try {
            ps = conn.prepareStatement(sql);
            result = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }


    public static int excuteUpdate(String sql,Object[] obj){
        int result = -1;

        if (getConnection() == null) {
            return 0;
        }
        try {

            ps = conn.prepareStatement(sql);
            for (int i = 0; i <obj.length ; i++) {
                ps.setObject(i+1,obj[i]);
            }

            result = ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;

    }


    public static void DBclose(){

        try {

            if (rs != null) {
                rs.close();
            }
            if (ps != null) {
                ps.close();
            }
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
