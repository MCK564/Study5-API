package com.mck.study5.user_service.controller;

import com.mck.study5.user_service.constants.MessageKeys;
import com.mck.study5.user_service.controllers.TrainingHistoryController;
import com.mck.study5.user_service.dtos.responses.trainingHistory.ListTrainingHistoryResponse;
import com.mck.study5.user_service.services.trainingHistory.ITrainingHistoryService;
import jakarta.persistence.EntityManagerFactory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.jpa.JpaRepositoriesAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(
        controllers = TrainingHistoryController.class,
        excludeAutoConfiguration = {
                DataSourceAutoConfiguration.class,
                HibernateJpaAutoConfiguration.class,
                JpaRepositoriesAutoConfiguration.class
        }
)
@AutoConfigureMockMvc(addFilters = false)
class TrainingHistoryControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ITrainingHistoryService trainingHistoryService;

    @MockBean
    private EntityManagerFactory entityManagerFactory;

    @Test
    void findTrainingHistory_shouldReturnSuccessResponse() throws Exception {
        when(trainingHistoryService.getAllByUser_Id(1L)).thenReturn(ListTrainingHistoryResponse.builder().build());

        mockMvc.perform(get("/users/training-history")
                        .header("X-User-Id", "1")
                        .header("X-User-Role", "USER"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.code").value(200))
                .andExpect(jsonPath("$.success").value(true))
                .andExpect(jsonPath("$.message").value(MessageKeys.SUCCESS));
    }
}
