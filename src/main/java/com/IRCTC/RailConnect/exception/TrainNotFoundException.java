package com.IRCTC.RailConnect.exception;

public class TrainNotFoundException extends RuntimeException{
    public TrainNotFoundException(String message){
        super(message);
    }
}


// 1. Define Custom Exception in exception package
// 2. Use it in Service, for message
// 3. Create a DTO record for data to send to client
// 4. Inside Controller/ Global ex class ---> send the WRAPPED DTO to Client
