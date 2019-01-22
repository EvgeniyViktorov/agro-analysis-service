package ua.help.agro.core.service;

import org.springframework.stereotype.Service;
import ua.help.agro.core.domain.Form;
import ua.help.agro.core.repository.FormRepository;

import java.util.List;

@Service
public class FormService {
    private final FormRepository formRepository;

    public FormService(FormRepository formRepository) {
        this.formRepository = formRepository;
    }

    public void save(Form form) {
        formRepository.save(form);
    }

    public List<Form> findAll() {
        return formRepository.findAll();
    }

    public Form getFormById(Long id) {
        if (formRepository.findById(id).isPresent()) return formRepository.findById(id).get();
        return null;
    }

    public void delete(Long id) {
        formRepository.deleteById(id);
    }
}