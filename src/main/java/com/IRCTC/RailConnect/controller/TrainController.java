package com.IRCTC.RailConnect.controller;

import com.IRCTC.RailConnect.entity.Train;
import com.IRCTC.RailConnect.exception.TrainNotFoundException;
import com.IRCTC.RailConnect.service.TrainService;
import com.IRCTC.RailConnect.dto.ErrorResponse;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/trains")
public class TrainController {
    private final TrainService trainService;

    public TrainController(TrainService trainService) {
        this.trainService = trainService;
    }

    @GetMapping
    public List<Train> getAll() {
        return trainService.getAllTrain();
    }

    @GetMapping("/{trainNo}")
    public Train get(@PathVariable("trainNo") String trainNumber) {
        return trainService.getTrainById(trainNumber);
    }

    @PostMapping
    public ResponseEntity<Train> add(@Valid @RequestBody Train train) {
        return  new ResponseEntity<>(trainService.addTrain(train), HttpStatus.CREATED);
    }

    @DeleteMapping("/{trainNo}")
    public ResponseEntity<Train> delete(@PathVariable("trainNo") String trainNumber) {
        trainService.deleteTrainByID(trainNumber);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

// In Controller,
// we need to send the Exception message as a Response to the client,
// so we need to create a DTO class for that,
// and then we can use that DTO class to send the response to the client. (via Controller)

    // DTO ---> all necessary info about Exception
    // Controller --->  sends the DTO to client

    // NOTE: Wrap the DTO in Controller Before sending it to Client (for better reading)



//    @ExceptionHandler(NoSuchElementException.class)
//    public ResponseEntity<ErrorResponse> handleNoSuchElementException(NoSuchElementException ex) {
//
//        ErrorResponse errorResponse = new ErrorResponse(
//                "Train not found !! " + ex.getMessage(),
//                "404",
//                false
//        );
//
//        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
//    }
}