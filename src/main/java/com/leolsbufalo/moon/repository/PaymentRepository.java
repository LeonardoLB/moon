package com.leolsbufalo.moon.repository;

import com.leolsbufalo.moon.entity.Payment;
import org.springframework.data.repository.CrudRepository;

public interface PaymentRepository extends CrudRepository<Payment, Integer> {

    Payment save(Payment payment);

}
