package com.mck.study5.payment_service.dtos;


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
public class PaymentListResponse
{
    private Integer total;
    private List<PaymentResponse> payments = new ArrayList<>();
}
