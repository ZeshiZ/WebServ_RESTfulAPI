package com.example.restservice.repository;

import com.example.restservice.exception.DatabaseException;
import com.example.restservice.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentRepository {

    //I use a class that comes from Spring and I need to import this library

    //using DI (dependency injection)
    @Autowired
    private JdbcTemplate jdbcTemplate;

    //JPA and hibernate => is the best approach

    //CRUD operation
    public int saveStudent(Student student) {
        jdbcTemplate.update("INSERT INTO Student(name) VALUES(?)", student.getName());

        //how can I get the inserted id
        return jdbcTemplate.queryForObject("SELECT max(id) from student", Integer.class);
    }

    public List<Student> getAll(){
        try {
            List<Student> studentList = jdbcTemplate.query("SELECT id, name FROM student",
                    (rs, rowNum) ->
                            new Student(rs.getInt("id"),
                                    rs.getString("name")));

            return studentList;
        }catch (DatabaseException exception){
            throw  new DatabaseException(exception.getMessage());
        }
    }

    public Student getStudentById(int id){
        try {
            String sql = "SELECT id, name FROM STUDENT WHERE ID = ?";

            return jdbcTemplate.queryForObject(sql, new Object[]{id}, new StudentRowMapper());
        }catch (DatabaseException exception){
            throw new DatabaseException("database error");
        }
    }

    public Student updateStudent(int id, Student student){
        int result = jdbcTemplate.update("UPDATE student set name=? where id=?", student.getName(), id);
        if (result == 1){
            student.setId(id);
            return student;
        }
        return null;
    }

    public void deleteStudent(int id){
        try {
            jdbcTemplate.update("DELETE from student where id=?", id);
        }catch (DatabaseException exception){
            throw new DatabaseException(exception.getMessage());
        }
    }

}
