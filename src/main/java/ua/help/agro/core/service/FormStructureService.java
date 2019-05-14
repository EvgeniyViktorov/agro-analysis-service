package ua.help.agro.core.service;

import org.springframework.stereotype.Service;
import ua.help.agro.core.domain.Field;
import ua.help.agro.core.domain.Form;
import ua.help.agro.core.domain.FormStructure;
import ua.help.agro.core.domain.User;
import ua.help.agro.core.repository.FormStructureRepository;

import java.time.LocalDate;
import java.util.List;

@Service
public class FormStructureService {
    private FormStructureRepository formStructureRepository;
    private UserService userService;
    private FieldService fieldService;


    public FormStructureService(FormStructureRepository formStructureRepository, UserService userService, FieldService fieldService) {
        this.formStructureRepository = formStructureRepository;
        this.userService = userService;
        this.fieldService = fieldService;
    }

    public void save(List<FormStructure> formStructure) {
        formStructure.forEach(e -> formStructureRepository.save(e));
        User evgeniyViktorov = userService.getUserById(2L);
        Form newForm = Form
                .builder()
                .formName("ФПрисланая админом форма от " + LocalDate.now().toString())
                .formStructures(formStructure)
                .dateUpdated(LocalDate.now())
                .dueDate(LocalDate.now().plusDays(7))
                .isAccepted(true)
                .isCompleted(false)
                .submittedBy(evgeniyViktorov)
                .build();
        Field weedField = fieldService.getFieldById(8L);
        List<Form> forms = weedField.getForms();
        forms.add(newForm);
        weedField.setForms(forms);
        fieldService.save(weedField);
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
