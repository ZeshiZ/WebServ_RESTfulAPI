package com.example.restservice.service;

import com.example.restservice.adapter.JokerAdapter;
import com.example.restservice.model.Joke;

public class JokeService {

    JokerAdapter adapter = new JokerAdapter();

    public Joke getRandomJoke(){
        return adapter.getJoke();
    }
}
