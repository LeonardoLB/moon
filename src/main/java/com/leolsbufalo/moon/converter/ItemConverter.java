package com.leolsbufalo.moon.converter;

import com.leolsbufalo.moon.entity.Item;
import com.leolsbufalo.moon.model.ItemModel;

public class ItemConverter extends Converter<ItemModel, Item> {

    public ItemConverter() {
        super(ItemConverter::converterToItemEntity, ItemConverter::converterToItemModel);
    }

    private static ItemModel converterToItemModel(Item item) {
        return new ItemModel(
                item.getDescription(),
                item.getQuantity(),
                item.getPriceInCents()
        );
    }

    private static  Item converterToItemEntity(ItemModel itemModel) {
        return new Item(
                itemModel.getDescription(),
                itemModel.getQuantity(),
                itemModel.getPriceInCents()
        );
    }

}
