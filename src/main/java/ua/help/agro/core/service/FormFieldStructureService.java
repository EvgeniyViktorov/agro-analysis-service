package ua.help.agro.core.service;

import org.springframework.stereotype.Service;
import ua.help.agro.core.repository.FormFieldStructureRepository;

@Service
public class FormFieldStructureService {
    private FormFieldStructureRepository formFieldStructureRepository;

    public FormFieldStructureService(FormFieldStructureRepository formFieldStructureRepository) {
        this.formFieldStructureRepository = formFieldStructureRepository;
    }
}
