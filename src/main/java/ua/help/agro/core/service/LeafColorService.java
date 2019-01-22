package ua.help.agro.core.service;

import org.springframework.stereotype.Service;
import ua.help.agro.core.domain.LeafColor;
import ua.help.agro.core.repository.LeafColorRepository;

@Service
public class LeafColorService {
    private LeafColorRepository leafColorRepository;

    public LeafColorService(LeafColorRepository leafColorRepository) {
        this.leafColorRepository = leafColorRepository;
    }

    public void save(LeafColor leafColor) {
        leafColorRepository.save(leafColor);
    }
}