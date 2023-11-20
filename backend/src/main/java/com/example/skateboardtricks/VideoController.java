package com.example.skateboardtricks;

import java.io.IOException;

import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api")
public class VideoController {
    @Autowired
    private VideoService videoService;

    @CrossOrigin(origins = { "http://localhost:5173", "http://localhost:5174" })
    @PostMapping("/upload")
    public ResponseEntity<String> uploadVideo(@RequestParam("files") MultipartFile[] files) {
        // Check if the file is a video and perform any necessary validation.
        // You can also save the video to a local directory if needed.
        // Then, pass the video to the HuggingFace inference endpoint.

        // Example: videoService.uploadAndProcessVideo(file);
        for (MultipartFile file : files) {
            System.out.println("Received File: " + file.getOriginalFilename() + " Size: " + file.getSize());
        }

        if (files.length == 0) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        // if (!file.isEmpty()) {
        // return String.format("Received File %s! Size: %d", file.getName(),
        // file.getSize());
        // }

        return new ResponseEntity<String>("Received Files!", HttpStatus.OK);
    }
}
