package com.example.restservice.repository;

import com.example.restservice.model.Student;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentRowMapper implements RowMapper<Student> {

    @Override
    public Student mapRow(ResultSet rs, int rowNum) throws SQLException {

        return new Student(rs.getInt("ID"), rs.getString("NAME"));
    }
}