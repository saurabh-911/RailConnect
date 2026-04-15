package com.IRCTC.RailConnect.controller;

import com.IRCTC.RailConnect.entity.FileMetaData;
import com.IRCTC.RailConnect.helper.Helper;
import com.IRCTC.RailConnect.service.FileMetaDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.UUID;

@RestController
@RequestMapping("/file")
public class FileUploadController {

    @Value("${file.upload.folder}")
    private String folder;

    @Autowired
    private FileMetaDataService fileMetaDataService;


    @PostMapping("/upload")
    public ResponseEntity<FileMetaData> uploadFile(@RequestParam("file")MultipartFile file) throws IOException {

        // 1. Get Necessary Details from the file ----> (ipStream + orgName)
        InputStream inputStream = file.getInputStream();
        String originalFilename = file.getOriginalFilename();

        // 2. Create Folder to store file (in local) ----> (folderName + isExists + create)

        if(!Files.exists(Paths.get(folder))){  // if folder doesn't exist, then create it
            System.out.println("Creating Folder...");
            Files.createDirectories(Paths.get(folder));
        }

        // 3. Create Distinct file Name with path (with folderName) ----> (folderName + UUID + fileName)
//        String fileName = folder + "_" + UUID.randomUUID()  + "_" + originalFilename;                            Use Helper
//                           uploads_1000_fileName.ext (don't UUID after filename: file.pdf_1000 (wrong))

        assert originalFilename != null;
        String fileName = Helper.getFilePathName(folder, originalFilename);

        // 4. Copy the file in folder  ----> (kisse, kaha, kaise)
        Files.copy(inputStream, Paths.get(fileName), StandardCopyOption.REPLACE_EXISTING);

        // 5. Creating MetaData Response
        FileMetaData fileMetaData = new FileMetaData();

        fileMetaData.setFileId(UUID.randomUUID().toString());
        fileMetaData.setFileName(fileName);
        fileMetaData.setFileSize(file.getSize());   // file.getSize() gives the size of the file in bytes
        fileMetaData.setFileType(file.getContentType());

        // 6. Saving to Database
        FileMetaData responseMetaData = fileMetaDataService.uploadMetaDataToDatabase(fileMetaData);

        return new ResponseEntity<>(responseMetaData, HttpStatus.CREATED);
    }
}
