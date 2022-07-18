package com.wenh.myapp.controller;


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
    private String uploadPhoto(@RequestParam MultipartFile file,@RequestParam String account) throws IOException {
        String url = fileUploadAndDownLoadService.photo(file,account);
        return url;
    }
    @GetMapping("/{fileUUID}")
    public void downloadPhoto(@PathVariable String fileUUID, HttpServletResponse response) throws IOException {

        fileUploadAndDownLoadService.downloadPhoto(fileUUID,response);

    }


}
