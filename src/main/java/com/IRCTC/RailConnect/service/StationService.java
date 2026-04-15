//package com.IRCTC.RailConnect.service;
//
//import com.IRCTC.RailConnect.entity.Station;
//import com.IRCTC.RailConnect.repository.StationRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
//@Service
//public class StationService {
//    @Autowired
//    private StationRepository stationRepository;
//
//    public void addStation(Station station){
//        stationRepository.save(station);
//    }
//
//    public Station get(String StationId) {
//        return stationRepository.findById(StationId).orElseThrow(()->new RuntimeException("Station with ID "+StationId+" not found"));
//    }
//
//    public List<Station> getAll(){
//        return stationRepository.findAll();
//    }
//
//    public void delete(String StationId){
//        stationRepository.deleteById(StationId);
//    }
// }
