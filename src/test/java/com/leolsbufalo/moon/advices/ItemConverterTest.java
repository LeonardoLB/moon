package com.leolsbufalo.moon.advices;

import com.leolsbufalo.moon.converter.ItemConverter;
import com.leolsbufalo.moon.entity.Item;
import com.leolsbufalo.moon.model.ItemModel;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class ItemConverterTest {

    @Test
    public void ItemConverterToEntityTest() {
        ItemModel itemModel =  new ItemModel( "Teste", 5, 1050 );
        Item item = new Item("Teste", 5, 1050 );

        Item itemConverted = new ItemConverter().convertFromDto(itemModel);

        assertEquals(item.getDescription(), itemConverted.getDescription(), " description must be equal");
        assertEquals(item.getPriceInCents(), itemConverted.getPriceInCents(), "price in cents must be equal");
        assertEquals(item.getQuantity(), itemConverted.getQuantity(), "quantity must be equal");
    }

    @Test
    public void ItemConvertToModelTest() {
        ItemModel itemModel =  new ItemModel( "Teste", 5, 1050 );
        Item item = new Item("Teste", 5, 1050 );

        ItemModel itemModelConverted = new ItemConverter().convertFromEntity(item);

        assertEquals(itemModel.getDescription(), itemModelConverted.getDescription(), " description must be equal");
        assertEquals(itemModel.getPriceInCents(), itemModelConverted.getPriceInCents(), " price in cents must be equal");
        assertEquals(itemModel.getQuantity(), itemModelConverted.getQuantity(), "quantity must be equal");
    }
}
