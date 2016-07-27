package org.forten.sample.bo;

import org.forten.sample.model.User;
import org.springframework.beans.factory.BeanCreationException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2016/7/26.
 */
@Service("userBo")
public class UserBo implements InitializingBean {
    private DataSource dataSource;
    private NamedParameterJdbcTemplate jdbcTemplate;

    @Transactional
    public int doSave(User user){
        String sql ="INSERT INTO test_users (login_name,password,email,user_level,status,regist_time,last_login_time,val_code)" +
                " VALUES (:loginName,:password,:email,:userLevel,:status,:registTime,:lastLoginTime,:valCode)";
        Map<String,Object> params = new HashMap<String,Object>();
        params.put("loginName",user.getLoginName());
        params.put("password",user.getPassword());
        params.put("email",user.getEmail());
        params.put("userLevel",user.getUserLevel());
        params.put("status",user.getStatus());
        params.put("registTime",user.getRegistTime());
        params.put("lastLoginTime",user.getLastLoginTime());
        params.put("valCode",user.getValCode());

        return jdbcTemplate.update(sql,params);
    }

    @Transactional(readOnly = true)
    public List<User> queryAll(){
        String sql = "SELECT id,login_name,email,user_level,status,regist_time,last_login_time " +
                "FROM test_users ORDER BY regist_time DESC";
        return jdbcTemplate.query(sql, new RowMapper<User>() {
            public User mapRow(ResultSet rs, int i) throws SQLException {
                User u = new User();
                u.setId(rs.getInt("id"));
                u.setLoginName(rs.getString("login_name"));
                u.setRegistTime(rs.getDate("regist_time"));
                u.setEmail(rs.getString("email"));
                u.setLastLoginTime(rs.getDate("last_login_time"));
                u.setPassword("******");
                u.setStatus(rs.getString("status"));
                u.setUserLevel(rs.getInt("user_level"));
                u.setValCode("********");

                return u;
            }
        });
    }

    @Transactional(readOnly = true)
    public List<User> queryByName(String name){
        String sql = "SELECT id,login_name,email,user_level,status,regist_time,last_login_time " +
                "FROM test_users WHERE 1=1 ";
        if(name!=null&&name.trim().length()>0){
            sql = sql + "AND login_name LIKE :name ";
        }
        sql = sql + "ORDER BY regist_time DESC";

        Map<String,Object> params = new HashMap<String, Object>();
        if(name!=null&&name.trim().length()>0){
            params.put("name","%"+name+"%");
        }

        return jdbcTemplate.query(sql, params,(rs,i)-> {
                User u = new User();
                u.setId(rs.getInt("id"));
                u.setLoginName(rs.getString("login_name"));
                u.setRegistTime(rs.getDate("regist_time"));
                u.setEmail(rs.getString("email"));
                u.setLastLoginTime(rs.getDate("last_login_time"));
                u.setPassword("******");
                u.setStatus(rs.getString("status"));
                u.setUserLevel(rs.getInt("user_level"));
                u.setValCode("********");

                return u;
        });
    }

    @Resource
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
    }

    public void afterPropertiesSet() {
        if (dataSource == null) {
            throw new BeanCreationException("Must set dataSource on ContactDao");
        }
        if (jdbcTemplate == null) {
            throw new BeanCreationException("Null JdbcTemplate on ContactDao");
        }
    }
}
