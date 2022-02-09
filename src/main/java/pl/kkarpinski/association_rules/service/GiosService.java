package pl.kkarpinski.association_rules.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.configurationprocessor.json.JSONArray;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.stereotype.Service;
import pl.kkarpinski.association_rules.webClient.gios.GiosClient;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


/**
 * Created by kkarp.
 */
@Service
@Slf4j
@RequiredArgsConstructor
public class GiosService {

    private final GiosClient giosClient;
    int d = 0;

    public String getGiosData() throws JSONException {

        JSONArray allStationsJsonArray = new JSONArray(giosClient.getAllStations("id"));
        log.info(String.valueOf(allStationsJsonArray));

        List<String> stationsIdList = new ArrayList<>();
        List<String> sensorsIdList = new ArrayList<>();

        for (int i = 0; i < allStationsJsonArray.length(); i++) {
            JSONObject item = allStationsJsonArray.getJSONObject(i);
            String id = item.getString("id");
            String lat = item.getString("gegrLat");
            String lon = item.getString("gegrLon");
            stationsIdList.add(id);


            JSONObject stationIndexObj = new JSONObject(giosClient.getStationIndex(id));
            log.info(String.valueOf(stationIndexObj));
            Iterator stationKeys = stationIndexObj.keys();
            while (stationKeys.hasNext()) {
                String stationkey = (String) stationKeys.next();
                Object stationValue = stationIndexObj.get(stationkey);
                System.out.println(stationkey + " : " + stationValue);
            }

        }
        for (String s : stationsIdList) {
            JSONArray sensorArray = new JSONArray(giosClient.findSensors(s));
            log.info(String.valueOf(sensorArray));
            for (int o = 0; o < sensorArray.length(); o++) {
                JSONObject obj = sensorArray.getJSONObject(o);
                String id = obj.getString("id");
                sensorsIdList.add(id);

            }
        }
        for (String value : sensorsIdList) {
            log.info(String.valueOf(value));
            JSONObject sensorDataObj = new JSONObject(giosClient.getSensorData(value));
            log.info(String.valueOf(sensorDataObj));
            Iterator keys = sensorDataObj.keys();
            while (keys.hasNext()) {
                String key = (String) keys.next();
                Object sensorValue = sensorDataObj.get(key);
                System.out.println(key + " : " + sensorValue);
            }
        }
        return null;
    }
}



