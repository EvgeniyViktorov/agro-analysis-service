package ua.help.agro.core.service;

import org.springframework.stereotype.Service;
import ua.help.agro.core.domain.PlantType;
import ua.help.agro.core.repository.PlantTypeRepository;

import java.util.List;

@Service
public class PlantTypeService {
    private PlantTypeRepository plantTypeRepository;

    public PlantTypeService(PlantTypeRepository plantTypeRepository) {
        this.plantTypeRepository = plantTypeRepository;
    }

    public void save(PlantType plantType) {
        plantTypeRepository.save(plantType);
    }

    public List<PlantType> findAll() {
        return plantTypeRepository.findAll();
    }

    public PlantType getPlantTypeById(Long id) {
        return plantTypeRepository.getOne(id);
    }

    public void delete(Long id) {
        plantTypeRepository.deleteById(id);
    }
}
