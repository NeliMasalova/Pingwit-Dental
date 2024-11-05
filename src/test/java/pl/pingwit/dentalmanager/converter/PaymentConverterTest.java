package pl.pingwit.dentalmanager.converter;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.pingwit.dentalmanager.dto.PaymentDto;
import pl.pingwit.dentalmanager.entity.Payment;
import pl.pingwit.dentalmanager.entity.TypePayment;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class PaymentConverterTest {
    private PaymentConverter paymentConverter;

    @BeforeEach
    void setUp() {
        paymentConverter = new PaymentConverter();
    }

    @Test
    void convertToDto() {
        Payment payment = new Payment();

        payment.setName("Full Payment");
        payment.setDate(LocalDate.of(2023, 11, 1));
        payment.setTypePayment(TypePayment.CARD);

        PaymentDto paymentDto = paymentConverter.convertToDto(payment);

        assertEquals(payment.getName(), paymentDto.getName());
        assertEquals(payment.getDate(), paymentDto.getDate());
        assertEquals(payment.getTypePayment(), paymentDto.getTypePayment());

    }
}