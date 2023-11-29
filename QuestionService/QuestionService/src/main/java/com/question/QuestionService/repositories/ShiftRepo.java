package com.question.QuestionService.repositories;

import com.question.QuestionService.entities.ShiftTable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShiftRepo extends JpaRepository<ShiftTable,Long> {



}
