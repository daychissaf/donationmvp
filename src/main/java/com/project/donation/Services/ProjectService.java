package com.project.donation.Services;

import com.project.donation.Models.Association;
import com.project.donation.Models.Project;

import java.util.List;

public interface ProjectService {
    List<Project> getAllAProjects();

    Boolean createProject(Project project);

    Boolean updateProject(Long idProject, Project project);
    
    boolean deleteByAssociation(Long associationId);

    Boolean deleteProject(Long idProject);
}
