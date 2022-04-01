package uol.compass.shopStyle.catalog.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uol.compass.shopStyle.catalog.document.Category;
import uol.compass.shopStyle.catalog.dto.CategoryDTO;
import uol.compass.shopStyle.catalog.dto.CategoryFormDTO;
import uol.compass.shopStyle.catalog.service.CategoryService;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/v1/categories")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private ModelMapper mapper;

    @PostMapping
    public ResponseEntity<CategoryDTO> save(@RequestBody @Valid CategoryFormDTO form) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(categoryService.save(form));
    }

    @GetMapping
    public ResponseEntity<Page<CategoryDTO>> findAll(@PageableDefault Pageable page) {
        return ResponseEntity.ok(categoryService.findAll(page));
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoryDTO> findById(@PathVariable String id) {
        Optional<Category> categoryEntity = categoryService.findById(id);
        if(categoryEntity.isPresent()) return ResponseEntity.ok().body(mapper.map(categoryEntity.get(), CategoryDTO.class));
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<CategoryDTO> update(@PathVariable String id, @RequestBody @Valid CategoryFormDTO form) {
        Optional<Category> categoryEntity = categoryService.findById(id);
        if(categoryEntity.isPresent()) return ResponseEntity.ok().body(categoryService.update(categoryEntity.get(), form));
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<?> delete(@PathVariable String id) {
        Optional<Category> categoryEntity = categoryService.findById(id);
        if(categoryEntity.isPresent()) {
            categoryService.delete(categoryEntity.get());
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}
