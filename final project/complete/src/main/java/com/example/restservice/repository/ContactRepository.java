package com.example.restservice.repository;


import com.example.restservice.model.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ContactRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public int createContact(Contact contact){
        jdbcTemplate.update("INSERT into contact(name, email, subject, message) VALUES(?,?,?,?)",
                contact.getName(), contact.getEmail(), contact.getSubject(), contact.getMessage());

        return jdbcTemplate.queryForObject("SELECT max(id) from user", Integer.class);

    }
}
