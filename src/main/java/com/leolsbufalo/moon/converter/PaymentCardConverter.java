package com.leolsbufalo.moon.converter;

import com.leolsbufalo.moon.entity.PaymentCard;
import com.leolsbufalo.moon.model.PaymentCardModel;

public class PaymentCardConverter extends Converter<PaymentCardModel, PaymentCard> {

    public PaymentCardConverter() {
        super(PaymentCardConverter::convertToPaymentCardEntity, PaymentCardConverter::convertToPaymentCardModel);
    }

    public static PaymentCardModel convertToPaymentCardModel(PaymentCard costumerCard) {
        return new PaymentCardModel(
                costumerCard.getMethod(),
                costumerCard.getNumber(),
                costumerCard.getCvc(),
                costumerCard.getName(),
                costumerCard.getDocumentNumber(),
                costumerCard.getExpirationMonth(),
                costumerCard.getExpirationYear()
        );
    }

    public static PaymentCard convertToPaymentCardEntity(PaymentCardModel paymentCardModel) {
        return new PaymentCard(
                paymentCardModel.getMethod(),
                paymentCardModel.getNumber(),
                paymentCardModel.getCvc(),
                paymentCardModel.getName(),
                paymentCardModel.getDocumentNumber(),
                paymentCardModel.getExpirationMonth(),
                paymentCardModel.getExpirationYear()
        );
    }

}
