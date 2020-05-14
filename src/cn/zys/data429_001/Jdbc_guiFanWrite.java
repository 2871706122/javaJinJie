package cn.zys.data429_001;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Jdbc_guiFanWrite {
    public static void main(String[] args) {
        try {
            //注册驱动,jdk5以后可以不写
            Class.forName("com.mysql.jdbc.Driver");
            //连接数据库
            Connection conObj = DriverManager.getConnection("jdbc:mysql://localhost:8411/zys001","root","8411");

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
