package com.mck.study5.learning_service.dto.response;

import com.mck.study5.learning_service.dto.response.exams.ExamAttemptResponse;
import com.mck.study5.learning_service.dto.response.questions.QuestionAnswerListResponse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ExamResultResponse {
    private ExamAttemptResponse examAttemptResponse;
    private QuestionAnswerListResponse questionAnswerListResponse;
}
