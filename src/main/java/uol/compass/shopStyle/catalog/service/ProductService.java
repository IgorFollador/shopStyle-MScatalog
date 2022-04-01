package uol.compass.shopStyle.catalog.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import uol.compass.shopStyle.catalog.document.Product;
import uol.compass.shopStyle.catalog.dto.ProductDTO;
import uol.compass.shopStyle.catalog.dto.ProductFormDTO;

import java.util.Optional;

public interface ProductService {
    ProductDTO save(ProductFormDTO body);

    Page<ProductDTO> findAll(Pageable page);

    Optional<Product> findById(String id);

    ProductDTO update(Product product, ProductFormDTO form);

    void delete(Product product);
}
