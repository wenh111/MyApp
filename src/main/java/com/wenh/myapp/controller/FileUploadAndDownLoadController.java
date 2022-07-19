package com.wenh.myapp.controller;


import com.wenh.myapp.entity.UploadSuccessfulMessage;
import com.wenh.myapp.service.FileUploadAndDownLoadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
@RequestMapping("/photo")
public class FileUploadAndDownLoadController {
    @Autowired
    private FileUploadAndDownLoadService fileUploadAndDownLoadService;


    @PostMapping("/uploadPhoto")
    private UploadSuccessfulMessage uploadPhoto(@RequestParam MultipartFile file, @RequestParam String account) throws IOException {

        return fileUploadAndDownLoadService.photo(file,account);
    }
    @GetMapping("/{fileUUID}")
    public void downloadPhoto(@PathVariable String fileUUID, HttpServletResponse response) throws IOException {

        fileUploadAndDownLoadService.downloadPhoto(fileUUID,response);

    }
    @GetMapping("/getPhoto")
    public void getPhoto(@RequestParam String account, HttpServletResponse response) throws IOException {
        String fileUUID = fileUploadAndDownLoadService.getAccountFileUUID(account);
        System.out.println("fileUUID ===================>" + fileUUID );
        fileUploadAndDownLoadService.downloadPhoto(fileUUID,response);
    }


}
