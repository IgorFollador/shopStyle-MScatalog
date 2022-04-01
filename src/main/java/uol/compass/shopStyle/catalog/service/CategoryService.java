package uol.compass.shopStyle.catalog.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import uol.compass.shopStyle.catalog.document.Category;
import uol.compass.shopStyle.catalog.document.Product;
import uol.compass.shopStyle.catalog.dto.CategoryDTO;
import uol.compass.shopStyle.catalog.dto.CategoryFormDTO;
import uol.compass.shopStyle.catalog.dto.ProductDTO;
import uol.compass.shopStyle.catalog.dto.ProductFormDTO;

import java.util.Optional;

public interface CategoryService {
    CategoryDTO save(CategoryFormDTO body);

    Page<CategoryDTO> findAll(Pageable page);

    Optional<Category> findById(String id);

    CategoryDTO update(Category category, CategoryFormDTO form);

    void delete(Category category);
}
