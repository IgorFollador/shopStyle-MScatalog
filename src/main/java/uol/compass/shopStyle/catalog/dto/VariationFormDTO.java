package uol.compass.shopStyle.catalog.dto;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.DBRef;
import uol.compass.shopStyle.catalog.document.Product;

import java.util.List;

@Data
public class VariationFormDTO {

    private String color;

    private String size;

    private Double price;

    private Integer quantity;

    private String product_id;

}
