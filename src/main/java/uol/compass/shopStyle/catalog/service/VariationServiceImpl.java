package uol.compass.shopStyle.catalog.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import uol.compass.shopStyle.catalog.document.Variation;
import uol.compass.shopStyle.catalog.dto.VariationDTO;
import uol.compass.shopStyle.catalog.dto.VariationFormDTO;
import uol.compass.shopStyle.catalog.repository.VariationRepository;

import java.util.Optional;

@Service
public class VariationServiceImpl implements VariationService{

    @Autowired
    private VariationRepository variationRepository;

    @Autowired
    private ModelMapper mapper;

    @Override
    public VariationDTO save(VariationFormDTO form) {
        Variation variationEntity = this.variationRepository.save(mapper.map(form, Variation.class));
        return mapper.map(variationEntity, VariationDTO.class);
    }

    @Override
    public Page<VariationDTO> findAll(Pageable page) {
        Page<Variation> variation = this.variationRepository.findAll(page);
        return variation.map(VariationDTO::new);
    }

    @Override
    public Optional<Variation> findById(String id) {
        Optional<Variation> variation = variationRepository.findById(id);
        return variation;
    }

    @Override
    public VariationDTO update(Variation variation, VariationFormDTO form) {
        if(form.getColor() != null)variation.setColor(form.getColor());
        if(form.getSize() != null)variation.setSize(form.getSize());
        if(form.getPrice() != null)variation.setPrice(form.getPrice());
        if(form.getQuantity() != null)variation.setQuantity(form.getQuantity());
        if(form.getProduct_id() != null) {

        }

        this.variationRepository.save(variation);
        return mapper.map(variation, VariationDTO.class);
    }

    @Override
    public void delete(Variation variation) {
        this.variationRepository.delete(variation);
    }
}
