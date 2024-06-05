package com.example.api.services;

import com.example.api.entity.Vote;
import com.example.api.interfaces.IVoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VoteService {

    @Autowired
    private IVoteRepository repository;

    public List<Vote> getVotesByProjectId(int id) {return repository.getVotesByProjectId(id);}

    public Vote getVoteById(int id) {return repository.getVoteById(id);}

    public Vote createVote(Vote vote) {return repository.createVote(vote);}

    public String placeVote(int voteId, int itemId) {return repository.placeVote(voteId, itemId);}

}
