package uol.compass.shopStyle.catalog.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uol.compass.shopStyle.catalog.document.Product;
import uol.compass.shopStyle.catalog.dto.ProductDTO;
import uol.compass.shopStyle.catalog.dto.ProductFormDTO;
import uol.compass.shopStyle.catalog.service.ProductService;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/v1/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private ModelMapper mapper;

    @PostMapping
    public ResponseEntity<ProductDTO> save(@RequestBody @Valid ProductFormDTO form) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(productService.save(form));
    }

    @GetMapping
    public ResponseEntity<Page<ProductDTO>> findAll(@PageableDefault Pageable page) {
        return ResponseEntity.ok(productService.findAll(page));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductDTO> findById(@PathVariable String id) {
        Optional<Product> productEntity = productService.findById(id);
        if(productEntity.isPresent()) return ResponseEntity.ok().body(mapper.map(productEntity.get(), ProductDTO.class));
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<ProductDTO> update(@PathVariable String id, @RequestBody @Valid ProductFormDTO form) {
        Optional<Product> productEntity = productService.findById(id);
        if(productEntity.isPresent()) return ResponseEntity.ok().body(productService.update(productEntity.get(), form));
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<?> delete(@PathVariable String id) {
        Optional<Product> productEntity = productService.findById(id);
        if(productEntity.isPresent()) {
            productService.delete(productEntity.get());
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}
