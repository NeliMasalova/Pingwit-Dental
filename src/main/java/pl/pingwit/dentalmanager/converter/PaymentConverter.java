package pl.pingwit.dentalmanager.converter;

import org.springframework.stereotype.Component;
import pl.pingwit.dentalmanager.dto.PaymentDto;
import pl.pingwit.dentalmanager.entity.Payment;
import pl.pingwit.dentalmanager.repository.AppointmentRepository;

@Component
public class PaymentConverter {

    public PaymentDto convertToDto(Payment payment) {
        PaymentDto paymentDto = new PaymentDto();
        paymentDto.setName(payment.getName());
        paymentDto.setDate(payment.getDate());
        paymentDto.setTypePayment(payment.getTypePayment());

        return paymentDto;
    }


}