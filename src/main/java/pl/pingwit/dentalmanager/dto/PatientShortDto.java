package pl.pingwit.dentalmanager.dto;

import java.time.LocalDate;

public class PatientShortDto { // не уверен в необходимости этого класса, по сути только поля id нету
    private String name;
    private String surname;
    private LocalDate birthdate;
    private String phone;

    public PatientShortDto() { // Constructor 'PatientShortDto()' is never used
    }

    public PatientShortDto(String name, String surname, LocalDate birthdate, String phone) {
        this.name = name;
        this.surname = surname;
        this.birthdate = birthdate;
        this.phone = phone;
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
