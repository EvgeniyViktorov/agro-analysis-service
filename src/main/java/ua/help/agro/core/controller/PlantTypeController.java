package ua.help.agro.core.controller;

import lombok.extern.slf4j.Slf4j;
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
import ua.help.agro.core.dto.PlantTypeDto;
import ua.help.agro.core.service.PlantTypeService;

@Slf4j
@RestController
@RequestMapping(value = "/plant",
        consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
        produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class PlantTypeController {
    
    private final PlantTypeService plantTypeService;

    public PlantTypeController(PlantTypeService plantTypeService) {
        this.plantTypeService = plantTypeService;
    }

    @GetMapping("/all")
    public ResponseEntity<?> all() {
        return new ResponseEntity<>(plantTypeService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable String id) {
        return new ResponseEntity<>(plantTypeService.getPlantTypeById(Long.parseLong(id)), HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<?> add(@RequestBody PlantTypeDto plantType) {
        plantTypeService.save(PlantTypeDto.fromDto(plantType, null));
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<?> update(@RequestBody PlantTypeDto plantType) {
        plantTypeService.save(PlantTypeDto.fromDto(plantType, plantTypeService.getPlantTypeById(plantType.getId())));
        plantTypeService.getPlantTypeById(plantType.getId());
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<?> delete(@RequestBody PlantTypeDto plantType) {
        plantTypeService.delete(plantType.getId());
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
