package com.example.restservice.adapter;

import com.example.restservice.model.Joke;
import org.springframework.web.client.RestTemplate;

public class JokerAdapter {

    public Joke getJoke(){
        //this method for getting jokes from web !!!
        RestTemplate restTemplate = new RestTemplate();
        Joke joke = restTemplate.getForObject("https://api.chucknorris.io/jokes/random", Joke.class);
        return joke;
    }

    //get a joke by category

}
