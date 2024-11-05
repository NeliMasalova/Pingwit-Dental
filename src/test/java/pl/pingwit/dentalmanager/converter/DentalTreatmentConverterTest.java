package pl.pingwit.dentalmanager.converter;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.pingwit.dentalmanager.dto.DentalTreatmentDto;
import pl.pingwit.dentalmanager.entity.DentalTreatment;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class DentalTreatmentConverterTest {
    private DentalTreatmentConverter dentalTreatmentConverter;

    @BeforeEach
    void setUp() {
        dentalTreatmentConverter = new DentalTreatmentConverter();
    }

    @Test
    void convertToDto() {
        DentalTreatment dentalTreatment = new DentalTreatment();

        dentalTreatment.setId(1L);
        dentalTreatment.setPrice(BigDecimal.valueOf(100.0));
        dentalTreatment.setName("Wypełninie stałe 3-powierszchniowe.");
        dentalTreatment.setDescription("Kompozyt Asteria A2B + Brilliant Flow A2.");

        DentalTreatmentDto dentalTreatmentDto = dentalTreatmentConverter.convertToDto(dentalTreatment);

        assertNotNull(dentalTreatmentDto);
        assertEquals(dentalTreatment.getId(), dentalTreatmentDto.getId());
        assertEquals(dentalTreatment.getPrice(), dentalTreatmentDto.getPrice());
        assertEquals(dentalTreatment.getName(), dentalTreatmentDto.getName());
        assertEquals(dentalTreatment.getDescription(), dentalTreatmentDto.getDescription());

    }

    @Test
    void convertToEntity() {
        DentalTreatmentDto dentalTreatmentDto = new DentalTreatmentDto("Wypełninie stałe 3-powierszchniowe.", "Kompozyt Asteria A2B + Brilliant Flow A2.", BigDecimal.valueOf(100.0));
        DentalTreatment dentalTreatment = dentalTreatmentConverter.convertToEntity(dentalTreatmentDto);
        assertNotNull(dentalTreatment);
        assertEquals(dentalTreatmentDto.getName(), dentalTreatment.getName());
        assertEquals(dentalTreatmentDto.getDescription(), dentalTreatment.getDescription());
        assertEquals(dentalTreatmentDto.getPrice(), dentalTreatment.getPrice());
    }
}