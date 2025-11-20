package com.mck.study5.learning_service.dto.request.exam;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.mck.study5.learning_service.dto.request.question.QuestionCompleteExamDTO;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class TakeExamDTO {
    @JsonProperty("exam_attempt_id")
    private Long examAttemptId;
    List<QuestionCompleteExamDTO> questions = new ArrayList<>();

}
