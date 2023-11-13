package com.practice.hibernate.onetomany;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class OneToManyServiceTest {

    @Autowired
    private OneToManyService oneToManyService;


    @Test
    void saveOneToMany() {
        LearnerUni john=new LearnerUni();
        john.setName("John");

        ScoreUni johnMath=new ScoreUni();
        johnMath.setScore("Math");

        ScoreUni johnScience=new ScoreUni();
        johnScience.setScore("Science");

        john.addScore(johnMath);
        john.addScore(johnScience);

        oneToManyService.saveOneToMany(john);
    }
}