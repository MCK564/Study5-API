package com.mck.study5.user_service.dtos.responses.users;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.catalina.LifecycleState;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDetailListResponse {
    private List<UserDetailResponse> users = new ArrayList<>();

    @JsonProperty("total_pages")
    private Integer totalPages;
    private Integer currentPage;
    private Integer quantity;
}
