package com.example.kolokwium_2.controller;

import com.example.kolokwium_2.service.StatkiService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class StatkiApiController {

    private static final Logger LOG = LoggerFactory.getLogger(StatkiApiController.class);

    @Autowired
    StatkiService statkiService;

    @PostMapping("/api/shot")
    ResponseEntity<Void> shot(@RequestParam("y") String y, @RequestParam("x") String x){
        Optional<Boolean> result = statkiService.shot(Integer.parseInt(y), Integer.parseInt(x));
        LOG.info(statkiService.getPlansza().toString());
        if(result.isPresent()){
            if(result.get()){
                return ResponseEntity.ok().build();
            }else{
                return ResponseEntity.notFound().build();
            }
        }else{
            return ResponseEntity.badRequest().build();
        }
    }
}
