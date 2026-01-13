package com.example.twoway_movie.Controller;

import com.example.twoway_movie.Service.HighWayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HigeWayController {
    @Autowired
    HighWayService highWayService;

    @GetMapping("/hiwayinput")
        public String hh1(){
        return"highway/input";
    }

    @PostMapping("/calculate")
    public String calculate(@RequestParam String carType,
                            @RequestParam int distance,
                            Model model) {
        int fee =      highWayService.calculate(carType, distance);
        model.addAttribute("fee", fee);
        model.addAttribute("distance", distance);
        return "highway/result";
    }
/// ///
    @GetMapping("/citymove")
    public String kk2(){
        return "distance";
    }


    @GetMapping("/citymovemap")
    public String kk3(){
        return "distance_map";
    }
}
