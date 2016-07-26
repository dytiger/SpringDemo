package org.forten.sample.bo;

import org.forten.sample.model.User;
import org.springframework.beans.factory.BeanCreationException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.util.HashMap;
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
