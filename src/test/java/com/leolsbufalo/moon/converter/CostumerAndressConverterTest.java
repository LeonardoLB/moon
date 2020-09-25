package com.leolsbufalo.moon.converter;

import com.leolsbufalo.moon.entity.CostumerAndress;
import com.leolsbufalo.moon.model.CostumerAndressModel;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class CostumerAndressConverterTest {

    @Test
    public void costumerAndressToEntityTest() {

        CostumerAndressModel costumerAndressModel = costumerAndressModelMock();
        CostumerAndress costumerAndressConverted = new CostumerAndressConverter().convertFromDto(costumerAndressModel);

        assertEquals(costumerAndressModel.getStreet(), costumerAndressConverted.getStreet(), "Street must be equal");
        assertEquals(costumerAndressModel.getNumber(), costumerAndressConverted.getNumber(), "Number must be equal");
        assertEquals(costumerAndressModel.getComplement(), costumerAndressConverted.getComplement(), "Complement must be equal");
        assertEquals(costumerAndressModel.getDistrict(), costumerAndressConverted.getDistrict(), "District must be equal");
        assertEquals(costumerAndressModel.getState(), costumerAndressConverted.getState(), "State must be equal");
        assertEquals(costumerAndressModel.getCountry(), costumerAndressConverted.getCountry(), "Country must be equal");
        assertEquals(costumerAndressModel.getZipcode(), costumerAndressConverted.getZipcode(), "Zipcode must be equal");

    }

    @Test
    public void costumerAndressToModelTest() {

        CostumerAndress costumerCard = costumerAndressMock();
        CostumerAndressModel costumerAndressModelConverted = new CostumerAndressConverter().convertFromEntity(costumerCard);

        assertEquals(costumerCard.getStreet(), costumerAndressModelConverted.getStreet(), "Street must be equal");
        assertEquals(costumerCard.getNumber(), costumerAndressModelConverted.getNumber(), "Number must be equal");
        assertEquals(costumerCard.getComplement(), costumerAndressModelConverted.getComplement(), "Complement must be equal");
        assertEquals(costumerCard.getDistrict(), costumerAndressModelConverted.getDistrict(), "District must be equal");
        assertEquals(costumerCard.getState(), costumerAndressModelConverted.getState(), "State must be equal");
        assertEquals(costumerCard.getCountry(), costumerAndressModelConverted.getCountry(), "Country must be equal");
        assertEquals(costumerCard.getZipcode(), costumerAndressModelConverted.getZipcode(), "Zipcode must be equal");

    }

    public CostumerAndress costumerAndressMock() {
        return new CostumerAndress(
                "Rua Andromeda",
                900,
                "apt 2030",
                "sistema cosmico",
                "Universo",
                "Realidade",
                0000000);
    }

    public CostumerAndressModel costumerAndressModelMock(){
        return new CostumerAndressModel(
                "Rua Andromeda",
                900,
                "apt 2030",
                "sistema cosmico",
                "Universo",
                "Realidade",
                0000000);
    }
}
