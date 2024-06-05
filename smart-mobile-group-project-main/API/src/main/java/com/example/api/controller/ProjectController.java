package com.example.api.controller;

import com.example.api.entity.Project;
import com.example.api.interfaces.IProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.List;

@RestController
@CrossOrigin("*")
public class ProjectController {

    @Autowired
    IProjectService iProjectService;


    @GetMapping("/project/get/project/artist/{artistID}")
    public ResponseEntity<Object> getProjectForArtist(@PathVariable("artistID") int artistID){
        Project artistProject = this.iProjectService.getProjectForArtis(artistID);
        if (artistProject != null) {
            return ResponseEntity.ok().body(artistProject);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/project/get/project/by/id/{projectID}")
    public ResponseEntity<Object> getProjectByID(@PathVariable("projectID") int projectID){
        Project artistProject = this.iProjectService.getProjectByID(projectID);
        if (artistProject != null) {
            return ResponseEntity.ok().body(artistProject);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/project/get/all/projects")
    public ResponseEntity<Object> getAllProjects(){
        List<Project> projects = iProjectService.getAllProjects();
        if (projects != null) {
            return ResponseEntity.ok().body(projects);
        } else {
            return ResponseEntity.notFound().build();
        }

    }

    @PostMapping("/project/change/timestamp/{projectID}/{timestamp}")
    public ResponseEntity updateTimestamp(@PathVariable("projectID") int projectID, @PathVariable("timestamp") Timestamp timestamp){
        String isUpdated = iProjectService.setTimestamp(timestamp,projectID);
        if(isUpdated=="Updated"){
            return ResponseEntity.ok().body(isUpdated);
        }
        else {
            return ResponseEntity.notFound().build();
        }
    }
}
