package com.project.donation.Models;

import javax.persistence.*;

@Entity
@SequenceGenerator(name="VIDEO_SQ", sequenceName="video_sequence")
public class Video {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "VIDEO_SQ")
    private Long idVideo;
    private String videoTitle;
    private String link;
    private boolean active;

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    @ManyToOne
    private Sponsor sponsor;

    public Long getIdVideo() {
        return idVideo;
    }

    public void setIdVideo(Long idVideo) {
        this.idVideo = idVideo;
    }

    public String getVideoTitle() {
        return videoTitle;
    }

    public void setVideoTitle(String videoTitle) {
        this.videoTitle = videoTitle;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public Sponsor getSponsor() {
        return sponsor;
    }

    public void setSponsor(Sponsor sponsor) {
        this.sponsor = sponsor;
    }


}
