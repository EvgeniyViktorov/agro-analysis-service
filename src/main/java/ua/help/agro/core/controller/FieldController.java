package ua.help.agro.core.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.help.agro.core.domain.Field;
import ua.help.agro.core.dto.FieldDto;
import ua.help.agro.core.dto.StatisticsDto;
import ua.help.agro.core.service.FieldService;
import ua.help.agro.core.service.FormService;

@RestController
@RequestMapping(value = "/field",
        consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
        produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class FieldController {

    private final FieldService fieldService;
    private final FormService formService;

    public FieldController(FieldService fieldService, FormService formService) {
        this.fieldService = fieldService;
        this.formService = formService;
    }

    @GetMapping("/all")
    public ResponseEntity<?> findAll() {
        return new ResponseEntity<>(fieldService.findAll(), HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<?> add(@RequestBody FieldDto fieldDto) {
        fieldService.save(FieldDto.fromDto(fieldDto, null));
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<?> update(@RequestBody FieldDto fieldDto) {
        fieldService.save(FieldDto.fromDto(fieldDto, fieldService.getFieldById(fieldDto.getId())));
        fieldService.getFieldById(fieldDto.getId());
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<?> delete(@RequestBody FieldDto fieldDto) {
        fieldService.delete(fieldDto.getId());
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/{id}/stats")
    public ResponseEntity<?> getFieldStats(@PathVariable String id) {
        Field field = fieldService.getFieldById(Long.parseLong(id));
        return new ResponseEntity<>(new StatisticsDto(formService).toDto(field), HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> getField(@PathVariable String id) {
        return new ResponseEntity<>(fieldService.getFieldById(Long.parseLong(id)), HttpStatus.OK);
    }
}
