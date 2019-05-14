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
import ua.help.agro.core.domain.FormStructure;
import ua.help.agro.core.dto.FormStructureDto;
import ua.help.agro.core.service.FormStructureService;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/form/structure",
        consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
        produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class FormStructureController {

    private final FormStructureService formStructureService;

    public FormStructureController(FormStructureService formStructureService) {
        this.formStructureService = formStructureService;
    }

    @PostMapping("/add")
    public ResponseEntity<?> addStructure(@RequestBody List<FormStructureDto> formStructureDto) {
        List<FormStructure> formStructures = new ArrayList<>();
        formStructureDto.forEach(e -> formStructures.add(FormStructureDto.fromDto(e, null)));
        formStructureService.saveAndCreate(formStructures);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/add/all")
    public ResponseEntity<?> addAllStructures(@RequestBody FormStructureDto formStructureDto) {
        formStructureService.save(FormStructureDto.fromDto(formStructureDto, null));
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<?> updateStructure(@RequestBody FormStructureDto formStructureDto) {
        formStructureService.save(FormStructureDto.fromDto(formStructureDto, formStructureService.getFormFieldStructureById(formStructureDto.getId())));
        return new ResponseEntity<>(formStructureService.getFormFieldStructureById(formStructureDto.getId()), HttpStatus.OK);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<?> deleteStructure(@RequestBody FormStructureDto formStructureDto) {
        formStructureService.delete(formStructureDto.getId());
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
