package com.IRCTC.RailConnect.service;

import com.IRCTC.RailConnect.entity.Train;
import com.IRCTC.RailConnect.exception.TrainNotFoundException;
import com.IRCTC.RailConnect.repository.TrainRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TrainService {

    @Autowired
    private TrainRepository trainRepository;

    public Train addTrain(Train train){
        return trainRepository.save(train);
    }

    //get (search)
    public Train getTrainById(String trainId){
        return trainRepository.findById(trainId).orElseThrow(()->new TrainNotFoundException("Train with ID "+trainId+" not found"));    // in service, where exception generates
                                                                                                                                       // declare/use runtime/custom exception
                                                                                                                                      // means: Service = throw + message
    }

    //getAll
    public List<Train> getAllTrain(){
        return trainRepository.findAll();
    }

    //delete
    public void deleteTrainByID(String trainId){

        if (!trainRepository.existsById(trainId)) {
            throw new TrainNotFoundException("Train with ID " + trainId + " can't be deleted!");
        }
//        try {
        trainRepository.deleteById(trainId);
//        }catch (Exception e){
//            throw new TrainNotFoundException("Train with ID "+trainId+" can't be deleted");
//        }
    }
}
