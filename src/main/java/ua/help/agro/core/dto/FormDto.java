package ua.help.agro.core.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import ua.help.agro.core.domain.Field;
import ua.help.agro.core.domain.Form;
import ua.help.agro.core.domain.FormStructure;
import ua.help.agro.core.domain.FormValue;
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
    private Field field;
    private LocalDate dueDate;
    private LocalDate dateUpdated;
    private Boolean isAccepted;
    private Boolean isCompleted;
    private FormValue formValues;
    private List<FormStructure> formStructures;
    private User submittedBy;

    public static Form fromDto(FormDto formDto, Form form) {
        if (formDto == null) return form;
        if (form == null) form = new Form();
        if (formDto.getId() != null) form.setId(formDto.getId());
        if (formDto.getFormName() != null) form.setFormName(formDto.getFormName());
        if (formDto.getField() != null) form.setField(formDto.getField());
        if (formDto.getDueDate() != null) form.setDueDate(formDto.getDueDate());
        if (formDto.getDateUpdated() != null) form.setDateUpdated(formDto.getDateUpdated());
        if (formDto.getIsAccepted() != null) form.setIsAccepted(formDto.getIsAccepted());
        if (formDto.getIsCompleted() != null) form.setIsCompleted(formDto.getIsCompleted());
        if (formDto.getFormValues() != null) form.setFormValues(formDto.getFormValues());
        if (formDto.getFormStructures() != null) form.setFormStructures(formDto.getFormStructures());
        if (formDto.getSubmittedBy() != null) form.setSubmittedBy(formDto.getSubmittedBy());
        return form;
    }

    public static FormDto toDtoNoData(Form form) {
        return FormDto.builder()
                .id(form.getId())
                .formName(form.getFormName())
                .field(form.getField())
                .dueDate(form.getDueDate())
                .dateUpdated(form.getDateUpdated())
                .isAccepted(form.getIsAccepted())
                .isCompleted(form.getIsCompleted())
                .formStructures(form.getFormStructures())
                .submittedBy(form.getSubmittedBy())
                .build();
    }
}
