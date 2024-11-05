package pl.pingwit.dentalmanager.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.pingwit.dentalmanager.dto.PaymentDto;
import pl.pingwit.dentalmanager.service.PaymentService;

import java.util.List;

@RestController
@RequestMapping("/payment")
public class PaymentController {
    private final PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @GetMapping
    public List<PaymentDto> paymentList() {
        return paymentService.paymentList();
    }

    @DeleteMapping("/{id}")
    public void deletePaymentById(@PathVariable(name = "id") Long id) {
        paymentService.deletePaymentById(id);

    }


}
