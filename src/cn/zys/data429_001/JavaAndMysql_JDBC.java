package cn.zys.data429_001;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class JavaAndMysql_JDBC {
    public static void main(String[] args) throws Exception {
        Class.forName("com.mysql.jdbc.Driver");
        Connection conObj = DriverManager.getConnection("jdbc:mysql://localhost:3306/day430","root","8411");

        String sql = "update usersname set name = 100 where id = 3";

        Statement stm = conObj.createStatement();

        int res = stm.executeUpdate(sql);

        System.out.println(res);

        stm.close();
        conObj.close();
    }
}
