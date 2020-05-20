package cn.zys.day520.doDolder;

import cn.zys.day520.uitles.JdbcUitles;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Select_User_Data {
    public static void main(String[] args) {
        List<User_msg_data> list = new Select_User_Data().get_User_msg_data();
        System.out.println(list);
    }

    public List<User_msg_data> get_User_msg_data() {
        Connection connectionObj = null;
        Statement statementObj = null;
        ResultSet res = null;
        User_msg_data Obj = null;
        List<User_msg_data> list = new ArrayList<User_msg_data>();
        try {
            //创建数据库连接对象
            connectionObj = JdbcUitles.getConnectionObj();
            if(connectionObj==null){
                return null;
            }
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
        }catch (SQLException e) {
            e.printStackTrace();
        }finally {
            //关闭,释放资源
            JdbcUitles.doSelectClose(res,statementObj,connectionObj);
        }
        return list;
    }
}
