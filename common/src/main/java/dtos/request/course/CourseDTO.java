package dtos.request.course;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;
import validator.image.ImageFile;



@Data
@AllArgsConstructor
@NoArgsConstructor
public class CourseDTO {
    private Long id;

    @JsonProperty("course_name")
    private String courseName;

    @JsonProperty("course_desc")
    private String courseDescription;

    @JsonProperty("initial_price")
    private Double initialPrice;

    @JsonProperty("final_price")
    private Double finalPrice;

    @JsonProperty("thumbnail")
    private String thumbnail;

    @ImageFile
    private MultipartFile avatar;

    @JsonProperty("teacher_desc")
    private String teacherDescription;

    @JsonProperty("introduction_video")
    private String introductionVideo;

    private Integer assignment;

    @JsonProperty("registered_student")
    private Integer registeredStudent;

    @JsonProperty("expire_time")
    private Integer expireTime; //month


}
