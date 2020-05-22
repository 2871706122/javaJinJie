package cn.zys.day520.doDolder;

import com.alibaba.druid.pool.DruidAbstractDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.util.Properties;

public class Druid_demo {
    public static void main(String[] args) {
        try {
            new Druid_demo().ceShiDruid();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void ceShiDruid() throws Exception {
        //1.导入druid的jar包
        //2.定义配置文件
        //3.加载配置文件
        Properties propertiesObj = new Properties();
        InputStream inputStreamObj = Druid_demo.class.getClassLoader().getResourceAsStream("druid.properties");
        propertiesObj.load(inputStreamObj);

        //4.获取数据库连接池对象
        DataSource dataSourceObj = DruidDataSourceFactory.createDataSource(propertiesObj);


        //创建数据库连接对象
        Connection connectionObj = dataSourceObj.getConnection();
        System.out.println(connectionObj);
    }
}
