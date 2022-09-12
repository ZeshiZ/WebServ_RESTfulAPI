package com.example.restservice.repository;

import com.example.restservice.exception.DatabaseException;
import com.example.restservice.model.Student;
import com.example.restservice.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public int createUser(User user){
        jdbcTemplate.update("INSERT into user(name, age, password, email) VALUES(?,?,?,?)",
                user.getName(), user.getAge(), user.getPassword(), user.getEmail());

        return jdbcTemplate.queryForObject("SELECT max(id) from user", Integer.class);

    }

    public User getUser(){
        try {
            List<User> userList = jdbcTemplate.query("SELECT id, name, age, password, email FROM user",
                    (rs, rowNum) ->
                            new User(rs.getInt("id"),
                                    rs.getString("name"),
                                    rs.getString("password"),
                                    rs.getInt("age"),
                                    rs.getString("email")));

            if (userList.isEmpty()){
                return null;
            }
            return userList.get(0);
        }catch (DatabaseException exception){
            throw  new DatabaseException(exception.getMessage());
        }
    }
}
