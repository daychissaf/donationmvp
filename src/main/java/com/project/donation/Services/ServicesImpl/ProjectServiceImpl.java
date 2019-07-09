package com.project.donation.Services.ServicesImpl;


import com.project.donation.Models.Association;
import com.project.donation.Models.Project;
import com.project.donation.Models.Video;
import com.project.donation.Repositories.ProjectRepository;
import com.project.donation.Services.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProjectServiceImpl implements ProjectService {

    @Autowired
    ProjectRepository projectRepository;

    @Override
    public List<Project> getAllAProjects() {
        return projectRepository.findAll();
    }

    @Override
    public Boolean createProject(Project project) {
        projectRepository.save(project);
        return true;
    }

    @Override
    public Boolean updateProject(Long idProject, Project project) {
        Project project1 = projectRepository.findById(idProject).get();
        if (!project1.equals(Optional.empty())) {
            if(project.getProjectTitle() != null){
                project1.setProjectTitle(project.getProjectTitle());
            }
            if(project.getDescription() != null){
                project1.setDescription(project.getDescription());
            }
            projectRepository.save(project1);
            return true;
        }
        return false;
    }

    @Override
    public Boolean deleteProject(Long idProject) {
        Optional<Project> project = projectRepository.findById(idProject);
        if (!project.equals(Optional.empty())) {
            project.get().setActive(false);
            projectRepository.save(project.get());
            return true;
        }
        return false;
    }

    @Override
    public void deleteByVideo(Long idVideo) {
        //delete projects that contain only this video
        int i;
        for(Project project: projectRepository.findAll()) {
            i=-1;
            for(Video video: project.getVideos()) {
                if (video.getIdVideo() == idVideo ) i=project.getVideos().indexOf(video);
            }
            if(i>-1) project.getVideos().remove(i);
            if(project.getVideos().size()==0) deleteProject(project.getIdProject());
        }
    }
}
