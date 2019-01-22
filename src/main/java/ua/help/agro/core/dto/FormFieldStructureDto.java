package ua.help.agro.core.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import ua.help.agro.core.domain.FormFieldStructure;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Slf4j
@Builder
public class FormFieldStructureDto {
    private Long id;
    private String fieldName;
    private String fieldNameShown;
    private String fieldType;
    private Boolean isRequired;
    private String value;

    public static FormFieldStructure fromDto(FormFieldStructureDto formFieldStructureDto, FormFieldStructure formFieldStructure) {
        if (formFieldStructureDto == null) return formFieldStructure;
        if (formFieldStructureDto.getId() != null) formFieldStructure.setId(formFieldStructureDto.getId());
        if (formFieldStructureDto.getFieldName() != null) formFieldStructure.setFieldName(formFieldStructureDto.getFieldName());
        if (formFieldStructureDto.getFieldNameShown() != null) formFieldStructure.setFieldNameShown(formFieldStructureDto.getFieldNameShown());
        if (formFieldStructureDto.getFieldType() != null) formFieldStructure.setFieldType(formFieldStructureDto.getFieldType());
        if (formFieldStructureDto.getIsRequired() != null) formFieldStructure.setIsRequired(formFieldStructureDto.getIsRequired());
        if (formFieldStructureDto.getValue() != null) formFieldStructure.setValue(formFieldStructureDto.getValue());
        return formFieldStructure;
    }

    public static FormFieldStructureDto toDto(FormFieldStructure formFieldStructure) {
        //TODO: THIS
        return new FormFieldStructureDto().builder().build();
    }
}
