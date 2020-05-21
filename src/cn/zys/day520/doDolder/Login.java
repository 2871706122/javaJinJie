package cn.zys.day520.doDolder;

import cn.zys.day520.uitles.JdbcUitles;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Login {
    public static void main(String[] args) {
        Scanner sc1 = new Scanner(System.in);
        System.out.println("请输入用户名");
        String username = sc1.nextLine();
        System.out.println("请输入用户id");
        String id = sc1.nextLine();
        boolean res = new Login().myLogin(username,id);
        if(res==true) {
            System.out.println("登陆成功");
        }else {
            System.out.println("姓名或者用户id有误");
        }
    }

    public boolean myLogin(String username,String id){
        if(username==null || id==null){
            return false;
        }

        Connection connectionObj = null;
        PreparedStatement preparedStatementObj = null;
        ResultSet resultSetObj = null;
        try {
            //创建数据库连接对象
            connectionObj = JdbcUitles.getConnectionObj();
            //开启事务
            connectionObj.setAutoCommit(false);
            //定义sql
            String sql = "select * from user_msg where name = ? and id = ?";
            preparedStatementObj = connectionObj.prepareStatement(sql);
            preparedStatementObj.setString(1,username);
            preparedStatementObj.setString(2,id);
            resultSetObj = preparedStatementObj.executeQuery();
            //提交事务
            connectionObj.commit();
            return resultSetObj.next();
        } catch (SQLException e) {
            //事务回滚
            if(connectionObj!=null){
                try {
                    connectionObj.rollback();
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }
            e.printStackTrace();
        }finally {
            JdbcUitles.doSelectClose(resultSetObj,preparedStatementObj,connectionObj);
        }
        return false;
    }
}
