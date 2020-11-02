package com.leolsbufalo.moon.converter;

import com.leolsbufalo.moon.entity.PaymentItem;
import com.leolsbufalo.moon.model.ItemModel;

public class PaymentItemConverter extends Converter<ItemModel, PaymentItem> {

    public PaymentItemConverter() {
        super(PaymentItemConverter::converterToPayamentItemEntity, PaymentItemConverter::converterToPaymentItemModel);
    }

    private static ItemModel converterToPaymentItemModel(PaymentItem item) {
        return new ItemModel(
                item.getDescription(),
                item.getQuantity(),
                item.getPriceInCents()
        );
    }

    private static PaymentItem converterToPayamentItemEntity(ItemModel itemModel) {
        return new PaymentItem(
                itemModel.getDescription(),
                itemModel.getQuantity(),
                itemModel.getPriceInCents()
        );
    }

}
