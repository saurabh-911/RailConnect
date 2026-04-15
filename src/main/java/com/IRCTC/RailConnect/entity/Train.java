package com.IRCTC.RailConnect.entity;

import com.IRCTC.RailConnect.validation.ValidCoach;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

import java.util.List;

@Entity
public class Train {
    @Id
    @NotEmpty(message = "Train number cannot be empty")
    @Size(min = 5, max = 10, message = "Train number must be between 5 and 10 characters")
    @Pattern(regexp = "^[0-9]{5}$", message = "Train number must be exactly 5 digits")
    private String trainNumber;

    @Pattern(regexp="^[A-Za-z ]+$",message = "Train name must contain only letters and spaces")
    private String trainName;

    @ValidCoach
    private int coaches;

//    @ManyToMany(cascade = CascadeType.ALL)
//    @JoinTable(name = "train_station",
//            joinColumns = @JoinColumn(name = "train_number"),
//            inverseJoinColumns = @JoinColumn(name = "station_code"))
//    private List<Station> stations;

    @JsonCreator
    public Train(
            @JsonProperty("trainNumber") String trainNumber,
            @JsonProperty("trainName") String trainName,
            @JsonProperty("coaches") int coaches
    ) {
        this.trainNumber = trainNumber;
        this.trainName = trainName;
        this.coaches = coaches;
    }

    public Train() {}

    public String getTrainNumber() {
        return trainNumber;
    }

    public void setTrainNumber(String trainNumber) {
        this.trainNumber = trainNumber;
    }

    public String getTrainName() {
        return trainName;
    }

    public void setTrainName(String trainName) {
        this.trainName = trainName;
    }

    public int getCoaches() {
        return coaches;
    }

    public void setCoaches(int coaches) {
        this.coaches = coaches;
    }
}
