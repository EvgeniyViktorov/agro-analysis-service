package ua.help.agro.core.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import ua.help.agro.core.domain.FormValue;
import ua.help.agro.core.domain.LeafColor;
import ua.help.agro.core.domain.PlantType;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Slf4j
@Builder
public class FormValueDto {

    private Long id;
    private PlantType plantType;
    private String stemLength;
    private String stemThickness;
    private String branchesAmount;
    private String leafLength;
    private String leafWidth;
    private LeafColor leafColor;
    private String fruitsAmount;
    private String fruitLength;
    private String sweetness;
    private String note;

    public static FormValue fromDto(FormValueDto formValueDto, FormValue formValue) {
        if (formValue == null) formValue = new FormValue();
        if (formValueDto == null) return formValue;
        if (formValueDto.getPlantType() != null) formValue.setPlantType(formValueDto.getPlantType());
        if (formValueDto.getStemLength() != null) formValue.setStemLength(formValueDto.getStemLength());
        if (formValueDto.getStemThickness() != null)
            formValue.setStemThickness(formValueDto.getStemThickness());
        if (formValueDto.getBranchesAmount() != null)
            formValue.setBranchesAmount(Integer.parseInt(formValueDto.getBranchesAmount()));
        if (formValueDto.getLeafLength() != null) formValue.setLeafLength(formValueDto.getLeafLength());
        if (formValueDto.getLeafWidth() != null) formValue.setLeafWidth(formValueDto.getLeafWidth());
        if (formValueDto.getLeafColor() != null) formValue.setLeafColor(formValueDto.getLeafColor());
        if (formValueDto.getFruitsAmount() != null)
            formValue.setFruitsAmount(Integer.parseInt(formValueDto.getFruitsAmount()));
        if (formValueDto.getFruitLength() != null)
            formValue.setFruitLength(formValueDto.getFruitLength());
        if (formValueDto.getSweetness() != null) formValue.setSweetness(Integer.parseInt(formValueDto.getSweetness()));
        if (formValueDto.getNote() != null) formValue.setNote(formValueDto.getNote());
        return formValue;
    }

    public static FormValueDto toDto(FormValue formValue) {
        return FormValueDto.builder()
                .plantType(formValue.getPlantType())
                .stemLength(formValue.getStemLength())
                .stemThickness(formValue.getStemThickness())
                .branchesAmount(formValue.getBranchesAmount().toString())
                .leafLength(formValue.getLeafLength())
                .leafWidth(formValue.getLeafWidth())
                .leafColor(formValue.getLeafColor())
                .fruitsAmount(formValue.getFruitsAmount().toString())
                .fruitLength(formValue.getFruitLength())
                .sweetness(formValue.getSweetness().toString())
                .note(formValue.getNote())
                .build();
    }
}
