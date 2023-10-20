package com.adda.app.Service;

import java.util.List;

import com.adda.app.Entity.Payment;

public interface PaymentService {

	public Payment SavePayment(Payment payment);
	public List<Payment> getPaymentListOfSpecificUser(Long uid);
}
