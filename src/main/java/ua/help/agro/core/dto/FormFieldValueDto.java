package ua.help.agro.core.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import ua.help.agro.core.domain.FormFieldValue;
import ua.help.agro.core.domain.LeafColor;
import ua.help.agro.core.domain.PlantType;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Slf4j
@Builder
public class FormFieldValueDto {

    private Long id;
    private PlantType plantType;
    private String stemLength;
    private String stemThickness;
    private Integer branchesAmount;
    private String leafLength;
    private String leafWidth;
    private LeafColor leafColor;
    private Integer fruitsAmount;
    private String fruitLength;
    private Integer sweetness;
    private String note;

    public static FormFieldValue fromDto(FormFieldValueDto formFieldValueDto, FormFieldValue formFieldValue) {
        if (formFieldValue == null) formFieldValue = new FormFieldValue();
        if (formFieldValueDto == null) return formFieldValue;
        if (formFieldValueDto.getId() != null) formFieldValue.setId(formFieldValueDto.getId());
        if (formFieldValueDto.getPlantType() != null) formFieldValue.setPlantType(formFieldValueDto.getPlantType());
        if (formFieldValueDto.getStemLength() != null) formFieldValue.setStemLength(formFieldValueDto.getStemLength());
        if (formFieldValueDto.getStemThickness() != null)
            formFieldValue.setStemThickness(formFieldValueDto.getStemThickness());
        if (formFieldValueDto.getBranchesAmount() != null)
            formFieldValue.setBranchesAmount(formFieldValueDto.getBranchesAmount());
        if (formFieldValueDto.getLeafLength() != null) formFieldValue.setLeafLength(formFieldValueDto.getLeafLength());
        if (formFieldValueDto.getLeafWidth() != null) formFieldValue.setLeafWidth(formFieldValueDto.getLeafWidth());
        if (formFieldValueDto.getLeafColor() != null) formFieldValue.setLeafColor(formFieldValueDto.getLeafColor());
        if (formFieldValueDto.getFruitsAmount() != null)
            formFieldValue.setFruitsAmount(formFieldValueDto.getFruitsAmount());
        if (formFieldValueDto.getFruitLength() != null)
            formFieldValue.setFruitLength(formFieldValueDto.getFruitLength());
        if (formFieldValueDto.getSweetness() != null) formFieldValue.setSweetness(formFieldValueDto.getSweetness());
        if (formFieldValueDto.getNote() != null) formFieldValue.setNote(formFieldValueDto.getNote());
        return formFieldValue;
    }

    public static FormFieldValueDto toDto(FormFieldValue formFieldValue) {
        return new FormFieldValueDto().builder()
                .id(formFieldValue.getId())
                .plantType(formFieldValue.getPlantType())
                .stemLength(formFieldValue.getStemLength())
                .stemThickness(formFieldValue.getStemThickness())
                .branchesAmount(formFieldValue.getBranchesAmount())
                .leafLength(formFieldValue.getLeafLength())
                .leafWidth(formFieldValue.getLeafWidth())
                .leafColor(formFieldValue.getLeafColor())
                .fruitsAmount(formFieldValue.getFruitsAmount())
                .fruitLength(formFieldValue.getFruitLength())
                .sweetness(formFieldValue.getSweetness())
                .note(formFieldValue.getNote())
                .build();
    }
}
