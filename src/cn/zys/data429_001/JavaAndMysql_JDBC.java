package cn.zys.data429_001;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JavaAndMysql_JDBC {
    public static void main(String[] args) throws Exception {
        Class.forName("com.mysql.jdbc.Driver");
        //需要注意一下自己电脑上的端口是3306，数据库名称和表的名称注意要修改才能使用
        Connection conObj = DriverManager.getConnection("jdbc:mysql://localhost:8411/zys001", "root", "8411");

        Statement stm = conObj.createStatement();

        //增加数据
        //String sql = "insert into user_msg values(default ,'name2',26,'男')";
        //int res = stm.executeUpdate(sql);
        //System.out.println(res);

        //删除数据
//        String sql = "delete from user_msg where id='3'";
//        int res = stm.executeUpdate(sql);
//        System.out.println(res);


        //数据库查询
        String sql = "select * from user_msg where id = 1";
        ResultSet res = stm.executeQuery(sql);
        //System.out.println(res.next());
        while (res.next()) {
            System.out.println(res.getString("id") + "\t");
            System.out.println(res.getString("name") + "\t");
            System.out.println(res.getString("age") + "\t");
        }

        //更改数据库
        //String sql = "update user_msg set sex = '男' where id = 2";
        //int res = stm.executeUpdate(sql);
        //System.out.println(res);

        stm.close();
        conObj.close();
    }
}
