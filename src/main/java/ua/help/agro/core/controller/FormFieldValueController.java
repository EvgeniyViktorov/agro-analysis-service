package ua.help.agro.core.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.help.agro.core.dto.FormFieldValueDto;
import ua.help.agro.core.service.FormFieldValueService;

@RestController
@RequestMapping(value = "/form/value",
        consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
        produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class FormFieldValueController {

    private final FormFieldValueService formFieldValueService;

    public FormFieldValueController(FormFieldValueService formFieldValueService) {
        this.formFieldValueService = formFieldValueService;
    }

    @PostMapping("/add")
    public ResponseEntity<?> addValue(@RequestBody FormFieldValueDto formFieldValueDto) {
        formFieldValueService.save(FormFieldValueDto.fromDto(formFieldValueDto, null));
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<?> updateValue(@RequestBody FormFieldValueDto formFieldValueDto) {
        formFieldValueService.save(FormFieldValueDto.fromDto(formFieldValueDto, formFieldValueService.getFormFieldValueById(formFieldValueDto.getId())));

        return new ResponseEntity<>(formFieldValueService.getFormFieldValueById(formFieldValueDto.getId()), HttpStatus.OK);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<?> deleteValue(@RequestBody FormFieldValueDto formFieldValueDto) {
        formFieldValueService.delete(formFieldValueDto.getId());
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
