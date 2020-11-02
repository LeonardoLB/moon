package com.leolsbufalo.moon.converter;

import com.leolsbufalo.moon.entity.Payment;
import com.leolsbufalo.moon.model.PaymentModel;

public class PaymentConverter extends Converter<PaymentModel, Payment> {

    private static PaymentItemConverter itemConverter = new PaymentItemConverter();
    private static PaymentCardConverter paymentCardConverter = new PaymentCardConverter();
    private static CostumerAndressConverter costumerAndressConverter = new CostumerAndressConverter();
    private static CostumerConverter costumerConverter = new CostumerConverter();


    public PaymentConverter() {
        super(PaymentConverter::convertToPaymentEntity, PaymentConverter::convertToPaymentModel);
    }


    public static PaymentModel convertToPaymentModel(Payment payment) {
        return new PaymentModel(
                payment.getCurrency(),
                payment.getValueInCents(),
                payment.getInstallments(),
                itemConverter.createFromEntities(payment.getItems()),
                paymentCardConverter.convertFromEntity(payment.getCostumerCard()),
                costumerConverter.convertFromEntity(payment.getCostumer())
        );
    }

    public static Payment convertToPaymentEntity(PaymentModel paymentModel) {
        return new Payment(
                paymentModel.getUnique_id(),
                paymentModel.getCurrency(),
                paymentModel.getValueInCents(),
                paymentModel.getInstallments(),
                itemConverter.createFromDtos(paymentModel.getItems()),
                paymentCardConverter.convertFromDto(paymentModel.getCostumerCard()),
                costumerConverter.convertToCostumerEntity(paymentModel.getCostumer())
        );
    }


}
