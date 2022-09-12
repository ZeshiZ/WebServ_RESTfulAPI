package com.example.restservice.api;

import com.example.restservice.model.Joke;
import com.example.restservice.service.JokeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JokeController {

    JokeService service  = new JokeService();

    @GetMapping("/joke")
    public ResponseEntity<Joke> getRandomJoke(){
        return new ResponseEntity<>(service.getRandomJoke(), HttpStatus.OK);
    }
}
