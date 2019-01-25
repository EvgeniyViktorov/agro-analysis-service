package ua.help.agro.core.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.help.agro.core.service.FormService;
import ua.help.agro.core.service.FormStructureService;

@Slf4j
@RestController
@RequestMapping(value = "/form/value",
        consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
        produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class FormValueController {

    private final FormStructureService formStructureService;
    private final FormService formService;

    public FormValueController(FormStructureService formStructureService, FormService formService) {
        this.formStructureService = formStructureService;
        this.formService = formService;
    }


//
//    @PutMapping("/update")
//    public ResponseEntity<?> updateValue(@RequestBody FormValueDto formValueDto) {
//        formValueService.save(FormValueDto.fromDto(formValueDto, formValueService.getFormFieldValueById(formValueDto.getId())));
//
//        return new ResponseEntity<>(formValueService.getFormFieldValueById(formValueDto.getId()), HttpStatus.OK);
//    }
//
//    @DeleteMapping("/delete")
//    public ResponseEntity<?> deleteValue(@RequestBody FormValueDto formValueDto) {
//        formValueService.delete(formValueDto.getId());
//        return new ResponseEntity<>(HttpStatus.OK);
//    }
}
