package cn.zys.day520.uitles;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
    public static Connection getConnection() throws SQLException {
        return dataSourceObj.getConnection();
    }

    /**
     * 获取连接池
     */
    public static DataSource getDataSourceObj(){
        return dataSourceObj;
    }

    /**
     * 释放资源/归还连接
     * 这里是更新操作的时候的释放，因为只有连接对象和sql执行对象
     */
    public static void doUpdateClose(Statement statementObj, Connection connectionObj){
        if(statementObj != null){
            try {
                statementObj.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if(connectionObj != null){
            try {
                connectionObj.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 释放资源/归还连接
     * 这里是查询操作的时候的释放，因为有连接对象和sql执行对象和结果集对象
     */
    public static void doSelectClose(ResultSet resultSetObj, Statement statementObj, Connection connectionObj){
        if(resultSetObj != null){
            try {
                resultSetObj.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if(statementObj != null){
            try {
                statementObj.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if(connectionObj != null){
            try {
                connectionObj.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
