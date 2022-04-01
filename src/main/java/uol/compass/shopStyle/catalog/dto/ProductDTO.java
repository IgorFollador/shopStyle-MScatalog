package uol.compass.shopStyle.catalog.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import uol.compass.shopStyle.catalog.document.Category;
import uol.compass.shopStyle.catalog.document.Product;

import java.util.List;

@Data
@NoArgsConstructor
public class ProductDTO {

    private String id;

    private String name;

    private String description;

    private Boolean active;

    private List<Category> categories;

    public ProductDTO(Product product) {
        this.id = product.getId();
        this.name = product.getName();
        this.description = product.getDescription();
        this.active = product.getActive();
        this.categories = getCategories();
    }

    public ProductDTO(ProductDTO productDTO) {
    }
}
