package com.leolsbufalo.moon.converter;

import com.leolsbufalo.moon.entity.PaymentCard;
import com.leolsbufalo.moon.model.CostumerCardModel;

public class CostumerCardConverter extends Converter<CostumerCardModel, PaymentCard> {

    public CostumerCardConverter() {
        super(CostumerCardConverter::convertToCostumerCardEntity, CostumerCardConverter::convertToCostumerCardModel);
    }

    public static CostumerCardModel convertToCostumerCardModel(PaymentCard costumerCard) {
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

    public static PaymentCard convertToCostumerCardEntity(CostumerCardModel costumerCardModel) {
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
