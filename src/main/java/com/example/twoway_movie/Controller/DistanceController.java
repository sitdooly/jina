package com.example.twoway_movie.Controller;

import com.example.twoway_movie.DTO.CityRequest;
import com.example.twoway_movie.Service.DistanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/distance")
public class DistanceController {

    @Autowired
    private DistanceService service;

    @PostMapping("/calculate")
    public Map<String, Object> calculate(@RequestBody CityRequest request)
            throws Exception {

        double distance = service.calculateDistance(
                request.getStartCity(),
                request.getEndCity()
        );

        Map<String, Object> result = new HashMap<>();
        result.put("distance", distance);

        return result;
    }
}