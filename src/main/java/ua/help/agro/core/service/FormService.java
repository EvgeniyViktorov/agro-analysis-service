package ua.help.agro.core.service;

import org.springframework.stereotype.Service;
import ua.help.agro.core.domain.Form;
import ua.help.agro.core.domain.FormStructure;
import ua.help.agro.core.domain.FormValue;
import ua.help.agro.core.repository.FormRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class FormService {
    private final FormRepository formRepository;
    private final LeafColorService leafColorService;
    private final PlantTypeService plantTypeService;

    public FormService(FormRepository formRepository, LeafColorService leafColorService, PlantTypeService plantTypeService) {
        this.formRepository = formRepository;
        this.leafColorService = leafColorService;
        this.plantTypeService = plantTypeService;
    }

    public void save(Form form) {
        formRepository.save(form);
    }

    public Form saveAndFlush(Form form) {
        return formRepository.saveAndFlush(form);
    }

    public List<Form> findAll() {
        return formRepository.findAll();
    }

    public Form getFormById(Long id) {
        return formRepository.getOne(id);
    }

    public void delete(Long id) {
        formRepository.deleteById(id);
    }

    public List<FormStructure> assign(List<FormStructure> formStructures, FormValue formValue) {
        if (formValue.getPlantType() != null) {
            formStructures.forEach(e -> {
                if (e.getFieldName().equals("plantType")) e.setValue(formValue.getPlantType().getId().toString());
            });
        }
        if (formValue.getStemLength() != null && !formValue.getStemLength().equals("")) {
            formStructures.forEach(e -> {
                if (e.getFieldName().equals("stemLength")) e.setValue(formValue.getStemLength());
            });
        }
        if (formValue.getStemThickness() != null && !formValue.getStemThickness().equals("")) {
            formStructures.forEach(e -> {
                if (e.getFieldName().equals("stemThickness")) e.setValue(formValue.getStemThickness());
            });
        }
        if (formValue.getBranchesAmount() != null && formValue.getBranchesAmount() != 0) {
            formStructures.forEach(e -> {
                if (e.getFieldName().equals("branchesAmount")) e.setValue(formValue.getBranchesAmount().toString());
            });
        }
        if (formValue.getLeafLength() != null && !formValue.getLeafLength().equals("")) {
            formStructures.forEach(e -> {
                if (e.getFieldName().equals("leafLength")) e.setValue(formValue.getLeafLength());
            });
        }
        if (formValue.getLeafWidth() != null && !formValue.getLeafWidth().equals("")) {
            formStructures.forEach(e -> {
                if (e.getFieldName().equals("leafWidth")) e.setValue(formValue.getLeafWidth());
            });
        }
        if (formValue.getLeafColor() != null) {
            formStructures.forEach(e -> {
                if (e.getFieldName().equals("leafColor")) e.setValue(formValue.getLeafColor().getId().toString());
            });
        }
        if (formValue.getFruitsAmount() != null && formValue.getFruitsAmount() != 0) {
            formStructures.forEach(e -> {
                if (e.getFieldName().equals("fruitsAmount")) e.setValue(formValue.getFruitsAmount().toString());
            });
        }
        if (formValue.getFruitLength() != null && !formValue.getFruitLength().equals("")) {
            formStructures.forEach(e -> {
                if (e.getFieldName().equals("fruitLength")) e.setValue(formValue.getFruitLength());
            });
        }
        if (formValue.getSweetness() != null && formValue.getSweetness() != 0) {
            formStructures.forEach(e -> {
                if (e.getFieldName().equals("sweetness")) e.setValue(formValue.getSweetness().toString());
            });
        }
        if (formValue.getNote() != null && !formValue.getNote().equals("")) {
            formStructures.forEach(e -> {
                if (e.getFieldName().equals("note")) e.setValue(formValue.getNote());
            });
        }
        return formStructures;
    }

    public Map<Object, Object> getFormValuesMap(Long id) {
        Form form = getFormById(id);
        List<FormStructure> formStructures = form.getFormStructures();
        Map<Object, Object> structuresAndAnswers = new HashMap<>();
        formStructures.forEach(formStructure -> {
            if (formStructure.getFieldName().equals("leafColor")) {
                structuresAndAnswers.put(formStructure.getFieldName(), leafColorService.getLeafColorById(Long.parseLong(formStructure.getValue())));
            } else if (formStructure.getFieldName().equals("plantType")) {
                structuresAndAnswers.put(formStructure.getFieldName(), plantTypeService.getPlantTypeById(Long.parseLong(formStructure.getValue())));
            } else {
                structuresAndAnswers.put(formStructure.getFieldName(), formStructure.getValue());
            }
        });
        return structuresAndAnswers;
    }
}
