package pl.pingwit.dentalmanager.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "treatment")
public class DentalTreatment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "description")
    private String description;
    @Column(name = "price")
    private BigDecimal price;
    @ManyToMany(mappedBy = "dentalTreatments")
    private Set<Appointment> appointments = new HashSet<>();

    public Set<Appointment> getAppointments() {
        return appointments;
    }

    public DentalTreatment() {
    }

    public void setAppointments(Set<Appointment> appointments) {
        this.appointments = appointments;
    }

    public DentalTreatment(Long id, String name, String description, BigDecimal price, Set<Appointment> appointments) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.appointments = appointments;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}