package pl.kkarpinski.association_rules.webClient.gios.dto;

import lombok.Getter;

/**
 * Created by kkarp.
 */
@Getter
public class GiosGiosDto {

    private GiosCommuneDto commune;
    private GiosStationsCityDto city;
    private String addressStreet;
    private String gegrLat;
    private String gegrLon;
    private int id;
    private String stationName;
    private String stationId;

}
