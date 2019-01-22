package ua.help.agro.core.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import ua.help.agro.core.domain.Field;
import ua.help.agro.core.domain.Form;
import ua.help.agro.core.domain.FormFieldStructure;
import ua.help.agro.core.domain.FormFieldValue;
import ua.help.agro.core.domain.PlantType;
import ua.help.agro.core.domain.User;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Slf4j
@Builder
public class FormDto {
    private Long id;
    private String formName;
    private PlantType plantType;
    private Field field;
    private LocalDate dueDate;
    private LocalDate dateUpdated;
    private String note;
    private Boolean isAccepted;
    private Boolean isCompleted;
    private FormFieldValue formFieldValues;
    private List<FormFieldStructure> formFieldStructures;
    private User submittedBy;

    public static Form fromDto(FormDto formDto, Form form) {
        if (formDto == null) return form;
        if (form == null) form = new Form();
        if (formDto.getId() != null) form.setId(formDto.getId());
        if (formDto.getFormName() != null) form.setFormName(formDto.getFormName());
        if (formDto.getPlantType() != null) form.setPlantType(formDto.getPlantType());
        if (formDto.getField() != null) form.setField(formDto.getField());
        if (formDto.getDueDate() != null) form.setDueDate(formDto.getDueDate());
        if (formDto.getDateUpdated() != null) form.setDateUpdated(formDto.getDateUpdated());
        if (formDto.getNote() != null) form.setNote(formDto.getNote());
        if (formDto.getIsAccepted() != null) form.setIsAccepted(formDto.getIsAccepted());
        if (formDto.getIsCompleted() != null) form.setIsCompleted(formDto.getIsCompleted());
        if (formDto.getFormFieldValues() != null) form.setFormFieldValues(formDto.getFormFieldValues());
        if (formDto.getFormFieldStructures() != null) form.setFormFieldStructures(formDto.getFormFieldStructures());
        if (formDto.getSubmittedBy() != null) form.setSubmittedBy(formDto.getSubmittedBy());
        return form;
    }
}
