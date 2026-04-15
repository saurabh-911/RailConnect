package com.IRCTC.RailConnect.service;

import com.IRCTC.RailConnect.entity.FileMetaData;
import com.IRCTC.RailConnect.repository.FileMetaDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FileMetaDataService {
    @Autowired
    private FileMetaDataRepository fileMetaDataRepository;

    public FileMetaData uploadMetaDataToDatabase(FileMetaData fileMetaData){
        return fileMetaDataRepository.save(fileMetaData);
    }
}
