package com.mck.study5.user_service.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mck.study5.user_service.constants.MessageKeys;
import com.mck.study5.user_service.controllers.TodoListController;
import com.mck.study5.user_service.dtos.requests.TodoListRequestDTO;
import com.mck.study5.user_service.dtos.responses.todoList.ListTodoListResponse;
import com.mck.study5.user_service.dtos.responses.todoList.TodoListResponse;
import com.mck.study5.user_service.services.todoList.ITodoListService;
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
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(
        controllers = TodoListController.class,
        excludeAutoConfiguration = {
                DataSourceAutoConfiguration.class,
                HibernateJpaAutoConfiguration.class,
                JpaRepositoriesAutoConfiguration.class
        }
)
@AutoConfigureMockMvc(addFilters = false)
class TodoListControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private ITodoListService todoListService;

    @MockBean
    private EntityManagerFactory entityManagerFactory;

    @Test
    void getList_shouldReturnTodoLists() throws Exception {
        TodoListResponse todoList = TodoListResponse.builder()
                .id(3L)
                .title("Day 1")
                .implementedDay("2024-01-01")
                .type("DAILY")
                .status(1)
                .tasks(List.of())
                .build();
        ListTodoListResponse response = ListTodoListResponse.builder()
                .totalTodoList(1)
                .todoListResponses(List.of(todoList))
                .build();

        when(todoListService.getAllByScheduleId(4L)).thenReturn(response);

        mockMvc.perform(get("/users/me/todoList")
                        .param("scheduleId", "4"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.code").value(200))
                .andExpect(jsonPath("$.message").value(MessageKeys.SUCCESS))
                .andExpect(jsonPath("$.data.total_todo_list").value(1))
                .andExpect(jsonPath("$.data.todo_lists[0].title").value("Day 1"));

        verify(todoListService).getAllByScheduleId(4L);
    }

    @Test
    void createOrUpdateTodoList_shouldReturnSavedTodoList() throws Exception {
        TodoListRequestDTO request = new TodoListRequestDTO(null, "2024-01-02", "Plan", "DAILY", 1, 4L);
        TodoListResponse response = TodoListResponse.builder()
                .id(9L)
                .title("Plan")
                .implementedDay("2024-01-02")
                .type("DAILY")
                .status(1)
                .tasks(List.of())
                .build();

        when(todoListService.createOrUpdateTodoList(any(TodoListRequestDTO.class))).thenReturn(response);

        mockMvc.perform(post("/users/me/todoList")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.code").value(200))
                .andExpect(jsonPath("$.message").value(MessageKeys.SUCCESS))
                .andExpect(jsonPath("$.data.id").value(9))
                .andExpect(jsonPath("$.data.title").value("Plan"));

        verify(todoListService).createOrUpdateTodoList(any(TodoListRequestDTO.class));
    }

    @Test
    void deleteTodoList_shouldReturnSuccess() throws Exception {
        when(todoListService.deleteTodoList(11L)).thenReturn(MessageKeys.DELETE_SUCCESSFULLY);

        mockMvc.perform(delete("/users/me/todoList/{todoListId}", 11))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.code").value(200))
                .andExpect(jsonPath("$.message").value(MessageKeys.SUCCESS))
                .andExpect(jsonPath("$.data").value(MessageKeys.DELETE_SUCCESSFULLY));

        verify(todoListService).deleteTodoList(11L);
    }
}
