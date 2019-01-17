package ua.help.agro.core.service;

import org.springframework.stereotype.Service;
import ua.help.agro.core.domain.FormFieldValue;
import ua.help.agro.core.repository.FormFieldValueRepository;

@Service
public class FormFieldValueService {
    private FormFieldValueRepository formFieldValueRepository;

    public FormFieldValueService(FormFieldValueRepository formFieldValueRepository) {
        this.formFieldValueRepository = formFieldValueRepository;
    }

    public void save(FormFieldValue formFieldValue) {
        formFieldValueRepository.save(formFieldValue);
    }
}
