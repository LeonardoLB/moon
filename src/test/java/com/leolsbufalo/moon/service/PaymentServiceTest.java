package com.leolsbufalo.moon.service;

import com.leolsbufalo.moon.entity.*;
import com.leolsbufalo.moon.service.impl.PaymentServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class PaymentServiceTest {

    private static Payment payment;

    @InjectMocks
    PaymentServiceImpl paymentServiceImpl;


    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }


    @BeforeAll
    public void init() {
        payment = createPaymentEntity();
    }


    @Test
    public void createPaymentTest() {
        Mockito.when(paymentServiceImpl.createPayment(payment)).thenReturn(payment);
    }


    public Payment createPaymentEntity() {
        return new Payment(
                "BRL",
                1050,
                1,
                List.of( new Item("Shield of the gods",
                        1,
                        1050)),
                new CostumerCard(
                        "credit card",
                        "00009123454345",
                        001,
                        "Septima Zenobia",
                        "09890809800",
                        04,
                        2060),
                new CostumerAndress(
                        "Stret Septima Zenobia",
                        90,
                        "Paralel universe",
                        "SP",
                        "Athenas",
                        "greek",
                        0000000),
                new Costumer(
                        "Septima Zenobia",
                        "septimazenobia@email.com",
                        00,
                        01,
                        900009900,
                        "03/03/01",
                        "09890809800"));
    }
}
