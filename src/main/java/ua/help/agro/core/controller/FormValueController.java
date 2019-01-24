package ua.help.agro.core.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.help.agro.core.domain.Form;
import ua.help.agro.core.domain.FormStructure;
import ua.help.agro.core.domain.FormValue;
import ua.help.agro.core.dto.FormValueDto;
import ua.help.agro.core.dto.ResponseMessage;
import ua.help.agro.core.service.FormService;
import ua.help.agro.core.service.FormStructureService;
import ua.help.agro.core.service.FormValueService;

import java.util.List;

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
