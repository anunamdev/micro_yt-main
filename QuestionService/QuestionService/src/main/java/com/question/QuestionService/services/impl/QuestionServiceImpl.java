package com.question.QuestionService.services.impl;

import com.question.QuestionService.entities.Question;
import com.question.QuestionService.repositories.QuestionRepository;
import com.question.QuestionService.services.QuestionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class QuestionServiceImpl implements QuestionService {

    private QuestionRepository questionRepository;

    public QuestionServiceImpl(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    private static int generateRandomId(Random random) {
        return random.nextInt(10) + 1;
    }

    @Override
    public Question create(Question question) {
        return questionRepository.save(question);
    }

    @Override
    public List<Question> get() {
        return questionRepository.findAll();
    }

    @Override
    public Question getOne(Long id) {
        return questionRepository.findById(id).orElseThrow(() -> new RuntimeException("Question not found !!"));
    }

    @Override
    public List<Question> getQuestionsOfQuiz(Long quizId) {
        return questionRepository.findByQuizId(quizId);
    }

    public ResponseEntity<Map> gendata() {

        Random random = new Random(42);
        HashMap<Integer, String> map = new HashMap<>();
        ArrayList<Question> questions = new ArrayList<>();

        // Generate 15,000 SQL INSERT queries
        for (int i = 11; i <= 15000; i++) {
            int questionNumber = i;
            String question = "This is question number " + i + ". What is your answer?";
            int randomId = generateRandomId(random);

            // Print the SQL INSERT query
            System.out.println("INSERT INTO quiz_table (question_number, question, random_id) " +
                    "VALUES (" + questionNumber + ", '" + question + "', " + randomId + ");");

            Question questionObj = new Question((long) questionNumber, question, (random.nextLong(9)), "Active");
//            Question saved = questionRepository.save(questionObj);
            questions.add(questionObj);
//            map.put(i, saved.getQuestion());
        }
        questionRepository.saveAll(questions);
//        return new ResponseEntity<>(map, HttpStatus.CREATED);
            return null;
    }

}
