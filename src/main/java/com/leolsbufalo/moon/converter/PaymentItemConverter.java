package com.leolsbufalo.moon.converter;

import com.leolsbufalo.moon.entity.PaymentItem;
import com.leolsbufalo.moon.model.PaymentItemModel;

public class PaymentItemConverter extends Converter<PaymentItemModel, PaymentItem> {

    public PaymentItemConverter() {
        super(PaymentItemConverter::converterToPayamentItemEntity, PaymentItemConverter::converterToPaymentItemModel);
    }

    private static PaymentItemModel converterToPaymentItemModel(PaymentItem item) {
        return new PaymentItemModel(
                item.getDescription(),
                item.getQuantity(),
                item.getPriceInCents()
        );
    }

    private static PaymentItem converterToPayamentItemEntity(PaymentItemModel paymentItemModel) {
        return new PaymentItem(
                paymentItemModel.getDescription(),
                paymentItemModel.getQuantity(),
                paymentItemModel.getPriceInCents()
        );
    }

}
