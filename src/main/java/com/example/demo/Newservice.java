package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class Newservice {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void insertUser(New user) {
        String sql = "INSERT INTO user(id, name, email) VALUES (?, ?, ?)";
        jdbcTemplate.update(sql, user.getId(), user.getName(), user.getEmail());
    }

    public void updateUser(int id, New user) {
        String sql = "UPDATE user SET name = ?, email = ? WHERE id = ?";
        jdbcTemplate.update(sql, user.getName(), user.getEmail(), id);
    }

    public void deleteUser(int id) {
        String sql = "DELETE FROM user WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }

    public List<Map<String, Object>> getDetails() {
        String sql = "SELECT * FROM user";
        List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql);
        return rows;
    }
}
