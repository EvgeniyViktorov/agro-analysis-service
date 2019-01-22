package ua.help.agro.core.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import ua.help.agro.core.domain.Field;
import ua.help.agro.core.domain.PlantType;
import ua.help.agro.core.domain.User;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Slf4j
@Builder
public class FieldDto {
    private Long id;
    private Integer number;
    private User responsible;
    private LocalDate sowingDate;
    private String plant;
    private PlantType plantType;
    private User creator;
    private Long approximatePlantsAmount;
    private String googleMapsSrc;

    public static Field fromDto(FieldDto fieldDto, Field field) {
        if (fieldDto == null) return field;
        if (field == null) field = new Field();
        if (fieldDto.getId() != null) field.setId(fieldDto.getId());
        if (fieldDto.getNumber() != null) field.setNumber(fieldDto.getNumber());
        if (fieldDto.getResponsible() != null) field.setResponsible(fieldDto.getResponsible());
        if (fieldDto.getSowingDate() != null) field.setSowingDate(fieldDto.getSowingDate());
        if (fieldDto.getPlant() != null) field.setPlant(fieldDto.getPlant());
        if (fieldDto.getPlantType() != null) field.setPlantType(fieldDto.getPlantType());
        if (fieldDto.getCreator() != null) field.setCreator(fieldDto.getCreator());
        if (fieldDto.getApproximatePlantsAmount() != null)
            field.setApproximatePlantsAmount(fieldDto.getApproximatePlantsAmount());
        if (fieldDto.getGoogleMapsSrc() != null) field.setGoogleMapsSrc(fieldDto.getGoogleMapsSrc());
        return field;
    }
}
