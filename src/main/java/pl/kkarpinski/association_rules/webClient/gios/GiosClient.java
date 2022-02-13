package pl.kkarpinski.association_rules.webClient.gios;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import pl.kkarpinski.association_rules.model.GiosDto;
import pl.kkarpinski.association_rules.webClient.gios.dto.GiosGiosDto;
import pl.kkarpinski.association_rules.webClient.gios.dto.GiosStationsDto;

/**
 * Created by kkarp.
 */

@Component
public class GiosClient {

    private static final String API_BASE_ADDRESS = "https://api.gios.gov.pl/pjp-api/rest/";
    private RestTemplate restTemplate = new RestTemplate();


    public GiosDto getDataFromAllStatons (){
        GiosGiosDto giosGiosDto = callGetMethod("station/findAll",
                GiosGiosDto.class);
        return GiosDto.builder()
                .stationId(giosGiosDto.getId())
                .stationName(giosGiosDto.getStationName())
                .stationLat(giosGiosDto.getGegrLat())
                .stationLon(giosGiosDto.getGegrLon())
                .addressStreet(giosGiosDto.getAddressStreet())
                .build();
    }

    public GiosDto getIdFromStations(){
        GiosStationsDto giosStationsDto = callGetMethod("station/findAll",
                GiosStationsDto.class);
        return GiosDto.builder()
                .stationId(giosStationsDto.getId())
                .build();

    }

    public String getAllStations(String id) {
        return callGetMethod("station/findAll",
                String.class);
    }

    public String findSensors(String stationId) {
        return callGetMethod("station/sensors/{stationId}",
                String.class,
                stationId);
    }

    public String getSensorData(String sensorId) {
        return callGetMethod("data/getData/{sensorId}",
                String.class,
                sensorId);
    }

    public String getStationIndex(String stationId) {
        return callGetMethod("aqindex/getIndex/{stationId}",
                String.class,
                stationId);
    }

    public String getGegrLatAndLon(String gegrLat, String gegerLon) {


        return null;
    }


    private <T> T callGetMethod(String url, Class<T> responseType, Object... objects) {
        return restTemplate.getForObject(API_BASE_ADDRESS + url,
                responseType, objects);
    }
}
