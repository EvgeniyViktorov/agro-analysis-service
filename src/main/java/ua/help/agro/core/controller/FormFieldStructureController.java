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
import ua.help.agro.core.dto.FormFieldStructureDto;
import ua.help.agro.core.service.FormFieldStructureService;

@RestController
@RequestMapping(value = "/form/structure",
        consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
        produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class FormFieldStructureController {

    private final FormFieldStructureService formFieldStructureService;

    public FormFieldStructureController(FormFieldStructureService formFieldStructureService) {
        this.formFieldStructureService = formFieldStructureService;
    }

    @PostMapping("/add")
    public ResponseEntity<?> addValue(@RequestBody FormFieldStructureDto formFieldStructureDto) {
        formFieldStructureService.save(FormFieldStructureDto.fromDto(formFieldStructureDto, null));
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<?> updateValue(@RequestBody FormFieldStructureDto formFieldStructureDto) {
        formFieldStructureService.save(FormFieldStructureDto.fromDto(formFieldStructureDto, formFieldStructureService.getFormFieldStructureById(formFieldStructureDto.getId())));
        return new ResponseEntity<>(formFieldStructureService.getFormFieldStructureById(formFieldStructureDto.getId()), HttpStatus.OK);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<?> deleteValue(@RequestBody FormFieldStructureDto formFieldStructureDto) {
        formFieldStructureService.delete(formFieldStructureDto.getId());
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
