package com.example.skateboardtricks;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.Size;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class VideoService {
    public void uploadAndProcessVideo(MultipartFile file) {
        // Perform video processing here using OpenCV.
        // For example, resizing the video.
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
        Mat video = Imgcodecs.imread("path/to/uploaded/video.mp4");
        Mat resizedVideo = new Mat();
        Size newSize = new Size(224, 224); // New dimensions
        Imgproc.resize(video, resizedVideo, newSize);
        // Save the resized video or forward it to HuggingFace.
    }
}
