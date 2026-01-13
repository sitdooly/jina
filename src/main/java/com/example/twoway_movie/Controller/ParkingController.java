package com.example.twoway_movie.Controller;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController

public class ParkingController {

    @GetMapping("/search")
    public List<Map<String, String>> searchParking(
            @RequestParam String region) throws Exception {

        // 공공데이터 API 호출 (예시)
        String apiUrl = "공공데이터_API_URL?serviceKey=KEY&지역="
                + URLEncoder.encode(region, "UTF-8");

        URL url = new URL(apiUrl);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();

        BufferedReader br = new BufferedReader(
                new InputStreamReader(conn.getInputStream(), "UTF-8"));

        String result = br.lines().collect(Collectors.joining());

        JSONObject json = new JSONObject(result);
        JSONArray arr = json.getJSONArray("data");

        List<Map<String, String>> list = new ArrayList<>();

        for (int i = 0; i < arr.length(); i++) {
            JSONObject o = arr.getJSONObject(i);

            Map<String, String> map = new HashMap<>();
            map.put("name", o.getString("parkingName"));
            map.put("address", o.getString("address"));
            map.put("lat", o.getString("latitude"));
            map.put("lng", o.getString("longitude"));

            list.add(map);
        }

        return list;
    }

}
