package ua.help.agro.core.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import ua.help.agro.core.domain.FormStructure;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Slf4j
@Builder
public class FormStructureDto {
    private Long id;
    private String fieldName;
    private String fieldNameShown;
    private String fieldType;
    private Boolean isRequired;
    private String value;

    public static FormStructure fromDto(FormStructureDto formStructureDto, FormStructure formStructure) {
        if (formStructureDto == null) return formStructure;
        if (formStructureDto.getId() != null) formStructure.setId(formStructureDto.getId());
        if (formStructureDto.getFieldName() != null)
            formStructure.setFieldName(formStructureDto.getFieldName());
        if (formStructureDto.getFieldNameShown() != null)
            formStructure.setFieldNameShown(formStructureDto.getFieldNameShown());
        if (formStructureDto.getFieldType() != null)
            formStructure.setFieldType(formStructureDto.getFieldType());
        if (formStructureDto.getIsRequired() != null)
            formStructure.setIsRequired(formStructureDto.getIsRequired());
        if (formStructureDto.getValue() != null) formStructure.setValue(formStructureDto.getValue());
        return formStructure;
    }

    public static FormStructureDto toDto(FormStructure formStructure) {
        //TODO: THIS
        return new FormStructureDto().builder().build();
    }
}
