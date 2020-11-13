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
public class CostumerValidationConstraintsTest {

    private static Validator validator;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test
    public void createCostumerModelWithWrongPriceInCents() {

        CostumerModel costumerModel = createCostumerModel();

        costumerModel.setName("ln0rd@!3");

        Set<ConstraintViolation<CostumerModel>> violations = validator.validate(costumerModel);

        assertTrue(violations.size() > 1);
    }

    @Test
    public void createCostumerModelWithWrongEmail() {

        CostumerModel costumerModel = createCostumerModel();

        costumerModel.setName("test@test@test.com");

        Set<ConstraintViolation<CostumerModel>> violations = validator.validate(costumerModel);

        assertTrue(violations.size() > 1);
    }

    @Test
    public void createCostumerModelWithWrongPhoneCountryCode() {

        CostumerModel costumerModel = createCostumerModel();

        costumerModel.setPhoneCountryCode(444);

        Set<ConstraintViolation<CostumerModel>> violations = validator.validate(costumerModel);

        assertTrue(violations.size() > 1);
    }

    @Test
    public void createCostumerModelWithWrongPhoneAreaCode() {

        CostumerModel costumerModel = createCostumerModel();

        costumerModel.setPhoneCountryCode(000);

        Set<ConstraintViolation<CostumerModel>> violations = validator.validate(costumerModel);

        assertTrue(violations.size() > 1);
    }

    @Test
    public void createCostumerModelWithWrongPhoneNumber() {

        CostumerModel costumerModel = createCostumerModel();

        costumerModel.setPhoneNumber(-12345434);

        Set<ConstraintViolation<CostumerModel>> violations = validator.validate(costumerModel);

        assertTrue(violations.size() > 1);
    }

    @Test
    public void createCostumerModelWithWrongBirthDate() {

        CostumerModel costumerModel = createCostumerModel();

        costumerModel.setBirthDate("101020");

        Set<ConstraintViolation<CostumerModel>> violations = validator.validate(costumerModel);

        assertTrue(violations.size() > 1);
    }

    @Test
    public void createCostumerWithWrongDocumentNumber() {

        CostumerModel costumerModel = createCostumerModel();

        costumerModel.setDocumentNumber("A12345643");

        Set<ConstraintViolation<CostumerModel>> violations = validator.validate(costumerModel);

        assertTrue(violations.size() > 1);
    }

    public CostumerModel createCostumerModel() {
        return new CostumerModel("Septima Zenobia",
                "septimazenobia@email.com",
                00,
                01,
                900009900,
                "03/03/01",
                "09890809800",
                new CostumerAndressModel(
                        "Stret Septima Zenobia",
                        "90",
                        "Paralel universe",
                        "SP",
                        "Athenas",
                        "greek",
                        0000000
                )
        );
    }
}
