package cn.zys.day520.doDolder;

import cn.zys.day520.tablesObj.User_msg_data;
import cn.zys.day520.uitles.Jdbc_druid_uitles;
import org.junit.Test;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
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

    /**
     * 将结果封装成emp对象的list集合(java bean对象
     */
    @Test
    public void getDataBean(){
        String sql = "select * from user_msg";
        List<User_msg_data> arr = jdbcTemplateObj.query(sql, new RowMapper<User_msg_data>() {
            @Override
            public User_msg_data mapRow(ResultSet resultSetObj, int i) throws SQLException {
                User_msg_data user_msg_dataObj = new User_msg_data();
                int id = resultSetObj.getInt("id");
                String name = resultSetObj.getString("name");
                int age = resultSetObj.getInt("age");
                String sex = resultSetObj.getString("sex");
                user_msg_dataObj.setId(id);
                user_msg_dataObj.setName(name);
                user_msg_dataObj.setAge(age);
                user_msg_dataObj.setSex(sex);

                return user_msg_dataObj;
            }
        });

        for (User_msg_data obj : arr) {
            System.out.println(obj);
        }
        //结果:
        //User_msg_data{id=1, name='张三', age=20, sex='男'}
        //User_msg_data{id=2, name='王五', age=10, sex='男'}
        //User_msg_data{id=14, name='name', age=20, sex='女'}
    }

    /**
     * 将结果封装成emp对象的list集合(java bean对象  简化版
     */
    @Test
    public void getDataBean2(){
        String sql = "select * from user_msg";
        List<User_msg_data> arr = jdbcTemplateObj.query(sql, new BeanPropertyRowMapper<User_msg_data>(User_msg_data.class));
        for (User_msg_data obj : arr) {
            System.out.println(obj);
        }
        //结果:
        //User_msg_data{id=1, name='张三', age=20, sex='男'}
        //User_msg_data{id=2, name='王五', age=10, sex='男'}
        //User_msg_data{id=14, name='name', age=20, sex='女'}
    }

    /**
     * 查询总记录数
     */
    @Test
    public void getNum(){
        String sql = "select count(id) from user_msg";
        Long count = jdbcTemplateObj.queryForObject(sql, Long.class);
        System.out.println(count);
    }
}
