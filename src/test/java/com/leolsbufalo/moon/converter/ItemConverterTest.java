package com.leolsbufalo.moon.converter;

import com.leolsbufalo.moon.entity.PaymentItem;
import com.leolsbufalo.moon.model.PaymentItemModel;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class ItemConverterTest {

    @Test
    public void itemConverterToEntityTest() {
        PaymentItemModel paymentItemModel =  new PaymentItemModel( "Teste", 5, 1050 );
        PaymentItem item = new PaymentItem("Teste", 5, 1050 );

        PaymentItem itemConverted = new PaymentItemConverter().convertFromDto(paymentItemModel);

        assertEquals(item.getDescription(), itemConverted.getDescription(), " description must be equal");
        assertEquals(item.getPriceInCents(), itemConverted.getPriceInCents(), "price in cents must be equal");
        assertEquals(item.getQuantity(), itemConverted.getQuantity(), "quantity must be equal");
    }

    @Test
    public void itemConvertToModelTest() {
        PaymentItemModel paymentItemModel =  new PaymentItemModel( "Teste", 5, 1050 );
        PaymentItem item = new PaymentItem("Teste", 5, 1050 );

        PaymentItemModel paymentItemModelConverted = new PaymentItemConverter().convertFromEntity(item);

        assertEquals(paymentItemModel.getDescription(), paymentItemModelConverted.getDescription(), " description must be equal");
        assertEquals(paymentItemModel.getPriceInCents(), paymentItemModelConverted.getPriceInCents(), " price in cents must be equal");
        assertEquals(paymentItemModel.getQuantity(), paymentItemModelConverted.getQuantity(), "quantity must be equal");
    }
}
