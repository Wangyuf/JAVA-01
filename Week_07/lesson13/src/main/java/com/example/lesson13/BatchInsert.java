package com.example.lesson13;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import java.sql.*;
import java.util.UUID;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @program: lesson13 BatchInsert.java
 * @description:
 * @author: cc
 * @create: 2021-03-07 16:08
 */
public class BatchInsert {
    private static final String URL = "jdbc:mysql://192.168.80.3:3306/geek_db?serverTimezone=Asia/Shanghai&rewriteBatchedStatements=true";
    private static final String USER_NAME = "root";
    private static final String PASSWORD = "123456";

    public static void main(String[] args) throws SQLException {
        System.out.println("---start---");
        // 手动拼写sql 分成50次 每次插入20000 耗时9.094秒
        batchInsertBySqlDemo(20000,50);
        //使用PreparedStatement 分成50次 每次插入20000 本机测试约8.254
        batchInsertByPreparedDemo(20000,50);
    }

    /**
     * @Description: 构造sql的value值部分
     * @param length value值得长度
     * @Author: cc
     * @return 
     * @create 2021/3/7 16:39
     */
    private static String buildSqlValue(int length) {
        String val = "(1,'root','123456',13500000001,'wanger','2021-03-07 12:00:00','2021-03-07 12:00:00')";
        StringBuilder sb = new StringBuilder(val);
        for(int i = 0;i<length-1;i++) {
            sb.append(",");
            sb.append(val);
        }
        return sb.toString();
    }

    /**
     * @Description: 根据sql手动插入数据
     * @param length 插入数据多少
     * @param conn 数据连接
     * @Author: cc
     * @return 
     * @create 2021/3/7 16:24
     */
    public static int batchInsertBySql(int length, Connection conn) throws SQLException {
        String sql = "insert into geek_customer (id, account, password, mobile, name,created_time, modified_time) values"+buildSqlValue(length);
        try (Statement statement = conn.createStatement()) {
            return statement.executeUpdate(sql);
        }
    }



    /**
     * @Description: 手动写sql插入
     * @param dataNumber 每次插入数量大小
     * @param insertTimes 插入次数
     * @Author: cc
     * @create 2021/3/7 16:29
     */
    public static void batchInsertBySqlDemo(int dataNumber,int insertTimes) throws SQLException {
        long startMs = System.currentTimeMillis();
        Connection conn = getConnection();
        try {
            for(int i = 0;i<insertTimes;i++) {
                batchInsertBySql(dataNumber,conn);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            conn.close();
        }
        long endMs = System.currentTimeMillis();
        System.out.println("batchInsertBySqlDemo执行完毕耗时："+(endMs-startMs)/1000.0);
    }

    /**
     * 批量添加-2
     * 分50次插入 使用PreparedStatement
     * @throws SQLException
     */
    public static void batchInsertByPreparedDemo(int dataNumber,int insertTimes) throws SQLException {
        long startMs = System.currentTimeMillis();
        int length = dataNumber;
        String sql = "insert into geek_customer (id, account, password, mobile, name,created_time, modified_time) values "+buildSqlValue(length);
        //获取连接
        Connection conn = getConnection();
        try {
            conn.setAutoCommit(false);
            try (PreparedStatement ps = conn.prepareStatement(sql)) {
                for(int i = 0;i<insertTimes;i++) {
                    ps.addBatch();
                }
                ps.executeBatch();
                conn.commit();
            }
        }finally {
            conn.setAutoCommit(true);
            conn.close();
        }
        long endMs = System.currentTimeMillis();
        System.out.println("batchInsertByPreparedDemo执行完毕耗时："+(endMs-startMs)/1000.0);
    }

    /**
     * 获取连接
     * @return
     */
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER_NAME, PASSWORD);
    }

}
