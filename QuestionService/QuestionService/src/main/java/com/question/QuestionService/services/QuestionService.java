package com.question.QuestionService.services;

import com.question.QuestionService.entities.Question;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;

public interface QuestionService {

    Question create(Question question);
    List<Question> get();
    Question getOne(Long id);

    List<Question> getQuestionsOfQuiz(Long quizId);

    ResponseEntity<Map> gendata();
}
