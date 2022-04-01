package uol.compass.shopStyle.catalog.dto;

import lombok.Data;

@Data
public class ProductFormDTO {

    private String name;

    private String description;

    private Boolean active = true;

    private String category_ids;

}
