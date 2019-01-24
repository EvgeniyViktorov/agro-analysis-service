package ua.help.agro.core.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.help.agro.core.domain.Form;
import ua.help.agro.core.domain.FormStructure;
import ua.help.agro.core.domain.FormValue;
import ua.help.agro.core.dto.FormDto;
import ua.help.agro.core.dto.FormValueDto;
import ua.help.agro.core.dto.ResponseMessage;
import ua.help.agro.core.service.FormService;
import ua.help.agro.core.service.FormStructureService;

import java.util.List;

@RestController
@RequestMapping(value = "/form",
        consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
        produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class FormController {
    private final FormService formService;
    private final FormStructureService formStructureService;

    public FormController(FormService formService, FormStructureService formStructureService) {
        this.formService = formService;
        this.formStructureService = formStructureService;
    }

    @GetMapping("/all")
    public ResponseEntity<?> all() {
        return new ResponseEntity<>(formService.findAll(), HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<?> add(@RequestBody FormDto formDto) {
        return new ResponseEntity<>(formService.saveAndFlush(FormDto.fromDto(formDto, null)), HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<?> update(@RequestBody FormDto formDto) {
        formService.save(FormDto.fromDto(formDto, formService.getFormById(formDto.getId())));
        formService.getFormById(formDto.getId());
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<?> delete(@RequestBody FormDto formDto) {
        formService.delete(formDto.getId());
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/assign")
    public ResponseEntity<?> assign(@RequestBody FormValueDto formValueDto) {
        List<FormStructure> structures;
        Form form = formService.getFormById(formValueDto.getFormId());
        try {
            structures = form.getFormStructures();
        } catch (NullPointerException e) {
            return new ResponseEntity<>(new ResponseMessage("Form with id " + formValueDto.getFormId() + " does not exist in database. Contact admin."), HttpStatus.NOT_FOUND);
        }
        FormValue formValue = FormValueDto.fromDto(formValueDto, null);
        List<FormStructure> assignedStructures = formService.assign(structures, formValue);
        for (FormStructure formStructure : assignedStructures) {
            formStructureService.save(formStructure);
        }
        form.setFormStructures(assignedStructures);
        formService.save(form);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
