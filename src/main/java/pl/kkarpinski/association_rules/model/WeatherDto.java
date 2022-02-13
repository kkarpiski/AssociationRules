package pl.kkarpinski.association_rules.model;

import lombok.Builder;
import lombok.Getter;
import org.springframework.data.annotation.Id;

/**
 * Created by kkarp.
 */
@Getter
@Builder
public class WeatherDto {

    public float temperature;
    public int pressure;
    public int humidity;
    public float windSpeed;

}