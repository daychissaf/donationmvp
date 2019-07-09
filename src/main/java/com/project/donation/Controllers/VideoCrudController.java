package com.project.donation.Controllers;

import com.project.donation.Models.Video;
import com.project.donation.Services.VideoService;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.MediaTypeFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.MalformedURLException;
import java.util.List;

@RestController
public class VideoCrudController {

    @Autowired
    VideoService videoService;

//    @RequestMapping(value="/myVideo", method=RequestMethod.GET,produces = "application/media")
//    public String getMyVideo(HttpServletResponse response) throws FileNotFoundException {
//
//        File file = new File("C://Users/SQLI/Downloads/myvideo.mp4");
//        InputStream in = new FileInputStream(file);
//        response.setHeader("Content-Disposition", "attachment; filename=" + file.getName());
//        response.setHeader("Content-Length", String.valueOf(file.length()));
//        try {
//            IOUtils.copy(in, response.getOutputStream());
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        return ""+response;
//
//    }
//    @GetMapping(value = "/myVideo")
//    public ResponseEntity<UrlResource> getFullVideo() throws MalformedURLException {
//         UrlResource video = new UrlResource("file:C://Users/SQLI/Downloads/myvideo.mp4");
//         return ResponseEntity.status(HttpStatus.PARTIAL_CONTENT)
//                .contentType(MediaTypeFactory
//                        .getMediaType(video)
//                        .orElse(MediaType.APPLICATION_OCTET_STREAM))
//                .body(video);
//    }

    @GetMapping("/videos")
    public List<Video> videos(){
        return videoService.getAllVideos();
    }

    @PostMapping("/createVideo")
    public Boolean createVideo(@RequestBody Video video){
        return videoService.createVideo(video);
    }

    @PutMapping("/updateVideo/{idVideo}")
    public Boolean updateVideo(@PathVariable("idVideo") Long idVideo, @RequestBody Video video){
        return videoService.updateVideo(idVideo, video);
    }

    @DeleteMapping("/deleteVideo/{idVideo}")
    public Boolean deleteVideo(@PathVariable("idVideo") Long idVideo){
        return videoService.deleteVideo(idVideo);
    }
}

