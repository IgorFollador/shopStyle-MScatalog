package uol.compass.shopStyle.catalog.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import uol.compass.shopStyle.catalog.document.Variation;
import uol.compass.shopStyle.catalog.dto.VariationDTO;
import uol.compass.shopStyle.catalog.dto.VariationFormDTO;

import java.util.Optional;

public interface VariationService {
    VariationDTO save(VariationFormDTO body);

    Page<VariationDTO> findAll(Pageable page);

    Optional<Variation> findById(String id);

    VariationDTO update(Variation category, VariationFormDTO form);

    void delete(Variation category);
}
