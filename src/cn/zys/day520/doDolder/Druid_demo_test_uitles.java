package cn.zys.day520.doDolder;

import cn.zys.day520.uitles.Jdbc_druid_uitles;

import java.sql.*;

/**
 * 测试写的druid工具类
 */
@SuppressWarnings("ALL")
public class Druid_demo_test_uitles {
    public static void main(String[] args) {
        Connection connectionObj = null;
        PreparedStatement preparedStatementObj = null;
        try {
            //获取连接
           connectionObj = Jdbc_druid_uitles.getConnection();
            //定义sql
            String sql = "insert into user_msg values(null,?,?,?)";
            //创建数据库连接对象
            preparedStatementObj = connectionObj.prepareStatement(sql);
            //给?赋值
            preparedStatementObj.setString(1,"name");
            preparedStatementObj.setInt(2,20);
            preparedStatementObj.setString(3,"男");
            //执行sql
            int ResultNum = preparedStatementObj.executeUpdate();
            System.out.println(ResultNum);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            Jdbc_druid_uitles.doUpdateClose(preparedStatementObj,connectionObj);
        }
    }
}
