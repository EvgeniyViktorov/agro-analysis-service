package ua.help.agro.core.service;

import org.springframework.stereotype.Service;
import ua.help.agro.core.domain.Field;
import ua.help.agro.core.domain.Form;
import ua.help.agro.core.domain.FormStructure;
import ua.help.agro.core.domain.User;
import ua.help.agro.core.repository.FieldRepository;
import ua.help.agro.core.repository.FormStructureRepository;
import ua.help.agro.core.repository.UserRepository;

import java.time.LocalDate;
import java.util.List;

@Service
public class FormStructureService {
    private FormStructureRepository formStructureRepository;
    private UserRepository userRepository;
    private FieldRepository fieldRepository;


    public FormStructureService(FormStructureRepository formStructureRepository, UserRepository userRepository, FieldRepository fieldRepository) {
        this.formStructureRepository = formStructureRepository;
        this.userRepository = userRepository;
        this.fieldRepository = fieldRepository;
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

    public void saveAndCreate(List<FormStructure> formStructures) {
        formStructures.forEach(e -> formStructureRepository.save(e));
        User evgeniyViktorov = userRepository.getUsersByEmailContaining("evgeniy.viktorov.y@gmail.com");
        Form newForm = Form
                .builder()
                .formName("Присланая админом форма от " + LocalDate.now().toString())
                .formStructures(formStructures)
                .dateUpdated(LocalDate.now())
                .dueDate(LocalDate.now().plusDays(7))
                .isAccepted(true)
                .isCompleted(false)
                .submittedBy(evgeniyViktorov)
                .build();
        Field weedField = fieldRepository.getOne(8L);
        List<Form> forms = weedField.getForms();
        forms.add(newForm);
        forms.forEach(e -> e.setField(weedField));
        weedField.setForms(forms);
        fieldRepository.save(weedField);
    }
}
