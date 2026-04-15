//package com.IRCTC.RailConnect.entity;
//
//import jakarta.persistence.Entity;
//import jakarta.persistence.ManyToMany;
//import org.springframework.data.annotation.Id;
//
//import java.util.List;
//
//@Entity
//public class Station {
//    @Id
//    private String stationCode;
//    private String stationName;
//    private String city;
//    private int platforms;
//    @ManyToMany(mappedBy = "stations")
//    private List<Train> trains;
//
//    public String getStationCode() {
//        return stationCode;
//    }
//
//    public void setStationCode(String stationCode) {
//        this.stationCode = stationCode;
//    }
//
//    public String getStationName() {
//        return stationName;
//    }
//
//    public void setStationName(String stationName) {
//        this.stationName = stationName;
//    }
//
//    public String getCity() {
//        return city;
//    }
//
//    public void setCity(String city) {
//        this.city = city;
//    }
//
//    public int getPlatforms() {
//        return platforms;
//    }
//
//    public void setPlatforms(int platforms) {
//        this.platforms = platforms;
//    }
//}
