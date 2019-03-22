package cn.itcast.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Collection;

public class JdbcDemo01 {
    public static void main(String[] args) throws Exception {
        //1 导入jar包
        //2 注册驱动
        Class.forName("com.mysql.jdbc.Driver");
        //安装数据库连接对象
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db2", "root", "1234");
        //4 定义sql语句
        String sql="update student3 set age = 30 where id = 1";
        //5 获取执行sql的对象Statement
        Statement statement = conn.createStatement();
        //6 执行sql
        int i = statement.executeUpdate(sql);
        //7 处理结果
        System.out.println(i);
        //8 释放资源
        statement.close();
        conn.close();

    }
}




