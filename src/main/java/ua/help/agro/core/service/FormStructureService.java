package ua.help.agro.core.service;

import org.springframework.stereotype.Service;
import ua.help.agro.core.domain.FormStructure;
import ua.help.agro.core.repository.FormStructureRepository;

import java.util.List;

@Service
public class FormStructureService {
    private FormStructureRepository formStructureRepository;

    public FormStructureService(FormStructureRepository formStructureRepository) {
        this.formStructureRepository = formStructureRepository;
    }

    public void save(FormStructure formStructure) {
        formStructureRepository.save(formStructure);
    }

    public FormStructure getFormFieldStructureById(Long id) {
        if (formStructureRepository.findById(id).isPresent())
            return formStructureRepository.findById(id).get();
        return null;
    }

    public void delete(Long id) {
        formStructureRepository.deleteById(id);
    }

    public List<FormStructure> findAll() {
        return formStructureRepository.findAll();
    }

}
