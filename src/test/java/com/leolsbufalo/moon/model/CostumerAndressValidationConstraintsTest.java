package com.leolsbufalo.moon.model;

import com.leolsbufalo.moon.entity.CostumerAndress;
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
public class CostumerAndressValidationConstraintsTest {

    private static Validator validator;

    @BeforeEach
    public void setUp() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test
    public void createCostumerAndressModelWithWrongStreet() {

        CostumerAndressModel costumerAndressModel = createCostumerAndressModel();

        costumerAndressModel.setStreet("@ Street Test with especial character");

        Set<ConstraintViolation<CostumerAndressModel>> violations = validator.validate(costumerAndressModel);

        assertFalse(violations.isEmpty());
    }

    @Test
    public void createCostumerAndressModelWithWrongNumber() {

        CostumerAndressModel costumerAndressModel = createCostumerAndressModel();

        costumerAndressModel.setNumber("@ number with especial character");

        Set<ConstraintViolation<CostumerAndressModel>> violations = validator.validate(costumerAndressModel);

        assertFalse(violations.isEmpty());
    }

    @Test
    public void createCostumerAndressModelWithWrongComplement() {

        CostumerAndressModel costumerAndressModel = createCostumerAndressModel();

        costumerAndressModel.setComplement("@ complement with especial character");

        Set<ConstraintViolation<CostumerAndressModel>> violations = validator.validate(costumerAndressModel);

        assertFalse(violations.isEmpty());
    }

    @Test
    public void createCostumerAndressModelWithWrongDistrict() {

        CostumerAndressModel costumerAndressModel = createCostumerAndressModel();

        costumerAndressModel.setDistrict("@ SPA");

        Set<ConstraintViolation<CostumerAndressModel>> violations = validator.validate(costumerAndressModel);

        assertFalse(violations.isEmpty());
    }

    @Test
    public void createCostumerAndressModelWithWrongState() {

        CostumerAndressModel costumerAndressModel = createCostumerAndressModel();

        costumerAndressModel.setDistrict("@São Paulo");

        Set<ConstraintViolation<CostumerAndressModel>> violations = validator.validate(costumerAndressModel);

        assertFalse(violations.isEmpty());
    }

    @Test
    public void createCostumerAndressModelWithWrongCountry() {

        CostumerAndressModel costumerAndressModel = createCostumerAndressModel();

        costumerAndressModel.setCountry("@Brazil");

        Set<ConstraintViolation<CostumerAndressModel>> violations = validator.validate(costumerAndressModel);

        assertFalse(violations.isEmpty());
    }

    @Test
    public void createCostumerAndressModelWithWrongZipcode() {

        CostumerAndressModel costumerAndressModel = createCostumerAndressModel();

        costumerAndressModel.setZipcode(-120000);

        Set<ConstraintViolation<CostumerAndressModel>> violations = validator.validate(costumerAndressModel);

        assertFalse(violations.isEmpty());
    }

    @Test
    public void createCostumerAndressModelWithAllCorrectContent() {

        CostumerAndressModel costumerAndressModel = createCostumerAndressModel();

        Set<ConstraintViolation<CostumerAndressModel>> violations = validator.validate(costumerAndressModel);

        assertTrue(violations.isEmpty());
    }

    public CostumerAndressModel createCostumerAndressModel() {
        return new CostumerAndressModel(
                "Street Septima Zenobia",
                "90",
                "Paralel universe",
                "SP",
                "Athenas",
                "greek",
                23401
        );
    }
}
