//package com.IRCTC.RailConnect.controller;
//
//import com.IRCTC.RailConnect.entity.Station;
//import com.IRCTC.RailConnect.service.StationService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("stations")
//public class StationController {
//    @Autowired
//    private StationService stationService;
//
//    @GetMapping
//    public List<Station> getAll(){
//        return stationService.getAll();
//    }
//
//    @GetMapping("/{StationId}")
//    public Station get(@PathVariable String StationId) {
//        return stationService.get(StationId);
//    }
//
//    @PostMapping
//    public void add(@RequestBody Station station){
//        stationService.addStation(station);
//    }
//
//    @DeleteMapping
//    public void delete(@PathVariable String StationId){
//        stationService.delete(StationId);
//    }
//}
