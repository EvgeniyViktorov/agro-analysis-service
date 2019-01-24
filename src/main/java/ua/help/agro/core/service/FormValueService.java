package ua.help.agro.core.service;

import org.springframework.stereotype.Service;
import ua.help.agro.core.domain.FormValue;
import ua.help.agro.core.repository.FormValueRepository;

@Service
public class FormValueService {
    private FormValueRepository formValueRepository;

    public FormValueService(FormValueRepository formValueRepository) {
        this.formValueRepository = formValueRepository;
    }

    public void save(FormValue formValue) {
        formValueRepository.save(formValue);
    }

    public FormValue getFormFieldValueById(Long id) {
        if (formValueRepository.findById(id).isPresent()) return formValueRepository.findById(id).get();
        return null;
    }

    public void delete(Long id) {
        formValueRepository.deleteById(id);
    }
}
