package uol.compass.shopStyle.catalog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uol.compass.shopStyle.catalog.document.Product;
import uol.compass.shopStyle.catalog.dto.ProductDTO;
import uol.compass.shopStyle.catalog.dto.ProductFormDTO;
import uol.compass.shopStyle.catalog.service.ProductService;

import javax.validation.Valid;

@RestController
@RequestMapping("/v1/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping
    public ResponseEntity<ProductDTO> save(@RequestBody @Valid ProductFormDTO form) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(productService.save(form));
    }

}
