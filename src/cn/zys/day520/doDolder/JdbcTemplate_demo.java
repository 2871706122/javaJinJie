package cn.zys.day520.doDolder;

import cn.zys.day520.uitles.Jdbc_druid_uitles;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * Spring template应用jdbc
 * 不需要申请连接、不需要释放，结束会自动归还连接对象
 */
public class JdbcTemplate_demo {
    public static void main(String[] args) {
        //1.导入jar包
        //2.创建jdbctemplate对象
        JdbcTemplate jdbcTemplateObj = new JdbcTemplate(Jdbc_druid_uitles.getDataSourceObj());
        //3.调用方法
        String sql = "update user_msg set sex = '女' where id = ?";
        int resultNum = jdbcTemplateObj.update(sql,14);
        System.out.println(resultNum);
    }
}
