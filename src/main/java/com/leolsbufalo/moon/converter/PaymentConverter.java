package com.leolsbufalo.moon.converter;

import com.leolsbufalo.moon.entity.Payment;
import com.leolsbufalo.moon.model.PaymentModel;

public class PaymentConverter extends Converter<PaymentModel, Payment> {

    private static ItemConverter itemConverter = new ItemConverter();
    private static CostumerCardConverter costumerCardConverter = new CostumerCardConverter();
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
                costumerCardConverter.convertFromEntity(payment.getCostumerCard()),
                costumerAndressConverter.convertFromEntity(payment.getCostumerAndress()),
                costumerConverter.convertFromEntity(payment.getCostumer())
        );
    }

    public static Payment convertToPaymentEntity(PaymentModel paymentModel) {
        return new Payment(
                paymentModel.getCurrency(),
                paymentModel.getValueInCents(),
                paymentModel.getInstallments(),
                itemConverter.createFromDtos(paymentModel.getItems()),
                costumerCardConverter.convertFromDto(paymentModel.getCostumerCard()),
                costumerAndressConverter.convertFromDto(paymentModel.getCostumerAndress()),
                costumerConverter.convertToCostumerEntity(paymentModel.getCostumer())
        );
    }


}
