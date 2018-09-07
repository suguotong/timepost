package com.sgt.timepost.untils;

import org.apache.commons.lang3.StringUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by sgt on 2018/8/28 0028.
 */
public class MysqlHelper {
    /**
     * 执行update、insert、delete等语句，返回值为受影响的行数
     *
     * @param connection
     * @param sql
     * @return
     */
    public static int executeUpdate(Connection connection, String sql) {
        int resCount = 0;
        if (StringUtils.isBlank(sql)) {
            System.out.println("sql语句不能为空");
            return resCount;
        }
        PreparedStatement ps = null;
        System.out.println("sql--> " + sql);
        try {
            ps = connection.prepareStatement(sql);
            resCount = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
        }
        return resCount;

    }

    /**
     * 执行能够返回结果集的查询语句
     *
     * @param connection
     * @param sql
     * @return
     */
    public static ResultSet executeQuery(Connection connection, String sql) {
        if (StringUtils.isBlank(sql)) {
            System.out.println("sql语句不为空");
            return null;
        }
        ResultSet rs = null;
        PreparedStatement ps = null;
        System.out.println("sql--> " + sql);
        try {
            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }
}
