package com.leolsbufalo.moon.converter;

import com.leolsbufalo.moon.entity.Costumer;
import com.leolsbufalo.moon.model.CostumerModel;

public class CostumerConverter extends Converter<CostumerModel, Costumer> {

    public CostumerConverter() {
        super(CostumerConverter::convertToCostumerEntity, CostumerConverter::convertToCostumerModel);
    }

    public static CostumerModel convertToCostumerModel(Costumer costumer) {
        return new CostumerModel(
                costumer.getName(),
                costumer.getEmail(),
                costumer.getPhoneCountryCode(),
                costumer.getPhoneAreaCode(),
                costumer.getPhoneNumber(),
                costumer.getBirthDate(),
                costumer.getDocumentNumber()
        );
    }

    public static Costumer convertToCostumerEntity(CostumerModel costumerModel) {
        return new Costumer(
                costumerModel.getName(),
                costumerModel.getEmail(),
                costumerModel.getPhoneCountryCode(),
                costumerModel.getPhoneAreaCode(),
                costumerModel.getPhoneNumber(),
                costumerModel.getBirthDate(),
                costumerModel.getDocumentNumber()
        );
    }
}
