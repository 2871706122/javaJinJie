package cn.zys.day520.fengzhuangchaxunjieguo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

//将查询结果封装成对象，就是对查询结果进行加工成对象，最后进行打印或者其他操作
public class Jdbc_chaXunJieGuoJi {
    public static void main(String[] args) {
        List<User_msg_data> list = new Jdbc_chaXunJieGuoJi().get_User_msg_data();
        System.out.println(list);
    }

    public List<User_msg_data> get_User_msg_data() {
        Connection connectionObj = null;
        Statement statementObj = null;
        ResultSet res = null;
        User_msg_data Obj = null;
        List<User_msg_data> list = new ArrayList<User_msg_data>();
        try {
            //注册驱动,jdk5以后可以不写
            Class.forName("com.mysql.jdbc.Driver");
            //创建数据库连接对象
            connectionObj = DriverManager.getConnection("jdbc:mysql://localhost:8411/zys001","root","8411");
            //定义sql
            String sql = "select * from user_msg";
            //创建sql执行对象
            statementObj = connectionObj.createStatement();
            //执行sql
            res = statementObj.executeQuery(sql);
            //处理结果
            while (res.next()) {
                int id = res.getInt("id");
                String name = res.getString("name");
                int age = res.getInt("age");
                String sex = res.getString("sex");

                Obj = new User_msg_data();
                Obj.setId(id);
                Obj.setName(name);
                Obj.setAge(age);
                Obj.setSex(sex);

                list.add(Obj);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            //关闭,释放资源
            if(res!=null){
                try {
                    res.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(statementObj!=null){
                try {
                    statementObj.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(connectionObj!=null){
                try {
                    connectionObj.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return list;
    }
}
