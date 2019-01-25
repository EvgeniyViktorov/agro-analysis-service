package ua.help.agro.core.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import ua.help.agro.core.domain.PlantType;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Slf4j
@Builder
public class PlantTypeDto {
    private Long id;
    private String value;

    public static PlantType fromDto(PlantTypeDto plantTypeDto, PlantType plantType) {
        if (plantType == null) plantType = new PlantType();
        if (plantTypeDto.getId() != null) plantType.setId(plantTypeDto.getId());
        if (plantTypeDto.getValue() != null) plantType.setValue(plantTypeDto.getValue());
        return plantType;
    }
}

