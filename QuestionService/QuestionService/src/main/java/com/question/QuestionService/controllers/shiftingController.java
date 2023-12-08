package com.question.QuestionService.controllers;
import com.question.QuestionService.services.ShiftService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Map;

@RestController
@RequestMapping
public class shiftingController {


    @Autowired
    ShiftService shiftService;


    @GetMapping("/shift")
    public Map<String,Object> shift(){
            return shiftService.shiftSer();
    }

}
