package pl.kkarpinski.association_rules.model;

import lombok.Builder;
import lombok.Getter;

/**
 * Created by kkarp.
 */
@Getter
@Builder
public class GiosDto {

    private int stationId;
    private String stationName;
    private String stationLat;
    private String stationLon;
    private String addressStreet;
    private String communeName;
    private String districtName;

}
