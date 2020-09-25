package com.leolsbufalo.moon.repository;

import com.leolsbufalo.moon.entity.Payment;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentRepository extends CrudRepository<Payment, Integer> {

    Payment save(Payment payment);

}
