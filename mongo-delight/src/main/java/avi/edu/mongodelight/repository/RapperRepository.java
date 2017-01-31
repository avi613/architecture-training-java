package avi.edu.mongodelight.repository;

import avi.edu.mongodelight.rapper.Rapper;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RapperRepository extends MongoRepository<Rapper, String> {
    Rapper findByName(String name);
}
