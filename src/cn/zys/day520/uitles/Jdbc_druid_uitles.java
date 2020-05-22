package cn.zys.day520.uitles;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.activation.DataSource;
import java.io.IOException;
import java.sql.Connection;
import java.util.Properties;

/**
 * Druid连接池的工具类
 */
public class Jdbc_druid_uitles {
    //1.定义全局变量
    private static DataSource dataSourceObj;

    static {
        try {
            //2.加载配置文件
            Properties propertiesObj = new Properties();
            propertiesObj.load(Jdbc_druid_uitles.class.getClassLoader().getResourceAsStream("druid.properties"));

            //3.获取datasourse
            dataSourceObj = DruidDataSourceFactory.createDataSource(propertiesObj);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 创建数据库连接对象方法
     */
    public static Connection getConnection(){
        return dataSourceObj.getConnection();
    }

}
