package ua.help.agro.core.service;

import org.springframework.stereotype.Service;
import ua.help.agro.core.domain.Field;
import ua.help.agro.core.repository.FieldRepository;

import java.util.List;

@Service
public class FieldService {
    private final FieldRepository fieldRepository;

    public FieldService(FieldRepository fieldRepository) {
        this.fieldRepository = fieldRepository;
    }

    public List<Field> findAll() {
        return fieldRepository.findAll();
    }

    public void save(Field field) {
        fieldRepository.save(field);
    }

    public Field getFieldById(Long id) {
        if (fieldRepository.findById(id).isPresent()) return fieldRepository.findById(id).get();
        return null;
    }

    public void delete(Long id) {
        fieldRepository.deleteById(id);
    }
}
