package com.example.usermanagement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import com.example.usermanagement.model.User;


@SpringBootApplication
public class UsermanagementApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(UsermanagementApplication.class, args);
    }

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void run(String... args) throws Exception {
        String sql = "SELECT * FROM users";
        List<User> users = jdbcTemplate.query(sql,
         BeanPropertyRowMapper.newInstance(User.class));
         users.forEach(System.out :: println);
    }
}
