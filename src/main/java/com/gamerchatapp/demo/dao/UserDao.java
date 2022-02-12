package com.gamerchatapp.demo.dao;

import com.gamerchatapp.demo.pojo.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class UserDao {

    private final String INSERT_NEW_USER = "INSERT INTO users (user_id, name, password, salt, email) VALUES (?, ?, ?, ?, ?)";
    private JdbcTemplate jdbcTemplate;

    public UserDao(@Qualifier("master_jdbc") JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public int insert(User user) {
        return jdbcTemplate.update(INSERT_NEW_USER,
                user.getUser_id(),
                user.getName(),
                user.getPassword(),
                user.getSalt(),
                user.getEmail());
    }

}
