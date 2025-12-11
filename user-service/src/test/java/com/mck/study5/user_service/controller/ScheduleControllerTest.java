package com.mck.study5.user_service.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mck.study5.user_service.constants.MessageKeys;
import com.mck.study5.user_service.controllers.ScheduleController;
import com.mck.study5.user_service.dtos.requests.ScheduleRequestDTO;
import com.mck.study5.user_service.dtos.responses.schedules.ListScheduleResponse;
import com.mck.study5.user_service.dtos.responses.schedules.ScheduleResponse;
import com.mck.study5.user_service.services.schedules.IScheduleService;
import jakarta.persistence.EntityManagerFactory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.boot.autoconfigure.data.jpa.JpaRepositoriesAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(
        controllers = ScheduleController.class,
        excludeAutoConfiguration = {
                DataSourceAutoConfiguration.class,
                HibernateJpaAutoConfiguration.class,
                JpaRepositoriesAutoConfiguration.class
        }
)
@AutoConfigureMockMvc(addFilters = false)
class ScheduleControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private IScheduleService scheduleService;

    @MockBean
    private EntityManagerFactory entityManagerFactory;

    @Test
    void getSchedule_shouldReturnUserSchedules() throws Exception {
        ScheduleResponse schedule = ScheduleResponse.builder()
                .id(1L)
                .title("Week plan")
                .description("Week plan description")
                .status("ACTIVE")
                .createdDate("2024-01-01")
                .build();
        ListScheduleResponse response = ListScheduleResponse.builder()
                .totalSchedule(1)
                .scheduleResponses(List.of(schedule))
                .build();

        when(scheduleService.getAllOwnSchedule(1L)).thenReturn(response);

        mockMvc.perform(get("/users/me/schedule")
                        .header("X-User-Id", "1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.code").value(200))
                .andExpect(jsonPath("$.message").value(MessageKeys.SUCCESS))
                .andExpect(jsonPath("$.data.total_schedule").value(1))
                .andExpect(jsonPath("$.data.list_schedule[0].title").value("Week plan"));

        verify(scheduleService).getAllOwnSchedule(1L);
    }

    @Test
    void createSchedule_shouldDelegateToService() throws Exception {
        ScheduleRequestDTO request = new ScheduleRequestDTO(null, "Week plan", "Week plan description", "ACTIVE");
        ScheduleResponse schedule = ScheduleResponse.builder()
                .id(5L)
                .title("Week plan")
                .description("Week plan description")
                .status("ACTIVE")
                .createdDate("2024-01-01")
                .build();

        when(scheduleService.createOrUpdateSchedule(any(ScheduleRequestDTO.class), eq(1L))).thenReturn(schedule);

        mockMvc.perform(post("/users/me/schedule")
                        .header("X-User-Id", "1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.code").value(200))
                .andExpect(jsonPath("$.message").value(MessageKeys.SUCCESS))
                .andExpect(jsonPath("$.data.id").value(5))
                .andExpect(jsonPath("$.data.title").value("Week plan"));

        verify(scheduleService).createOrUpdateSchedule(any(ScheduleRequestDTO.class), eq(1L));
    }

    @Test
    void deleteSchedule_shouldReturnSuccess() throws Exception {
        when(scheduleService.deleteScheduleById(1L, 9L)).thenReturn(MessageKeys.DELETE_SUCCESSFULLY);

        mockMvc.perform(delete("/users/me/schedule/{id}", 9)
                        .header("X-User-Id", "1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.code").value(200))
                .andExpect(jsonPath("$.message").value(MessageKeys.SUCCESS))
                .andExpect(jsonPath("$.data").value(MessageKeys.DELETE_SUCCESSFULLY));

        verify(scheduleService).deleteScheduleById(1L, 9L);
    }
}
