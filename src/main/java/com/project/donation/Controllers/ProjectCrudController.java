package com.project.donation.Controllers;

import com.project.donation.Models.Project;
import com.project.donation.Services.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProjectCrudController {

    @Autowired
    private ProjectService projectService;

    @GetMapping("/projects")
    public List<Project> projects(){
        return projectService.getAllAProjects();
    }

    @PostMapping("/createProject")
    public Boolean createProject(@RequestBody Project project){
        return projectService.createProject(project);
    }

    @PutMapping("/updateProject/{idProject}")
    public Boolean updateProject(@PathVariable("idProject") Long idProject, @RequestBody Project project){
        return projectService.updateProject(idProject,project);
    }

    @DeleteMapping("/deleteProject/{idProject}")
    public Boolean deleteProject(@PathVariable("idProject") Long idProject){
        return projectService.deleteProject(idProject);
    }
}
