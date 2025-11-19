package com.mck.study5.user_service.dtos.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TodoListRequestDTO {
    private Long id;
    private String implementedDay;
    private String title;
    private String type;
    private Integer status;

}
