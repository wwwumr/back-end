package com.example.wordladder;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController(value = "/wordLadder")
public class WordLadder {

    private WordList wordList = new WordList();

    @GetMapping
    public String[] say(@RequestParam String start,@RequestParam String end){
        return wordList.searchWord(new String[]{start,end});
    }


}
