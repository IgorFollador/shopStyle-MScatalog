package uol.compass.shopStyle.catalog.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uol.compass.shopStyle.catalog.document.Variation;
import uol.compass.shopStyle.catalog.dto.VariationDTO;
import uol.compass.shopStyle.catalog.dto.VariationFormDTO;
import uol.compass.shopStyle.catalog.service.VariationService;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/v1/variations")
public class VariationController {

    @Autowired
    private VariationService variationService;

    @Autowired
    private ModelMapper mapper;

    @PostMapping
    public ResponseEntity<VariationDTO> save(@RequestBody @Valid VariationFormDTO form) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(variationService.save(form));
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<VariationDTO> update(@PathVariable String id, @RequestBody @Valid VariationFormDTO form) {
        Optional<Variation> variationEntity = variationService.findById(id);
        if(variationEntity.isPresent()) return ResponseEntity.ok().body(variationService.update(variationEntity.get(), form));
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<?> delete(@PathVariable String id) {
        Optional<Variation> variationEntity = variationService.findById(id);
        if(variationEntity.isPresent()) {
            variationService.delete(variationEntity.get());
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}
