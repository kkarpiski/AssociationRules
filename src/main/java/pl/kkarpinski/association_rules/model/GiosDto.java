package pl.kkarpinski.association_rules.model;

import lombok.Builder;
import lombok.Getter;

/**
 * Created by kkarp.
 */
@Getter
@Builder
public class GiosDto {

    public String stationId;
    public String stationName;
    public String stationLat;
    public String stationLon;
    public String addressStreet;
    public String communeName;
    public String districtName;

}
