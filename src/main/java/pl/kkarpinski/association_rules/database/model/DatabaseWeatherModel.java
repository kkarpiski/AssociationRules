package pl.kkarpinski.association_rules.database.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created by kkarp.
 */
@Getter
@Setter
@ToString
@Data

@Document(collation = "Weather")
public class DatabaseWeatherModel {

    @Id
    private int id;
    private float temp;
    private int pressure;
    private int humidity;

}
