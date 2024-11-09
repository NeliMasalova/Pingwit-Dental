package pl.pingwit.dentalmanager.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import pl.pingwit.dentalmanager.entity.TypePayment;

import java.math.BigDecimal;
import java.time.LocalDate;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PaymentDto {
    private Long id;
    private String name;
    private LocalDate date;
    private TypePayment typePayment;
    private BigDecimal amount;

    public PaymentDto() {
    }

    // этот конструктор нигде не используется, может удалим?
    public PaymentDto(Long id, String name, LocalDate date, TypePayment typePayment, BigDecimal amount) {
        this.id = id;
        this.name = name;
        this.date = date;
        this.typePayment = typePayment;
        this.amount = amount;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public TypePayment getTypePayment() {
        return typePayment;
    }

    public void setTypePayment(TypePayment typePayment) {
        this.typePayment = typePayment;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
}
