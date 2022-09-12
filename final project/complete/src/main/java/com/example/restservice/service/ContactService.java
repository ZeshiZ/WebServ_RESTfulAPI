package com.example.restservice.service;

import com.example.restservice.model.Contact;
import com.example.restservice.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContactService {

    @Autowired
    private ContactRepository contactRepository;

    public int createContact(Contact contact){
        return this.contactRepository.createContact(contact);
    }
}
