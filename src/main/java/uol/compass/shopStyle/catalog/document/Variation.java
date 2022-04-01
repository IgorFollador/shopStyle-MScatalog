package uol.compass.shopStyle.catalog.document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "variations")
public class Variation {

    @Id
    private String id;

    private String color;

    private String size;

    private Double price;

    private Integer quantity;

    @DBRef
    private Product product;
}
