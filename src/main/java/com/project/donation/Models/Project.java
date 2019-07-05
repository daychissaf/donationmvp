package com.project.donation.Models;

import javax.persistence.*;
import java.util.List;

@Entity
@SequenceGenerator(name="PROJECT_SQ", sequenceName="project_sequence")
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "PROJECT_SQ")
    private Long idProject;
    private String projectTitle;
    private String description;

    @ManyToOne
    private Association association;

    @ManyToMany
    private List<Video> videos;

    public List<Video> getVideos() {
        return videos;
    }

    public void setVideos(List<Video> videos) {
        this.videos = videos;
    }

    public Long getIdProject() {
        return idProject;
    }

    public void setIdProject(Long idProject) {
        this.idProject = idProject;
    }

    public String getProjectTitle() {
        return projectTitle;
    }

    public void setProjectTitle(String projectTitle) {
        this.projectTitle = projectTitle;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Association getAssociation() {
        return association;
    }

    public void setAssociation(Association association) {
        this.association = association;
    }
}
