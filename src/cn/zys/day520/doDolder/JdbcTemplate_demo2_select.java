package cn.zys.day520.doDolder;

import cn.zys.day520.uitles.Jdbc_druid_uitles;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.Map;

public class JdbcTemplate_demo2_select {
    private JdbcTemplate jdbcTemplateObj = new JdbcTemplate(Jdbc_druid_uitles.getDataSourceObj());

    /**
     * 将结果封装成map集,结果只有一条记录：{id=1, name=张三, age=20, sex=男}
     * 如果是查询多条数据就不适用了
     */
    @Test
    public void getDataMap(){
        String sql = "select * from user_msg where id = ?";
        Map<String, Object> arr = jdbcTemplateObj.queryForMap(sql, 1);
        System.out.println(arr);
    }

    /**
     * 将结果封装成List集
     */
    @Test
    public void getDataList(){
        String sql = "select * from user_msg";
        List<Map<String, Object>> arr = jdbcTemplateObj.queryForList(sql);
        for (Map<String, Object> obj : arr) {
            System.out.println(obj);
        }

        //结果:
        //{id=1, name=张三, age=20, sex=男}
        //{id=2, name=王五, age=10, sex=男}
        //{id=14, name=name, age=20, sex=女}
    }
}
