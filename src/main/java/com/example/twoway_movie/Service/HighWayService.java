package com.example.twoway_movie.Service;

import org.springframework.stereotype.Service;

@Service
public class HighWayService {


    public int calculate(String carType, int distance) {
        int pricePerKm = 0;


        switch (carType) {
            case "small": pricePerKm = 50; break;
            case "normal": pricePerKm = 100; break;
            case "large": pricePerKm = 200; break;
        }
        return pricePerKm * distance;
    }
}
