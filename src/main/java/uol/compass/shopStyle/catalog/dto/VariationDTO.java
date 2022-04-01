package uol.compass.shopStyle.catalog.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.mapping.DBRef;
import uol.compass.shopStyle.catalog.document.Product;
import uol.compass.shopStyle.catalog.document.Variation;

import java.util.List;

@Data
@NoArgsConstructor
public class VariationDTO {

    private String id;

    private String color;

    private String size;

    private Double price;

    private Integer quantity;

    @DBRef
    private Product product;

    public VariationDTO(Variation variation) {
        this.id = variation.getId();
        this.color = variation.getColor();
        this.size = variation.getSize();
        this.price = variation.getPrice();
        this.quantity = variation.getQuantity();
        this.product = variation.getProduct();
    }
}
