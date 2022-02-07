package pl.kkarpinski.association_rules.model;

import lombok.Builder;
import lombok.Getter;

/**
 * Created by kkarp.
 */
@Getter
@Builder
public class WeatherDto {

    private float temperature;
    private int pressure;
    private int humidity;
    private float windSpeed;

}
