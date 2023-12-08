package com.question.QuestionService.services.impl;

import com.question.QuestionService.entities.Question;
import com.question.QuestionService.entities.ShiftTable;
import com.question.QuestionService.repositories.QuestionRepository;
import com.question.QuestionService.repositories.ShiftRepo;
import com.question.QuestionService.services.ShiftService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class ShiftServiceImpl implements ShiftService {

    Logger LOGGER = LoggerFactory.getLogger(ShiftServiceImpl.class);
    @Autowired
    ShiftRepo shiftRepo;
    @Autowired
    QuestionRepository questionRepo;

    @Override
    public Map<String, Object> shiftSer() {
        HashMap<String, Object> nos = new HashMap<>();
        nos.put("time operation started at", LocalTime.now());


        ArrayList<ShiftTable> shiftTables = new ArrayList<>();
        List<Question> all = questionRepo.findAll();
        List<Question> active = all.stream().filter(ques -> ques.getStatus().equals("Active")).collect(Collectors.toList());
        for (Question a : active) {
            shiftTables.add(mapper(a));
        }

        List<ShiftTable> shiftTables1 = shiftRepo.saveAll(shiftTables);

        nos.put("time operation ended at ", LocalTime.now());
        nos.put("Active in Question Table", active.size());
        nos.put("Shifted to shift table", shiftTables1.size());

        return nos;
    }


    ShiftTable mapper(Question question) {
        ShiftTable shiftTable = new ShiftTable(question.getQuestion(), question.getQuizId());
        return shiftTable;
    }
}
