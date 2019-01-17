package ua.help.agro.core.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.help.agro.core.domain.FormFieldValue;
import ua.help.agro.core.service.FormFieldValueService;

@RestController
@RequestMapping(value = "/form/values",
        consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
        produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class FormFieldValueController {

    private final FormFieldValueService formFieldValueService;

    public FormFieldValueController(FormFieldValueService formFieldValueService) {
        this.formFieldValueService = formFieldValueService;
    }

    @PostMapping("/add")
    public ResponseEntity<?> addValue(FormFieldValue formFieldValue) {
        formFieldValueService.save(formFieldValue);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<?> updateValue(FormFieldValue formFieldValue) {
        formFieldValueService.save(formFieldValue);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
