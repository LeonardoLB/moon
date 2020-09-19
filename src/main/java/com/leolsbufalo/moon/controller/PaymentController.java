package com.leolsbufalo.moon.controller;

import com.leolsbufalo.moon.converter.PaymentConverter;
import com.leolsbufalo.moon.entity.Payment;
import com.leolsbufalo.moon.model.PaymentModel;
import com.leolsbufalo.moon.service.impl.PaymentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/payments")
public class PaymentController {

    @Autowired
    PaymentServiceImpl paymentServiceImpl;

    PaymentConverter paymentConverter = new PaymentConverter();

    HttpStatus status;

    @PostMapping
    public ResponseEntity<PaymentModel> createPayment(@Valid @RequestBody PaymentModel paymentModel) {
            Payment payment = paymentServiceImpl.createPayment(paymentConverter.convertToPaymentEntity(paymentModel));
            return ResponseEntity.ok(paymentConverter.convertToPaymentModel(payment));
    }

    @GetMapping
    public void getPayment() {

    }

}
