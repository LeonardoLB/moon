package com.leolsbufalo.moon.converter;

import com.leolsbufalo.moon.entity.CostumerCard;
import com.leolsbufalo.moon.model.CostumerCardModel;

public class CostumerCardConverter extends Converter<CostumerCardModel, CostumerCard> {

    public CostumerCardConverter() {
        super(CostumerCardConverter::convertToCostumerCardEntity, CostumerCardConverter::convertToCostumerCardModel);
    }

    public static CostumerCardModel convertToCostumerCardModel(CostumerCard costumerCard) {
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

    public static CostumerCard convertToCostumerCardEntity(CostumerCardModel costumerCardModel) {
        return new CostumerCard(
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
