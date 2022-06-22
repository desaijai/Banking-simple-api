package com.mongobank.bankingSys.controller;

import com.mongobank.bankingSys.helper.fileUploader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


@RestController
@RequestMapping("api/v1/imgupload")
public class imageController {

    @Autowired
    fileUploader fileHandler;

    @PostMapping
    public ResponseEntity<String> uploadFile(@PathVariable("file") MultipartFile file) {
//        System.out.println(file.getOriginalFilename());
//        System.out.println(file.getSize());
//        System.out.println(file.getContentType());
        if (file.isEmpty()) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("request must contain file");
        }

        if(!file.getContentType().equals("image/png")){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("only png and jpeg content allowed.");
        }

//      file upload code
        boolean f = fileHandler.uploadFile(file);
        if (f) {
//            System.out.println(f);
            return ResponseEntity.ok("file successfully uploaded!.");
        }
        return new ResponseEntity<>("done", HttpStatus.OK);
    }
}