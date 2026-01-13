package com.example.twoway_movie.Config;

import org.json.JSONObject;
import org.springframework.context.annotation.Configuration;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.stream.Collectors;

@Configuration
public class KakaoApiUtil {

    private static final String API_KEY = "aad60337b404f4a96189058b5df026dc";

    public static double[] getCoordinates(String city) throws Exception {
        String url = "https://dapi.kakao.com/v2/local/search/address.json?query="
                + URLEncoder.encode(city, "UTF-8");

        HttpURLConnection conn = (HttpURLConnection) new URL(url).openConnection();
        conn.setRequestProperty("Authorization", "KakaoAK " + API_KEY);

        BufferedReader br = new BufferedReader(
                new InputStreamReader(conn.getInputStream(), "UTF-8"));

        String result = br.lines().collect(Collectors.joining());
        JSONObject json = new JSONObject(result);
        JSONObject doc = json.getJSONArray("documents").getJSONObject(0);

        return new double[]{
                doc.getDouble("y"), // latitude
                doc.getDouble("x")  // longitude
        };
    }
}
