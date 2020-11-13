package com.leolsbufalo.moon.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(MockitoJUnitRunner.class)
public class PaymentCardValidationConstrainstsTest {

    private static Validator validator;

    @BeforeEach
    public void setUp() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test
    public void createPaymenCardtWithWrongMethod() {

        PaymentCardModel paymentCardModel = createPaymentCardModel();

        paymentCardModel.setMethod("credit @card");

        Set<ConstraintViolation<PaymentCardModel>> violations = validator.validate(paymentCardModel);

        assertTrue(violations.size() > 1);
    }

    public PaymentCardModel createPaymentCardModel() {
        return new PaymentCardModel ("credit card",
                "00009123454345",
                001,
                "Septima Zenobia",
                "09890809800",
                04,
                2060);
    }
}
