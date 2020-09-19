package com.leolsbufalo.moon.converter;

import com.leolsbufalo.moon.entity.CostumerAndress;
import com.leolsbufalo.moon.model.CostumerAndressModel;

public class CostumerAndressConverter extends Converter<CostumerAndressModel, CostumerAndress> {

    public CostumerAndressConverter() {
        super(CostumerAndressConverter::converToCostumerAndressEntity, CostumerAndressConverter::convertToCostumerAndressModel);
    }

    public static CostumerAndressModel convertToCostumerAndressModel(CostumerAndress costumerAndress) {
        return new CostumerAndressModel(
                costumerAndress.getStreet(),
                costumerAndress.getNumber(),
                costumerAndress.getComplement(),
                costumerAndress.getDistrict(),
                costumerAndress.getState(),
                costumerAndress.getCountry(),
                costumerAndress.getZipcode()
        );
    }

    public  static CostumerAndress converToCostumerAndressEntity(CostumerAndressModel costumerAndressModel) {
        return new CostumerAndress(
                costumerAndressModel.getStreet(),
                costumerAndressModel.getNumber(),
                costumerAndressModel.getComplement(),
                costumerAndressModel.getDistrict(),
                costumerAndressModel.getState(),
                costumerAndressModel.getCountry(),
                costumerAndressModel.getZipcode()
        );
    }

}
