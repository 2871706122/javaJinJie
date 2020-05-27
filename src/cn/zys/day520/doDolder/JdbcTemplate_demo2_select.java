package cn.zys.day520.doDolder;

import cn.zys.day520.uitles.Jdbc_druid_uitles;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.Map;

public class JdbcTemplate_demo2_select {
    private JdbcTemplate jdbcTemplateObj = new JdbcTemplate(Jdbc_druid_uitles.getDataSourceObj());
    @Test
    public void getData(){
        String sql = "select * from user_msg where id = ?";
        Map<String, Object> arr = jdbcTemplateObj.queryForMap(sql, 1);
        System.out.println(arr);
    }
}
