package com.adda.app.reposatory;

import org.springframework.data.jpa.repository.JpaRepository;

import com.adda.app.Entity.Payment;

public interface PaymentRepo extends JpaRepository<Payment, Long> {

}
