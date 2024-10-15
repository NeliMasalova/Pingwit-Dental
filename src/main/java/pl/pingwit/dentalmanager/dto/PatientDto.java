package pl.pingwit.dentalmanager.dto;

import java.time.LocalDate;

public class PatientDto {
    private Long id;
    private String name;
    private String surname;
    private LocalDate birthdate;
    private String phone;

    public PatientDto() {
    }

    public PatientDto(Long id, String name, String surname, LocalDate birthdate, String phone) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.birthdate = birthdate;
        this.phone = phone;
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

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
