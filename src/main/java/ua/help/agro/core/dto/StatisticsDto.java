package ua.help.agro.core.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Tolerate;
import lombok.extern.slf4j.Slf4j;
import ua.help.agro.core.domain.Field;
import ua.help.agro.core.domain.Form;
import ua.help.agro.core.service.FormService;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Getter
@Setter
@Slf4j
@Builder
public class StatisticsDto {

    @JsonIgnore
    private final FormService formService;
    @JsonIgnore
    private Long fieldId;
    private LocalDate dateUpdated;
    private Map<Object, Object> formValues;

    @Tolerate
    public StatisticsDto(FormService formService) {
        this.formService = formService;
    }

    public List<StatisticsDto> toDto(Field field) {
        List<StatisticsDto> stats = new ArrayList<>();
        List<Form> forms = field.getForms();
        forms.forEach(form -> stats.add(StatisticsDto
                .builder()
                .fieldId(field.getId())
                .dateUpdated(form.getDateUpdated())
                .formValues(formService.getFormValuesMap(form.getId()))
                .build()));
        return stats;
    }
}
