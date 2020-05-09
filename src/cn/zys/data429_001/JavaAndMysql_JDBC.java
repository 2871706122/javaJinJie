package cn.zys.data429_001;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class JavaAndMysql_JDBC {
    public static void main(String[] args) throws Exception {
        Class.forName("com.mysql.jdbc.Driver");
        //需要注意一下自己电脑上的端口是3306，数据库名称和表的名称注意要修改才能使用
        Connection conObj = DriverManager.getConnection("jdbc:mysql://localhost:8411/zys001","root","8411");

        String sql = "update user_msg set sex = '男' where id = 2";

        Statement stm = conObj.createStatement();

        int res = stm.executeUpdate(sql);

        System.out.println(res);

        stm.close();
        conObj.close();
    }
}
