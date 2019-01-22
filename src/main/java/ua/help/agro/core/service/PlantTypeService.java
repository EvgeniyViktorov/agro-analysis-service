package ua.help.agro.core.service;

import org.springframework.stereotype.Service;
import ua.help.agro.core.domain.PlantType;
import ua.help.agro.core.repository.PlantTypeRepository;

@Service
public class PlantTypeService {
    private PlantTypeRepository plantTypeRepository;

    public PlantTypeService(PlantTypeRepository plantTypeRepository) {
        this.plantTypeRepository = plantTypeRepository;
    }

    public void save(PlantType plantType) {
        plantTypeRepository.save(plantType);
    }
}
