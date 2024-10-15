//package pl.pingwit.dentalmanager.integration;
//
//import org.junit.jupiter.api.Test;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.web.server.LocalServerPort;
//import org.springframework.core.ParameterizedTypeReference;
//import org.springframework.http.HttpEntity;
//import org.springframework.http.HttpHeaders;
//import org.springframework.http.HttpMethod;
//import org.springframework.http.MediaType;
//import org.springframework.http.ResponseEntity;
//import org.springframework.test.context.DynamicPropertyRegistry;
//import org.springframework.test.context.DynamicPropertySource;
//import org.springframework.web.client.RestTemplate;
//import org.testcontainers.containers.PostgreSQLContainer;
//import org.testcontainers.junit.jupiter.Container;
//import org.testcontainers.junit.jupiter.Testcontainers;
//import pl.pingwit.dentalmanager.PingwitDentalManagerApplication;
//import pl.pingwit.dentalmanager.dto.AppointmentDto;
//import pl.pingwit.dentalmanager.entity.DentalTreatment;
//import pl.pingwit.dentalmanager.entity.Doctor;
//import pl.pingwit.dentalmanager.entity.Patient;
//
//import java.time.LocalDate;
//import java.util.HashSet;
//import java.util.List;
//import java.util.Set;
//
//import static org.assertj.core.api.Assertions.assertThat;
//import static pl.pingwit.dentalmanager.entity.AppointmentStatus.PLANNED;
//
//@Testcontainers
//@SpringBootTest(classes = {PingwitDentalManagerApplication.class},
//        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
//class AppointmentIT {
//    @Container
//    static PostgreSQLContainer<?> postgres = new PostgreSQLContainer<>("postgres:latest");
//    @LocalServerPort
//    private Integer port;
//
//    @DynamicPropertySource
//    static void postgresProperties(DynamicPropertyRegistry registry) {
//        registry.add("spring.datasource.url", postgres::getJdbcUrl);
//        registry.add("spring.datasource.username", postgres::getPassword);
//        registry.add("spring.datasource.password", postgres::getUsername);
//        registry.add("spring.datasource.driver-class-name", postgres::getDriverClassName);
//    }
//
//    @Test
//    void verifyAppointmentLifecycle() {
//        AppointmentDto inputDto = new AppointmentDto();
//        inputDto.setDate(LocalDate.of(2024, 10, 10));
//        inputDto.setAppointmentStatus(PLANNED);
//
//        Patient patient = new Patient();
//        patient.setId(1L);
//        patient.setName("Test name");
//
//        Doctor doctor = new Doctor();
//        doctor.setId(1L);
//        doctor.setName("Test name");
//
//        inputDto.setPatient(patient);
//        inputDto.setDoctor(doctor);
//        DentalTreatment firstTreatment = new DentalTreatment();
//        firstTreatment.setId(1L);
//        firstTreatment.setName("Test name");
//
//        DentalTreatment secondTreatment = new DentalTreatment();
//        secondTreatment.setId(2L);
//        secondTreatment.setName("Test name");
//
//        Set<DentalTreatment> dentalTreatments = new HashSet<>();
//        dentalTreatments.add(firstTreatment);
//        dentalTreatments.add(secondTreatment);
//
//        inputDto.setDentalTreatment(dentalTreatments);
//
//        RestTemplate restTemplate = new RestTemplate();
//        HttpHeaders headers = new HttpHeaders();
//        headers.setContentType(MediaType.APPLICATION_JSON);
//        headers.setBasicAuth("admin", "admin");
//
//        HttpEntity<AppointmentDto> request = new HttpEntity<>(inputDto, headers);
//        String appointmentUrl = "http://localhost:" + port + "/appointment";
//
//        ResponseEntity<Long> createdResponse = restTemplate.postForEntity(appointmentUrl, request, Long.class);
//        assertThat(createdResponse.getStatusCode().is2xxSuccessful()).isTrue();
//        Long createdAppointmentId = createdResponse.getBody();
//
//        ResponseEntity<AppointmentDto> response = restTemplate.exchange(
//                appointmentUrl + "/" + createdAppointmentId,
//                HttpMethod.GET,
//                new HttpEntity<>(headers),
//                AppointmentDto.class
//        );
//
//        AppointmentDto appointmentDto = response.getBody();
//        assertThat(appointmentDto.getDate()).isEqualTo(LocalDate.of(2024, 10, 10));
//        assertThat(appointmentDto.getAppointmentStatus()).isEqualTo("SCHEDULED");
//        assertThat(appointmentDto.getPatient().getName()).isEqualTo("John Doe");
//        assertThat(appointmentDto.getDoctor().getName()).isEqualTo("Dr. Smith");
//
//        assertThat(appointmentDto.getDentalTreatment()).hasSize(2);
//        assertThat(appointmentDto.getDentalTreatment()).extracting("name").contains("Teeth Whitening", "Cavity Filling");
//
//        ResponseEntity<List<AppointmentDto>> listResponse = restTemplate.exchange(
//                appointmentUrl,
//                HttpMethod.GET,
//                new HttpEntity<>(headers),
//                new ParameterizedTypeReference<List<AppointmentDto>>() {}
//        );
//
//        List<AppointmentDto> appointments = listResponse.getBody();
//        assertThat(listResponse.getStatusCode().is2xxSuccessful()).isTrue();
//        assertThat(appointments.size()).isGreaterThanOrEqualTo(1);
//    }
//}