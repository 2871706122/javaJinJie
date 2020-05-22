package cn.zys.day520.doDolder;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class C3p0_demo {
    public static void main(String[] args) throws SQLException {
        new C3p0_demo().getData();
    }

    public static void getData() throws SQLException {
        //创建一个数据库  连接池  对象(注意是池子，创建的时候会根据配置文件进行创建对应个数的数据库连接对象
        DataSource dataSourceObj = new ComboPooledDataSource("test");

        //拿到其中的一个连接对象(这里才是拿其中的连接对象
        Connection connectionObj = dataSourceObj.getConnection();
        System.out.println(connectionObj);
    }
}
