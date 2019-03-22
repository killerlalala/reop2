package cn.itcast.util;

import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.Properties;

public class MyUtil {
    private static String url;
    private static String user;
    private static String password;
    private static String driver;
    static {
        try {
            //读取资源文件,并获取值
            //1 创建 properties 集合类
            Properties p=new Properties();
            ClassLoader classLoader = MyUtil.class.getClassLoader();
//            URL res = classLoader.getResource("jdbc.properties");
//            String path = res.getPath();

            p.load(classLoader.getResourceAsStream("jdbc.properties"));

//            System.out.println(path);

            //2 加载文件
            //p.load(new FileReader("src/jdbc.properties"));
//            p.load(new FileReader(path));
            url = p.getProperty("url");
            user = p.getProperty("user");
            password = p.getProperty("password");
            driver = p.getProperty("driver");

            Class.forName(driver);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


    }

    //获取连接对象
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url,user,password);
    }

    //释放资源
    public static void close(Connection conn,ResultSet rs){
        if (rs != null){
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (conn != null){
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    public static void close(PreparedStatement stmt,Connection conn,ResultSet rs){
        if (stmt != null){
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (conn != null){
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (rs != null){
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}









































