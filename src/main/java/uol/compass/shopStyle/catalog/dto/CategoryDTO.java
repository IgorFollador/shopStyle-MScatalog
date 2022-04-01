package uol.compass.shopStyle.catalog.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import uol.compass.shopStyle.catalog.document.Category;

@Data
@NoArgsConstructor
public class CategoryDTO {

    private String id;

    private String name;

    private Boolean active;

    public CategoryDTO(Category category) {
        this.id = category.getId();
        this.name = category.getName();
        this.active = category.getActive();
    }
}
