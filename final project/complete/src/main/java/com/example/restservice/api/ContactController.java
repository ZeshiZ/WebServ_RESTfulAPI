package com.example.restservice.api;


import com.example.restservice.model.Contact;
import com.example.restservice.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ContactController {

    @Autowired
    private ContactService service;

    @PostMapping("/contact")
    public ResponseEntity<Integer> createContact(@RequestBody Contact contact){
        return new ResponseEntity<>(service.createContact(contact), HttpStatus.CREATED);
    }
}
