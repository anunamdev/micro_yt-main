package com.question.QuestionService.controllers;

import com.question.QuestionService.entities.Question;
import com.question.QuestionService.repositories.QuestionRepository;
import com.question.QuestionService.services.QuestionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/question")
public class QuestionController {

    private static final Logger LOGGER =LoggerFactory.getLogger(QuestionController.class);

    private QuestionService questionService;

    @Autowired
    QuestionRepository repository;

    public QuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }

    //    create
    @PostMapping
    public Question create(@RequestBody Question question) {
        return questionService.create(question);
    }

    //    get all
    @GetMapping
    public List<Question> getAll() {
        return questionService.get();
    }

    @GetMapping("/{questionId}")
    public Question getAll(@PathVariable Long questionId) {
        return questionService.getOne(questionId);
    }

//    get all question of specific quiz


    @GetMapping("/quiz/{quizId}")
    public List<Question> getQuestionsOfQuiz(@PathVariable Long quizId) {
        return questionService.getQuestionsOfQuiz(quizId);
    }

    @GetMapping("/gendata")
    public ResponseEntity<Map> gendata(){
        LOGGER.info("date started={}", LocalDate.now());
        LOGGER.info("time started={}", LocalTime.now());

        ResponseEntity<Map> data = questionService.gendata();
        LOGGER.info("date ended={}",LocalDate.now());
        LOGGER.info("time ended={}", LocalTime.now());
        return data;
    }

}
