package uol.compass.shopStyle.catalog.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import uol.compass.shopStyle.catalog.document.Product;

public interface ProductRepository extends MongoRepository<Product, String> {

}
