package com.leolsbufalo.moon.converter;

import com.leolsbufalo.moon.entity.PaymentItem;
import com.leolsbufalo.moon.model.ItemModel;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class ItemConverterTest {

    @Test
    public void itemConverterToEntityTest() {
        ItemModel itemModel =  new ItemModel( "Teste", 5, 1050 );
        PaymentItem item = new PaymentItem("Teste", 5, 1050 );

        PaymentItem itemConverted = new PaymentItemConverter().convertFromDto(itemModel);

        assertEquals(item.getDescription(), itemConverted.getDescription(), " description must be equal");
        assertEquals(item.getPriceInCents(), itemConverted.getPriceInCents(), "price in cents must be equal");
        assertEquals(item.getQuantity(), itemConverted.getQuantity(), "quantity must be equal");
    }

    @Test
    public void itemConvertToModelTest() {
        ItemModel itemModel =  new ItemModel( "Teste", 5, 1050 );
        PaymentItem item = new PaymentItem("Teste", 5, 1050 );

        ItemModel itemModelConverted = new PaymentItemConverter().convertFromEntity(item);

        assertEquals(itemModel.getDescription(), itemModelConverted.getDescription(), " description must be equal");
        assertEquals(itemModel.getPriceInCents(), itemModelConverted.getPriceInCents(), " price in cents must be equal");
        assertEquals(itemModel.getQuantity(), itemModelConverted.getQuantity(), "quantity must be equal");
    }
}
