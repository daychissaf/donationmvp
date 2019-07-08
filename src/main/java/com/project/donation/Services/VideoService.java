package com.project.donation.Services;

import com.project.donation.Models.Video;

import java.util.List;

public interface VideoService {

    List<Video> getAllVideos();
    boolean createVideo(Video video);
    boolean updateVideo(Long idVideo, Video video);
    boolean deleteVideo(Long idVideo);
}
