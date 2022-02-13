package pl.kkarpinski.association_rules.database.repository;

import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import pl.kkarpinski.association_rules.database.model.DatabaseStationModel;

/**
 * Created by kkarp.
 */


public interface DatabaseStationRepository extends MongoRepository<DatabaseStationModel, String> {

}
