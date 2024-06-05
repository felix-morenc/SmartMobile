package com.example.api.repository;

import com.example.api.entity.EType;
import com.example.api.entity.Item;
import com.example.api.entity.Vote;
import com.example.api.interfaces.IVoteRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class VoteRepository implements IVoteRepository {

    List<Vote> votes;

    public VoteRepository() {
        this.votes = new ArrayList<>();
        buildVotes();
    }

    private void buildVotes(){
        List<Item> defaultOptions = new ArrayList<>();
        Item lights1 = new Item(0, EType.TYPE_LIGHTS, "Red, Yellow, Blue", "Lights 1", "https://www.kinetic-lights.com/wordpress/wp-content/uploads/2019/10/SKALAR-Thumb.jpg");
        Item lights2 = new Item(1, EType.TYPE_LIGHTS, "Red, Green, Orange", "Lights 2", "https://jb-systems.eu/media/catalog/product/s/m/smooth-scan-3-laser-effect-1.jpg");
        Item lights3 = new Item(2, EType.TYPE_LIGHTS, "Green, Purple, Pink", "Lights 3", "https://i.pinimg.com/originals/e1/3e/10/e13e102735ab68b63955a07b80efdd0e.jpg");
        defaultOptions.add(lights1);
        defaultOptions.add(lights2);
        defaultOptions.add(lights3);
        Vote vote1 = new Vote(0,1, "lightsvote", defaultOptions);
        votes.add(vote1);
    }

    @Override
    public List<Vote> getVotesByProjectId(int id) {
        List<Vote> foundVotes = null;
        for (Vote vote: votes) {
            if(vote.getProjectID() == id)
            {
                foundVotes.add(vote);
            }
        }
        return foundVotes;
    }

    @Override
    public Vote getVoteById(int id) {
        for (Vote vote: votes) {
            if(vote.getId() == id)
            {
                return vote;
            }
        }
        return null;
    }

    @Override
    public Vote createVote(Vote vote)
    {
        votes.add(vote);
        return vote;
    }



    @Override
    public String placeVote(int voteId, int itemId)
    {
        Vote currentVote = getVoteById(voteId);
        if(currentVote != null) {
            if (currentVote.getVotes().isEmpty())
            {
                currentVote.setDefaultCount();
                for (int i = 0; i < currentVote.getItems().size() - 1; i++) {
                    if (currentVote.getItems().get(i).getId() == itemId) {
                        currentVote.increaseVote(i);
                    }
                }
            }
            else
            {
                for (int i = 0; i < currentVote.getItems().size() - 1; i++) {
                    if (currentVote.getItems().get(i).getId() == itemId) {
                        currentVote.increaseVote(i);
                    }
                }
            }
            return "Vote placed!";
        }
        else
        {
            return "Unable to place vote!";
        }
    }
}
