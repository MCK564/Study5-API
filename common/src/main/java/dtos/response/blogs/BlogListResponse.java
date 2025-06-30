package dtos.response.blogs;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BlogListResponse {
    private Integer page;
    private Integer quantity;
    private List<BlogResponse> blogs = new ArrayList<>();
}
