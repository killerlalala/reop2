package cn.itcast.test;

import cn.itcast.util.MyUtil;

import java.sql.*;
import java.util.Scanner;

public class jdbcDemo05 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("输入用户名");
        String username = sc.nextLine();
        System.out.println("输入密码");
        String password = sc.nextLine();
        boolean login = new jdbcDemo05().login(username, password);
        if (login){
            System.out.println("登陆成功");
        }else {
            System.out.println("用户名密码错误");
        }


    }

    public boolean login1(String username ,String password){
        if(username == null || password == null){
            return false;
        }
        //连接数据库判断是否登录成功
        Connection conn = null;
        PreparedStatement pstmt =  null;
        ResultSet rs = null;
        //1.获取连接
        try {
            conn =  MyUtil.getConnection();

            //2.定义sql
            String sql = "select * from ueer where ueername = ? and password = ?";
            //3.获取执行sql的对象
            pstmt = conn.prepareStatement(sql);
            //给?赋值
            pstmt.setString(1,username);
            pstmt.setString(2,password);
            //4.执行查询,不需要传递sql
            rs = pstmt.executeQuery();
            return rs.next();//如果有下一行，则返回true
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            MyUtil.close(pstmt,conn,rs);
        }
        return false;
    }



    public boolean login(String username,String password){
        if (username==null || password==null){
            return false;
        }
        ResultSet rs=null;
        Connection conn=null;
        PreparedStatement pst=null;
        try {
            conn = MyUtil.getConnection();

            //定义sql
                        //"select * from ueer where ueername ? and password ?"
                        //"select * from ueer where ueername = ? and password = ?"
            String sql= "select * from ueer where ueername =? and password =?";
            //执行sql对象
            pst= conn.prepareStatement(sql);
            //给? 赋值
            pst.setString(1,username);
            pst.setString(2,password);
            //执行sql
            rs = pst.executeQuery();
                return rs.next();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            MyUtil.close(pst,conn,rs);
        }
        return false;
    }
}
