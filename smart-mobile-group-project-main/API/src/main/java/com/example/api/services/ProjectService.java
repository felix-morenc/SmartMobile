package com.example.api.services;

import com.example.api.entity.Project;
import com.example.api.interfaces.IProjectRepository;
import com.example.api.interfaces.IProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

@Service
public class ProjectService implements IProjectService {

    @Autowired
    IProjectRepository iProjectRepository;

    @Override
    public Project getProjectForArtis(int userId) {

        if(userId==1){
            return iProjectRepository.getProjectForArtis(userId);
        }
        return null;
    }

    @Override
    public List<Project> getAllProjects() {
        return iProjectRepository.getAllProjects();
    }

    @Override
    public Project getProjectByID(int projectID) {
        if(projectID!=0){
            return iProjectRepository.getProjectByID(projectID);
        }
        return null;
    }

    @Override
    public String setTimestamp(Timestamp timestamp, int projectID) {
        return iProjectRepository.setTimestamp(timestamp,projectID);
    }
}
