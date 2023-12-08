package com.question.QuestionService.controllers;

import com.question.QuestionService.entities.Question;
import com.question.QuestionService.repositories.QuestionRepository;
import com.question.QuestionService.services.QuestionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/question")
public class QuestionController {

    private static final Logger LOGGER = LoggerFactory.getLogger(QuestionController.class);
    @Autowired
    QuestionRepository repository;
    private QuestionService questionService;

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
    public ResponseEntity<Map> gendata() {
        LOGGER.info("time started={}", LocalTime.now());
        HashMap<String, Object> map = new HashMap<>();
        map.put("StartTime", LocalTime.now());
        ResponseEntity<Map> gendataset = questionService.gendata();
        LOGGER.info("time ended={}", LocalTime.now());
        map.put("End Time", LocalTime.now());
        ResponseEntity<Map> data = new ResponseEntity<>(map, HttpStatus.CREATED);
        return data;
    }

}
