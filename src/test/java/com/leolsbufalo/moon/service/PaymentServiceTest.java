package com.leolsbufalo.moon.service;

import com.leolsbufalo.moon.entity.*;
import com.leolsbufalo.moon.kafka.Producer.PaymentProducer;
import com.leolsbufalo.moon.repository.PaymentRepository;
import com.leolsbufalo.moon.service.impl.PaymentServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(MockitoJUnitRunner.class)
public class PaymentServiceTest {

    private static Payment payment;

    @Mock
    PaymentRepository paymentRepository;

    @Mock
    PaymentProducer paymentProducer;

    @InjectMocks
    PaymentServiceImpl paymentServiceImpl;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        payment = createPaymentEntity();
    }

    @Test
    public void createPaymentTest() {

        Mockito.when(paymentRepository.save(payment)).thenReturn(payment);
        Mockito.when(paymentProducer.send(payment)).thenReturn(payment);

        Payment paymentCreated = paymentServiceImpl.createPayment(payment);

        assertEquals(paymentCreated, payment);
    }

    @Test
    public void createPaymentTestWithDifferentOneParameter() {

        Mockito.when(paymentRepository.save(payment)).thenReturn(payment);

        payment.setCurrency("");
        Payment paymentCreated = paymentServiceImpl.createPayment(payment);

        assertNotEquals(payment, paymentCreated);
    }

    @Test
    public void createPaymentWithoutReturnTest() {

        Mockito.when(paymentRepository.save(payment)).thenReturn(null);
        Mockito.when(paymentProducer.send(payment)).thenReturn(null);

        Payment paymentCreated = paymentServiceImpl.createPayment(payment);

        assertNull(paymentCreated);
    }


    public static Payment createPaymentEntity() {
        return new Payment(
                        "12345678910",
                "BRL",
                1050,
                1,
                List.of( new PaymentItem("Shield of the gods",
                        1,
                        1050)),
                new PaymentCard(
                        "credit card",
                        "00009123454345",
                        001,
                        "Septima Zenobia",
                        "09890809800",
                        04,
                        2060),
                new Costumer(
                        "Septima Zenobia",
                        "septimazenobia@email.com",
                        00,
                        01,
                        900009900,
                        "03/03/01",
                        "09890809800",
                        new CostumerAndress(
                                "Stret Septima Zenobia",
                                "90",
                                "Paralel universe",
                                "SP",
                                "Athenas",
                                "greek",
                                0000000
                        )
                )
        );
    }
}
