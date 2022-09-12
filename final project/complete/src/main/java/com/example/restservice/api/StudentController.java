package com.example.restservice.api;

import com.example.restservice.exception.StudentNotFoundException;
import com.example.restservice.model.Student;
import com.example.restservice.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

@RestController
public class StudentController {

    @Autowired
    private StudentService service;

    //http://localhost:8070/welcome?id=1&name=reza
    //? for queryparam
    //& for having multiple queryparams
//    @GetMapping("/welcome")
//    public Student getStudent(@RequestParam(value = "id") int id, @RequestParam(value = "name", defaultValue = "") String studentName){
//        return new Student(id, studentName);
//    }

//    @GetMapping("/welcome/{name}")
//    public Student getStudentByName(@PathVariable String name){
//        return new Student(1, name);
//    }
//
//    @GetMapping("/welcome/name/{stdName}/id/{stdId}")
//    public Student getStudentByNameAndId(@PathVariable String stdName, @PathVariable int stdId){
//        return new Student(stdId, stdName);
//    }

    @GetMapping("/welcome/id/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable int id){
        try {
            return new ResponseEntity<>(service.getStudentById(id), HttpStatus.OK);
        }catch(StudentNotFoundException exception){
            return new ResponseEntity(exception.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    //---------POST--------
    @PostMapping("/welcome/student")
    public ResponseEntity<Integer> postStudent(@RequestBody Student student){
       return new ResponseEntity<>(service.addStudent(student), HttpStatus.CREATED);
    }

    //amazon.ca -> orders
    //GET ALL -> all the orders =>
    //PUT -> id of the order
    @PutMapping("/student/{id}")
    public ResponseEntity<Student> updateStudent(@RequestBody Student student, @PathVariable int id){
        return new ResponseEntity<>(service.updateStudent(id, student), HttpStatus.OK);
    }

    @DeleteMapping("/student/{id}")
    public ResponseEntity<Integer> deleteStudent(@PathVariable int id){
       return new ResponseEntity<>(service.deleteStudent(id), HttpStatus.NO_CONTENT);
    }

    @GetMapping("/student")
    public ResponseEntity<List<Student>> getAll(){
        try {
            return new ResponseEntity<>(service.getStudents(), HttpStatus.OK);
        }catch (Exception exception){
            return new ResponseEntity(exception.getMessage(), HttpStatus.CONFLICT);
        }
    }

    //Create a route to Post the employee "/employee"
    //Create a route to GET the employee  "/employee/{firstname}" with passing pathvariable


}
