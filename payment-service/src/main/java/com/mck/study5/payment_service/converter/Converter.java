package com.mck.study5.payment_service.converter;


import com.mck.study5.payment_service.dtos.PaymentRequest;
import com.mck.study5.payment_service.models.Payment;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class Converter {
    private final ModelMapper modelMapper;

    public Payment fromPaymentDTO(PaymentRequest request){
        return modelMapper.map(request,Payment.class);
    }
}
