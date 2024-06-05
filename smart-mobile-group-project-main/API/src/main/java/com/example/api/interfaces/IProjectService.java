package com.example.api.interfaces;

import com.example.api.entity.Project;

import java.sql.Timestamp;
import java.util.List;

public interface IProjectService {

    Project getProjectForArtis(int userId);

    List<Project> getAllProjects();

    Project getProjectByID(int projectID);

    String setTimestamp(Timestamp timestamp, int projectID);
}
