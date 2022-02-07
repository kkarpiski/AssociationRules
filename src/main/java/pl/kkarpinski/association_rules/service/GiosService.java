package pl.kkarpinski.association_rules.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.configurationprocessor.json.JSONArray;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.stereotype.Service;
import pl.kkarpinski.association_rules.model.GiosDto;
import pl.kkarpinski.association_rules.webClient.gios.GiosClient;

import java.util.Iterator;

/**
 * Created by kkarp.
 */
@Service
@Slf4j
@RequiredArgsConstructor
public class GiosService {

    private final GiosClient giosClient;

    public String getGiosData() throws JSONException {

        JSONArray jsonArray = new JSONArray(giosClient.getAllStations("id"));
        JSONObject jsonObject = new JSONObject();
        log.info(String.valueOf(jsonArray));
        for (int i = 0; i < jsonArray.length(); i++) {
            Object value = jsonArray.get(i);
            System.out.println(value);

        }

        JSONArray sensorArray = new JSONArray(giosClient.findSensors("296"));
        log.info(String.valueOf(sensorArray));
        for (int i = 0; i < sensorArray.length(); i++) {
            Object value = sensorArray.get(i);
            System.out.println(value);
        }

        JSONObject sensorDataObj = new JSONObject(giosClient.getSensorData("2088"));
        log.info(String.valueOf(sensorDataObj));
        Iterator keys = sensorDataObj.keys();
        while (keys.hasNext()) {
            String key = (String) keys.next();
            Object value = sensorDataObj.get(key);
            System.out.println(key + " : " + value);
        }

        JSONObject stationIndexObj = new JSONObject(giosClient.getStationIndex("296"));
        log.info(String.valueOf(stationIndexObj));
        Iterator stationKeys = stationIndexObj.keys();
        while (keys.hasNext()) {
            String stationkey = (String) stationKeys.next();
            Object value = stationIndexObj.get(stationkey);
            System.out.println(stationkey + " : " + value);
        }


        return null;
    }
    public GiosDto getDataFromAllStatons(){
        return giosClient.getDataFromAllStatons();
    }

    String[] extractNames(JSONObject input) throws JSONException {
        JSONArray objects = input.getJSONArray("id");
        int namesCount = objects.length();
        String[] names = new String[namesCount];
        for (int i = 0; i < namesCount; i++) {
            names[i] = objects.getJSONObject(i).getString("id");
        }
        return names;
    }

}