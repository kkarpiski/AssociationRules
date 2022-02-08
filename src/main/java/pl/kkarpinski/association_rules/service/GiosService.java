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

    public String getGiosData() throws JSONException {

        JSONArray allStationsJsonArray = new JSONArray(giosClient.getAllStations("id"));
        log.info(String.valueOf(allStationsJsonArray));

        List stationsIdList = new ArrayList();
        List sensorsIdList = new ArrayList();

        for (int i = 0; i < allStationsJsonArray.length(); i++) {
            Object allStationValue = allStationsJsonArray.get(i);
            JSONObject item = allStationsJsonArray.getJSONObject(i);
            String id = item.getString("id");
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
            for (int b = 0; b < stationsIdList.size(); b++) {
                log.info(String.valueOf(sensorsIdList.get(b)));
            JSONObject sensorDataObj = new JSONObject(giosClient.getSensorData((String) sensorsIdList.get(b)));
            log.info(String.valueOf(sensorDataObj));
            Iterator keys = sensorDataObj.keys();
            while (keys.hasNext()) {
                String key = (String) keys.next();
                Object sensorValue = sensorDataObj.get(key);
                System.out.println(key + " : " + sensorValue);

                JSONArray sensorArray = new JSONArray(giosClient.findSensors((String) stationsIdList.get(b)));
                log.info(String.valueOf(sensorArray));
                for (int o = 0; o < sensorArray.length(); o++) {
                    Object findSensorValue = sensorArray.get(o);
                    JSONObject obj = sensorArray.getJSONObject(o);
                    String id = obj.getString("id");
                    sensorsIdList.add(id);
                }
            }

            }
            return null;
        }

}