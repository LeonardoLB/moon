package com.leolsbufalo.moon.advices;

import com.leolsbufalo.moon.converter.CostumerConverter;
import com.leolsbufalo.moon.entity.Costumer;
import com.leolsbufalo.moon.model.CostumerModel;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CostumerConverterTest {

    @Test
    public void costumerConverterToEntityTest() {

        Costumer costumerEntity = costumerEntityMock();

        Costumer convertedCostumer = new CostumerConverter().convertFromDto(costumerModelMock());

        assertEquals(convertedCostumer.getName(), costumerEntity.getName(), "name must be equal");
        assertEquals(convertedCostumer.getEmail(), costumerEntity.getEmail(), "email must be equal");
        assertEquals(convertedCostumer.getPhoneCountryCode(), costumerEntity.getPhoneCountryCode(), "Phone country must be equal");
        assertEquals(convertedCostumer.getPhoneAreaCode(), costumerEntity.getPhoneAreaCode(), "Area code must be equal");
        assertEquals(convertedCostumer.getPhoneNumber(), costumerEntity.getPhoneNumber(), "phone number must be equal");
        assertEquals(convertedCostumer.getBirthDate(), costumerEntity.getBirthDate(), "birthday must be equal");
        assertEquals(convertedCostumer.getDocumentNumber(), costumerEntity.getDocumentNumber(), "document number must be equal");
    }

    @Test
    public void costumerConverterToModelTest() {

        CostumerModel costumerModel = costumerModelMock();

        CostumerModel convertedCostumerModel = new CostumerConverter().convertFromEntity(costumerEntityMock());

        assertEquals(convertedCostumerModel.getName(), costumerModel.getName(), "name must be equal");
        assertEquals(convertedCostumerModel.getEmail(), costumerModel.getEmail(), "email must be equal");
        assertEquals(convertedCostumerModel.getPhoneCountryCode(), costumerModel.getPhoneCountryCode(), "Phone country must be equal");
        assertEquals(convertedCostumerModel.getPhoneAreaCode(), costumerModel.getPhoneAreaCode(), "Area code must be equal");
        assertEquals(convertedCostumerModel.getPhoneNumber(), costumerModel.getPhoneNumber(), "phone number must be equal");
        assertEquals(convertedCostumerModel.getBirthDate(), costumerModel.getBirthDate(), "birthday must be equal");
        assertEquals(convertedCostumerModel.getDocumentNumber(), costumerModel.getDocumentNumber(), "document number must be equal");

    }


    public CostumerModel costumerModelMock() {
        return new CostumerModel(
                "Charlie de Luca",
                "charlie@cats.com",
                55,
                11,
                931902304,
                "03/03/03",
                "06200450005");
    }

    public Costumer costumerEntityMock() {
        return new Costumer(
                "Charlie de Luca",
                "charlie@cats.com",
                55,
                11,
                931902304,
                "03/03/03",
                "06200450005");
    }

}
