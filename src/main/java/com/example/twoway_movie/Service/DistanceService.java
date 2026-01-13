package com.example.twoway_movie.Service;

import com.example.twoway_movie.Config.KakaoApiUtil;
import org.springframework.stereotype.Service;

@Service
public class DistanceService {

    public double calculateDistance(String start, String end) throws Exception {

        double[] startCoord = KakaoApiUtil.getCoordinates(start);
        double[] endCoord = KakaoApiUtil.getCoordinates(end);

        return haversine(
                startCoord[0], startCoord[1],
                endCoord[0], endCoord[1]
        );
    }

    private double haversine(double lat1, double lon1, double lat2, double lon2) {

        final int R = 6371; // km
        double dLat = Math.toRadians(lat2 - lat1);
        double dLon = Math.toRadians(lon2 - lon1);

        double a = Math.sin(dLat/2) * Math.sin(dLat/2)
                + Math.cos(Math.toRadians(lat1))
                * Math.cos(Math.toRadians(lat2))
                * Math.sin(dLon/2) * Math.sin(dLon/2);

        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a));
        return R * c;
    }
}
