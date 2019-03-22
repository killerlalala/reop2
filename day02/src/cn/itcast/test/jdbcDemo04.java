package cn.itcast.test;

import cn.itcast.util.MyUtil;

import java.io.IOException;
import java.io.Reader;
import java.sql.*;

public class jdbcDemo04 {
    public static void main(String[] args) {
        Connection conn=null;
        ResultSet resultSet=null;

        try {
            conn = MyUtil.getConnection();
            String sql="select * from emp";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                Reader gander = resultSet.getCharacterStream("gender");
                double salary = resultSet.getDouble("salary");
                Date join_date = resultSet.getDate("join_date");
                System.out.println(id+" "+name+" "+(char)gander.read()+" "+salary+" "+join_date);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            MyUtil.close(conn,resultSet);
        }

    }
}
