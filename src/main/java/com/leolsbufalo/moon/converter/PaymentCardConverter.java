package com.leolsbufalo.moon.converter;

import com.leolsbufalo.moon.entity.PaymentCard;
import com.leolsbufalo.moon.model.CostumerCardModel;

public class PaymentCardConverter extends Converter<CostumerCardModel, PaymentCard> {

    public PaymentCardConverter() {
        super(PaymentCardConverter::convertToPaymentCardEntity, PaymentCardConverter::convertToPaymentCardModel);
    }

    public static CostumerCardModel convertToPaymentCardModel(PaymentCard costumerCard) {
        return new CostumerCardModel(
                costumerCard.getMethod(),
                costumerCard.getNumber(),
                costumerCard.getCvc(),
                costumerCard.getName(),
                costumerCard.getDocumentNumber(),
                costumerCard.getExpirationMonth(),
                costumerCard.getExpirationYear()
        );
    }

    public static PaymentCard convertToPaymentCardEntity(CostumerCardModel costumerCardModel) {
        return new PaymentCard(
                costumerCardModel.getMethod(),
                costumerCardModel.getNumber(),
                costumerCardModel.getCvc(),
                costumerCardModel.getName(),
                costumerCardModel.getDocumentNumber(),
                costumerCardModel.getExpirationMonth(),
                costumerCardModel.getExpirationYear()
        );
    }

}
