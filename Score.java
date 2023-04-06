package com.corycosby.funzone.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;

@Entity //Indicates JPA Entity
public class Score {

    // Id of the Score entity
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Generates Id for the user
    private Long id;

    // The user's score
    private int yourScore;

    // The user who earned the score
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    // Getter for id
    public Long getId() {
        return id;
    }
    // Setter for id
    public void setId(Long id) {
        this.id = id;
    }

    // Getter for yourScore
    public int getYourScore() {
        return yourScore;
    }
    // Setter for yourScore
    public void setYourScore(int yourScore) {
        this.yourScore = yourScore;
    }

    // Getter for user
    public User getUser() {
        return user;
    }
    // Setter for user
    public void setUser(User user) {
        this.user = user;
    }
}
