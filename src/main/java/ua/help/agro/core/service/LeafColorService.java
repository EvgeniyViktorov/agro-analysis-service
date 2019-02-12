package ua.help.agro.core.service;

import org.springframework.stereotype.Service;
import ua.help.agro.core.domain.LeafColor;
import ua.help.agro.core.repository.LeafColorRepository;

import java.util.List;

@Service
public class LeafColorService {
    private LeafColorRepository leafColorRepository;

    public LeafColorService(LeafColorRepository leafColorRepository) {
        this.leafColorRepository = leafColorRepository;
    }

    public void save(LeafColor leafColor) {
        leafColorRepository.save(leafColor);
    }

    public List<LeafColor> findAll() {
        return leafColorRepository.findAll();
    }

    public LeafColor getLeafColorById(Long id) {
        return leafColorRepository.getOne(id);
    }

    public void delete(Long id) {
        leafColorRepository.deleteById(id);
    }
}
