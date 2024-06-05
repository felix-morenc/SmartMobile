package com.example.api.entity;

import lombok.Getter;
import lombok.Setter;

import java.sql.Time;
import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter

public class Project {

    private int id;
    private String name;
    private int userID;
    private List<Item> items;
    private List<Vote> votes;
    private LocalDateTime durationBetweenVotes;
    private EventLocation eventLocation;

    public Project(int id, String name, int userID, List<Item> items, List<Vote> votes, EventLocation eventLocation) {
        this.id = id;
        this.name = name;
        this.userID = userID;
        this.items = items;
        this.votes = votes;
        setTimeStampToDefault();
        this.eventLocation=eventLocation;
    }

    private void setTimeStampToDefault(){
        Timestamp timestamp = Timestamp.from(Instant.now());
        timestamp.setNanos(0);
        this.durationBetweenVotes = timestamp.toLocalDateTime();
    }

    public void setTimestampByArtist(Timestamp timestamp){
        this.durationBetweenVotes=timestamp.toLocalDateTime();
    }
}
