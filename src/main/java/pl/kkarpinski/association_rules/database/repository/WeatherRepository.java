package pl.kkarpinski.association_rules.database.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import pl.kkarpinski.association_rules.database.model.DatabaseWeatherModel;

/**
 * Created by kkarp.
 */

@Repository
public interface WeatherRepository extends MongoRepository<DatabaseWeatherModel, String> {

}

