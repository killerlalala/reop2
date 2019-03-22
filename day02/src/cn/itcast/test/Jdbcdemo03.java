package cn.itcast.test;

import cn.itcast.util.MyUtil;

import java.sql.*;

public class Jdbcdemo03 {
    public static void main(String[] args) {
        Connection conn=null;
        Statement statement=null;
        ResultSet rs=null;
        try {
            /*Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql:///db2", "root", "1234");
            */
            conn= MyUtil.getConnection();
            statement = conn.createStatement();
            //定义sql语句
            String sql="select * from student3";
            rs = statement.executeQuery(sql);
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int age = rs.getInt("age");
                String sex = rs.getString("sex");
                String address = rs.getString("address");
                double math = rs.getDouble("math");
                double english = rs.getDouble("english");
                System.out.println(id+" "+name+" "+age+" "+sex+" "+address+" "+math+" "+english);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            /*if (rs != null){
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (conn != null){
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }*/

            MyUtil.close(conn,rs);
        }
    }
}
