package com.example.api.entity;


import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Vote {

    private int id;
    private int projectID;
    private String name;
    private List<Item> items;
    private List<Integer> votes;

    public Vote(int id, int projectID, String name, List<Item> items) {
        this.id = id;
        this.projectID = projectID;
        this.name = name;
        this.items = items;
        this.votes = new ArrayList<>();
    }

    public void setDefaultCount(){
        votes.add(0);
        votes.add(0);
    }

    public void increaseVote(int updateIndex){
        int voteCount = votes.get(updateIndex);
        voteCount++;
        votes.set(updateIndex, voteCount);
    }


}
