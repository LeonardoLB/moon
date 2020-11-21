package com.leolsbufalo.moon.model;

import com.leolsbufalo.moon.entity.PaymentCard;
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

        paymentCardModel.setMethod("abc123@");

        Set<ConstraintViolation<PaymentCardModel>> violations = validator.validate(paymentCardModel);

        assertFalse(violations.isEmpty());
    }

    @Test
    public void createPaymenCardtWithWrongNumber() {

        PaymentCardModel paymentCardModel = createPaymentCardModel();

        paymentCardModel.setNumber("abc123");

        Set<ConstraintViolation<PaymentCardModel>> violations = validator.validate(paymentCardModel);

        assertFalse(violations.isEmpty());
    }

    @Test
    public void createPaymenCardtWithWrongCVC() {

        PaymentCardModel paymentCardModel = createPaymentCardModel();

        paymentCardModel.setCvc(2340);

        Set<ConstraintViolation<PaymentCardModel>> violations = validator.validate(paymentCardModel);

        assertFalse(violations.isEmpty());
    }

    @Test
    public void createPaymenCardtWithWrongName() {

        PaymentCardModel paymentCardModel = createPaymentCardModel();

        paymentCardModel.setName("ln0rd");

        Set<ConstraintViolation<PaymentCardModel>> violations = validator.validate(paymentCardModel);

        assertFalse(violations.isEmpty());
    }

    @Test
    public void createPaymenCardtWithWrongDocumentNumber() {

        PaymentCardModel paymentCardModel = createPaymentCardModel();

        paymentCardModel.setDocumentNumber("ln0rd");

        Set<ConstraintViolation<PaymentCardModel>> violations = validator.validate(paymentCardModel);

        assertFalse(violations.isEmpty());
    }

    @Test
    public void createPaymenCardtWithWrongExpirantionMounth() {

        PaymentCardModel paymentCardModel = createPaymentCardModel();

        paymentCardModel.setExpirationMonth(13);

        Set<ConstraintViolation<PaymentCardModel>> violations = validator.validate(paymentCardModel);

        assertFalse(violations.isEmpty());
    }

    @Test
    public void createPaymenCardtWithWrongExpirantionYear() {

        PaymentCardModel paymentCardModel = createPaymentCardModel();

        paymentCardModel.setExpirationYear(1929);

        Set<ConstraintViolation<PaymentCardModel>> violations = validator.validate(paymentCardModel);

        assertFalse(violations.isEmpty());
    }

    @Test
    public void createPaymentCardWithAllCorrectContent() {

        PaymentCardModel paymentCardModel = createPaymentCardModel();

        Set<ConstraintViolation<PaymentCardModel>> violations = validator.validate(paymentCardModel);

        assertTrue(violations.isEmpty());
    }

    public PaymentCardModel createPaymentCardModel() {
        return new PaymentCardModel (
                "credit card",
                "00009123454345",
                111,
                "Septima Zenobia",
                "09890809800",
                4,
                2060);
    }
}
