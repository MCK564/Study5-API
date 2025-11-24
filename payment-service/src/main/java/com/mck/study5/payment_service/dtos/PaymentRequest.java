package com.mck.study5.payment_service.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class PaymentRequest {

    @JsonProperty("course_id")
    private Long courseId;

    private String email;
    private String phone;
    private Long price;
    private String description;

}
