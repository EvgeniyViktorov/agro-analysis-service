package ua.help.agro.core.service;

import org.springframework.stereotype.Service;
import ua.help.agro.core.domain.FormFieldStructure;
import ua.help.agro.core.repository.FormFieldStructureRepository;

import java.util.List;

@Service
public class FormFieldStructureService {
    private FormFieldStructureRepository formFieldStructureRepository;

    public FormFieldStructureService(FormFieldStructureRepository formFieldStructureRepository) {
        this.formFieldStructureRepository = formFieldStructureRepository;
    }

    public void save(FormFieldStructure formFieldStructure) {
        formFieldStructureRepository.save(formFieldStructure);
    }

    public FormFieldStructure getFormFieldStructureById(Long id) {
        if (formFieldStructureRepository.findById(id).isPresent())
            return formFieldStructureRepository.findById(id).get();
        return null;
    }

    public void delete(Long id) {
        formFieldStructureRepository.deleteById(id);
    }

    public List<FormFieldStructure> findAll() {
        return formFieldStructureRepository.findAll();
    }
}
