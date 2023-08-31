package cn.ws.study.jdk8.mysql;

import cn.ws.tools.ReadLog;

import java.sql.*;
import java.util.List;

public class DbUtil {

    public static final String URL = "jdbc:mysql://localhost:3306/phone";
    public static final String USER = "root";
    public static final String PASSWORD = "root";

    public static void main(String[] args) {

        List<String> read = ReadLog.read("C:\\Users\\Host-424\\Desktop\\a\\aaaaa.txt");
//        String selectSql = "select * from user where  user_id =1116642000 and pk_id =60000010";
//        String selectSql2 = "select * from user where  user_id =1116642000 and pk_id =60000012";
        //创建sql语句
        for (String s : read) {
            try {
                String sql = "INSERT INTO `phone`.`phone`(`phone`) VALUES ("+s+");";
                conn(sql);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }


    public static void conn(String sql) {
        Connection conn = null;
        try {
            //1.加载驱动程序
            Class.forName("com.mysql.jdbc.Driver");
            //2. 获得数据库连接
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            //3.操作数据库，实现增删改查
            Statement stmt = conn.createStatement();
            stmt.executeUpdate(sql);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static String conn2(String sql) {
        Connection conn = null;
        String launch_time = "";
        try {
            //1.加载驱动程序
            Class.forName("com.mysql.jdbc.Driver");
            //2. 获得数据库连接
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            //3.操作数据库，实现增删改查
            Statement stmt = conn.createStatement();
            ResultSet resultSet = stmt.executeQuery(sql);
            while (resultSet.next()) {
                launch_time = resultSet.getString("launch_time");
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return launch_time;
    }
}
