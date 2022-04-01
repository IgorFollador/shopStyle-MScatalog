package uol.compass.shopStyle.catalog.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import uol.compass.shopStyle.catalog.document.Category;

public interface CategoryRepository extends MongoRepository<Category, String> {



}
