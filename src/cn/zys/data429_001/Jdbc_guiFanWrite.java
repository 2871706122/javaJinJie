package cn.zys.data429_001;

import java.sql.*;

public class Jdbc_guiFanWrite {
    public static void main(String[] args) {
        Connection conObj = null;
        Statement stm = null;
        try {
            //注册驱动,jdk5以后可以不写
            Class.forName("com.mysql.jdbc.Driver");
            //创建数据库连接对象
            conObj = DriverManager.getConnection("jdbc:mysql://localhost:8411/zys001","root","8411");
            //定义sql
            String sql = "insert into user_msg values(default ,'name3',25,'女')";
            //创建sql执行对象
            stm = conObj.createStatement();
            //执行sql
            int num = stm.executeUpdate(sql);
            //处理结果
            System.out.println(num);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            //关闭,释放资源

            if(stm!=null){
                try {
                    stm.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(conObj!=null){
                try {
                    conObj.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
