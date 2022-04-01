package uol.compass.shopStyle.catalog.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import uol.compass.shopStyle.catalog.document.Product;
import uol.compass.shopStyle.catalog.dto.ProductDTO;
import uol.compass.shopStyle.catalog.dto.ProductFormDTO;
import uol.compass.shopStyle.catalog.repository.ProductRepository;

import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService{

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ModelMapper mapper;

    @Override
    public ProductDTO save(ProductFormDTO form) {
        Product productEntity = this.productRepository.save(mapper.map(form, Product.class));
        return mapper.map(productEntity, ProductDTO.class);
    }

    @Override
    public Page<ProductDTO> findAll(Pageable page) {
        Page<Product> products = this.productRepository.findAll(page);
        return products.map(ProductDTO::new);
    }

    @Override
    public Optional<Product> findById(String id) {
        Optional<Product> product = productRepository.findById(id);
        return product;
    }

    @Override
    public ProductDTO update(Product product, ProductFormDTO form) {
        if(form.getName() != null)product.setName(form.getName());
        if(form.getDescription() != null)product.setDescription(form.getDescription());
        if(form.getActive() != null)product.setActive(form.getActive());
        if(form.getCategory_ids() != null) {

        };

        this.productRepository.save(product);
        return mapper.map(product, ProductDTO.class);
    }

    @Override
    public void delete(Product product) {
        this.productRepository.delete(product);
    }
}
