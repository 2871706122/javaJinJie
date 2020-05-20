package cn.zys.day520.uitles;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.Properties;

//jdbc工具类
public class JdbcUitles {
    private static String url;
    private static String user;
    private static String password;
    private static String dataBaseDriver;

    //读取配置文件
    static {
        try {
            //创建Properties集合类
            Properties obj = new Properties();

            //加载文件1
            //obj.load(new FileReader(""));//文件路径这里只能用绝对路径，但是为了适配其他的，所以不能使用这种

            //加载文件2
            //获取src下面的文件的方法  ClassLoader 类加载器  (直系文件
            ClassLoader classLoader = JdbcUitles.class.getClassLoader();
            URL res = classLoader.getResource("JDBC.properties");
            String path = res.getPath();
            //System.out.println(path);

            obj.load(new FileReader(path));

            //读取文件,赋值
            url = obj.getProperty("url");
            user = obj.getProperty("user");
            password = obj.getProperty("password");
            dataBaseDriver = obj.getProperty("dataBaseDriver");
            //System.out.println(dataBaseDriver);

            //驱动注册
            Class.forName(dataBaseDriver);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取连接
     * @return 连接对象
     */
    public static Connection getConnectionObj(){
        try {
            return DriverManager.getConnection(url,user,password);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 释放资源
     * 这里是更新操作的时候的释放，因为只有连接对象和sql执行对象
     */
    public static void doUpdateClose(Statement statementObj,Connection connectionObj){
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
     * 释放资源
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
