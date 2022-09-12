package com.example.restservice.service;

import com.example.restservice.exception.DatabaseException;
import com.example.restservice.exception.StudentNotFoundException;
import com.example.restservice.model.Student;
import com.example.restservice.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepository repository;

    static List<Student> studentList = new ArrayList<>();

    public int addStudent(Student student){
        return repository.saveStudent(student);
    }

    public Student updateStudent(int id, Student student){
        return this.repository.updateStudent(id, student);
    }

    public List<Student> getStudents(){
        try {
            return this.repository.getAll();
        }catch (Exception exception){
            throw new DatabaseException(exception.getMessage());
        }
    }

    public Student getStudentById(int id){
        try {
            Student student = this.repository.getStudentById(id);
            if (student == null) {
                throw new StudentNotFoundException("The student not found");
            }
            return student;
        }catch (Exception exception){
            throw new StudentNotFoundException("The student not found");
        }

    }

    public Integer deleteStudent(int id){
       this.repository.deleteStudent(id);
       return 1;
    }
}
