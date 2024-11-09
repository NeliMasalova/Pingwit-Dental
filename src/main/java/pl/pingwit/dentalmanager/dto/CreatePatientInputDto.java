package pl.pingwit.dentalmanager.dto;


import java.time.LocalDate;

public class CreatePatientInputDto {
    private String name;
    private String surname;
    private LocalDate birthdate;
    private String email;
    private String phone;
    private String address;

    /*
     1. Этот конструктор ничего не делает и он используется у тебя в PatientConverterTest. Скорее всего тест неверно работает
     2. String barbara, String smyk - жертвы рефакторинга
     */
    public CreatePatientInputDto(String barbara, String smyk, LocalDate of, String mail, String number, String s) {
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
