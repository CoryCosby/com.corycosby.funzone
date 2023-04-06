package com.corycosby.funzone.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.corycosby.funzone.repository.ScoreRepository;
import com.corycosby.funzone.model.Score;

@RestController
public class ScoreController {

    // Autowired field: injects a ScoreRepository object into the class
    @Autowired
    private ScoreRepository scoreRepository;

    // Maps the /save-score URL to the saveScore() method using the POST HTTP method
    @PostMapping("/save-score")
    public Score saveScore(@RequestParam("yourScore") int yourScore) {
        // Creates a new Score object, sets its properties, and saves it using the ScoreRepository
        Score score = new Score();
        score.setYourScore(yourScore);
        return scoreRepository.save(score);
    }
}


