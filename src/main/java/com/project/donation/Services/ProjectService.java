package com.project.donation.Services;

import com.project.donation.Models.Association;
import com.project.donation.Models.Project;

import java.util.List;

public interface ProjectService {
    List<Project> getAllAProjects();

    Boolean createProject(Project project);

    Boolean updateProject(Long idProject, Project project);

    Boolean deleteProject(Long idProject);

    void deleteByVideo(Long idVideo);
}
