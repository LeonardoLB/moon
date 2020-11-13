package com.leolsbufalo.moon.model;

import org.junit.jupiter.api.BeforeEach;
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
public class ItemValidationConstraintsTest {

    private static Validator validator;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    public void createPaymentItemModelWithWrongDescription() {

        PaymentItemModel paymentItemModel = createPaymentItemModel();

        paymentItemModel.setDescription("@#$");

        Set<ConstraintViolation<PaymentItemModel>> violations = validator.validate(paymentItemModel);

        assertTrue(violations.size() > 1);
    }

    public void createPaymentItemModelWithWrongQuantity() {

        PaymentItemModel paymentItemModel = createPaymentItemModel();

        paymentItemModel.setQuantity(-2);

        Set<ConstraintViolation<PaymentItemModel>> violations = validator.validate(paymentItemModel);

        assertTrue(violations.size() > 1);
    }

    public void createPaymentItemModelWithWrongPriceInCents() {

        PaymentItemModel paymentItemModel = createPaymentItemModel();

        paymentItemModel.setPriceInCents(-1);

        Set<ConstraintViolation<PaymentItemModel>> violations = validator.validate(paymentItemModel);

        assertTrue(violations.size() > 1);
    }

    public PaymentItemModel createPaymentItemModel() {
        return new PaymentItemModel(
                "Shield from kraken skin",
                1,
                1050
        );
    }
}
