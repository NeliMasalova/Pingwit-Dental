package pl.pingwit.dentalmanager.service;

import pl.pingwit.dentalmanager.dto.PaymentDto;

import java.util.List;

public interface PaymentService {
    List<PaymentDto> paymentList();

    void deletePaymentById(Long id);
}