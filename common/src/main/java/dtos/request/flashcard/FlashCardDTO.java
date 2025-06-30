package dtos.request.flashcard;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FlashCardDTO {
    private Long id;
    private String title;
    private String language;
    private String description;

    @JsonProperty("number_of_word")
    private Integer numberOfWord;
}
