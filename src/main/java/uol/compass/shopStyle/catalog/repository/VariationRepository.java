package uol.compass.shopStyle.catalog.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import uol.compass.shopStyle.catalog.document.Category;
import uol.compass.shopStyle.catalog.document.Variation;

public interface VariationRepository extends MongoRepository<Variation, String> {



}
