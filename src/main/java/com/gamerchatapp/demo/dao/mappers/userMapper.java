package com.gamerchatapp.demo.dao.mappers;

import com.gamerchatapp.demo.pojo.User;
import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

public class userMapper implements RowMapper<User> {
    @Override
    public User mapRow(ResultSet rs, int rowNum) throws SQLException {
        User user = new User();
        user.setUser_id(UUID.fromString(rs.getString("user_id")));
        user.setName(rs.getString("name"));
        user.setPassword(rs.getString("password"));
        user.setSalt(rs.getString("salt"));
        user.setEmail(rs.getString("email"));
        return user;
    }
}
