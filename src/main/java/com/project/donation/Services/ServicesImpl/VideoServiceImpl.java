package com.project.donation.Services.ServicesImpl;

import com.project.donation.Models.Sponsor;
import com.project.donation.Models.Video;
import com.project.donation.Repositories.VideoRepository;
import com.project.donation.Services.SponsorService;
import com.project.donation.Services.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VideoServiceImpl implements VideoService {

    @Autowired
    VideoRepository videoRepository;

    @Autowired
    SponsorService sponsorService;

    @Override
    public List<Video> getAllVideos() {
        return videoRepository.findAll();
    }

    @Override
    public boolean createVideo(Video video) {
        if (video.getLink() != null && video.getVideoTitle() != null && video.getSponsor() != null && sponsorService.sponsorExists(video.getSponsor().getIdSponsor())) {
            videoRepository.save(video);
            return true;
        }
        return false;
    }

    @Override
    public boolean updateVideo(Long idVideo, Video video) {
        Video video1 = videoRepository.findById(idVideo).get();
        if(video1.equals(Optional.empty())) return false;
        if(video.getVideoTitle() != null) video1.setVideoTitle(video.getVideoTitle());
        if(video.getLink() != null) video1.setLink(video.getLink());
        if(video.getSponsor() != null) video1.setSponsor(video.getSponsor());
        videoRepository.save(video1);
        return true;
    }

    @Override
    public boolean deleteVideo(Long idVideo) {
        Video video1 = videoRepository.findById(idVideo).get();
        if(video1.equals(Optional.empty())) return false;
        videoRepository.deleteById(idVideo);
        return true;
    }

    @Override
    public void deletebySponsor(Long idSponsor) {
        for(Video video: videoRepository.findAll()) {
            if(video.getSponsor().getIdSponsor() == idSponsor) deleteVideo(video.getIdVideo());
        }
    }
}
