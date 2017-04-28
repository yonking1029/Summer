package com.oil.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

/**
 * 使用JdbcTemplate
 * TODO 在此写上类的相关说明.<br>
 * @author Leejean <br>
 * @version 1.0.0 2017年4月25日 下午2:32:11<br>
 * @see 
 * @since JDK 1.7.0
 */
@Service
public class JdbcTemplateUserServiceImpl implements JdbcTemplateUserService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Integer create(String name, Integer age) {
        return jdbcTemplate.update("insert into t_user(name, age) values(?, ?)", name, age);
    }

    @Override
    public void deleteByName(String name) {
        jdbcTemplate.update("delete from t_user where name = ?", name);
    }

    @Override
    public Integer getAllUsers() {
        return jdbcTemplate.queryForObject("select count(1) from t_user", Integer.class);
    }

    @Override
    public void deleteAllUsers() {
        jdbcTemplate.update("delete from t_user");
    }
}
