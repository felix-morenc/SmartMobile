package com.example.api.repository;

import com.example.api.entity.EventLocation;
import com.example.api.entity.Project;
import com.example.api.interfaces.IProjectRepository;
import org.springframework.stereotype.Repository;

import javax.xml.crypto.Data;
import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Repository
public class ProjectRepository implements IProjectRepository {

    Project eventOne;
    Project eventTwo;
    private List<Project> projects;

    public ProjectRepository(){
        this.eventOne= new Project(1,"Effenaar",1,null,null, new EventLocation(1490,970));
        this.eventTwo= new Project(2,"Dynamo",5,null,null, new EventLocation(1020,960));
        this.projects= new ArrayList<>();
        projects.add(eventOne);
        projects.add(eventTwo);
    }

    @Override
    public Project getProjectForArtis(int userId) {

        for (Project p:projects
             ) {
            if(p.getUserID()==userId){
                return p;
            }
        }

        return null;
    }

    @Override
    public List<Project> getAllProjects() {
        return this.projects;
    }

    @Override
    public Project getProjectByID(int projectID) {
        for (Project p:projects
        ) {
            if(p.getId()==projectID){
                return p;
            }
        }

        return null;
    }

    @Override
    public String setTimestamp(Timestamp timestamp, int projectID) {
        Project project = getProjectByID(projectID);
        if(project!=null){
            project.setTimestampByArtist(timestamp);
            return  "Updated";
        }
        return "Failed";
    }
}
