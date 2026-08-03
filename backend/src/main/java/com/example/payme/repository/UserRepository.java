package com.example.payme.repository;

import com.example.payme.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class UserRepository {
    
    @Autowired
    private JdbcTemplate jdbcTemplate;
    
    private RowMapper<User> userMapper = (rs, rowNum) -> {
        return new User(
        rs.getInt("id"),
        rs.getString("name"),
        rs.getString("email"),
        rs.getString("phone"),
        rs.getString("country")
        );
    };
    
    public List<User> getAllUsers() {
        String sql = "SELECT * FROM users";
        return jdbcTemplate.query(sql, userMapper);
    }
    
    public User getUserById(int id) {
        String sql = "SELECT * FROM users WHERE id = ?";
        User user = jdbcTemplate.queryForObject(sql, userMapper, id);
        return user;
    }
}
