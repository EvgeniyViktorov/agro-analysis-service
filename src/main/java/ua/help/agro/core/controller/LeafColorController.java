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
import ua.help.agro.core.dto.LeafColorDto;
import ua.help.agro.core.service.LeafColorService;

@Slf4j
@RestController
@RequestMapping(value = "/color",
        consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
        produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class LeafColorController {
    private final LeafColorService leafColorService;

    public LeafColorController(LeafColorService leafColorService) {
        this.leafColorService = leafColorService;
    }

    @GetMapping("/all")
    public ResponseEntity<?> all() {
        return new ResponseEntity<>(leafColorService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable String id) {
        return new ResponseEntity<>(leafColorService.getLeafColorById(Long.parseLong(id)), HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<?> add(@RequestBody LeafColorDto leafColor) {
        leafColorService.save(LeafColorDto.fromDto(leafColor, null));
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<?> update(@RequestBody LeafColorDto leafColor) {
        leafColorService.save(LeafColorDto.fromDto(leafColor, leafColorService.getLeafColorById(leafColor.getId())));
        leafColorService.getLeafColorById(leafColor.getId());
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<?> delete(@RequestBody LeafColorDto leafColor) {
        leafColorService.delete(leafColor.getId());
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
