package com.mck.study5.user_service.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mck.study5.user_service.constants.MessageKeys;
import com.mck.study5.user_service.controllers.TaskController;
import com.mck.study5.user_service.dtos.requests.TaskRequestDTO;
import com.mck.study5.user_service.dtos.responses.tasks.ListTaskResponse;
import com.mck.study5.user_service.dtos.responses.tasks.TaskResponse;
import com.mck.study5.user_service.services.tasks.ITaskService;
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
        controllers = TaskController.class,
        excludeAutoConfiguration = {
                DataSourceAutoConfiguration.class,
                HibernateJpaAutoConfiguration.class,
                JpaRepositoriesAutoConfiguration.class
        }
)
@AutoConfigureMockMvc(addFilters = false)
class TaskControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private ITaskService taskService;

    @MockBean
    private EntityManagerFactory entityManagerFactory;

    @Test
    void deleteTask_shouldReturnSuccess() throws Exception {
        when(taskService.deleteTaskById(3L)).thenReturn(MessageKeys.DELETE_SUCCESSFULLY);

        mockMvc.perform(delete("/users/tasks/{id}", 3)
                        .header("X-User-Id", "1")
                        .header("X-User-Role", "USER"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.code").value(200))
                .andExpect(jsonPath("$.message").value(MessageKeys.SUCCESS))
                .andExpect(jsonPath("$.data").value(MessageKeys.DELETE_SUCCESSFULLY));

        verify(taskService).deleteTaskById(3L);
    }

    @Test
    void findByTodoListId_shouldReturnTasks() throws Exception {
        TaskResponse taskResponse = TaskResponse.builder()
                .id(10L)
                .content("Review PR")
                .build();
        ListTaskResponse response = ListTaskResponse.builder()
                .totalTask(1)
                .tasks(List.of(taskResponse))
                .build();

        when(taskService.findAllByTodoListId(7L)).thenReturn(response);

        mockMvc.perform(get("/users/tasks/search")
                        .param("todoListId", "7"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.code").value(200))
                .andExpect(jsonPath("$.message").value(MessageKeys.SUCCESS))
                .andExpect(jsonPath("$.data.total_task").value(1))
                .andExpect(jsonPath("$.data.tasks[0].content").value("Review PR"));

        verify(taskService).findAllByTodoListId(7L);
    }

    @Test
    void createOrUpdateTask_shouldReturnSavedTask() throws Exception {
        TaskRequestDTO request = new TaskRequestDTO(null, "Write docs", 7L);
        TaskResponse response = TaskResponse.builder()
                .id(12L)
                .content("Write docs")
                .build();

        when(taskService.createOrUpdate(any(TaskRequestDTO.class))).thenReturn(response);

        mockMvc.perform(post("/users/tasks")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.code").value(200))
                .andExpect(jsonPath("$.message").value(MessageKeys.SUCCESS))
                .andExpect(jsonPath("$.data.id").value(12))
                .andExpect(jsonPath("$.data.content").value("Write docs"));

        verify(taskService).createOrUpdate(any(TaskRequestDTO.class));
    }
}
