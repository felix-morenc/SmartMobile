package com.example.api.controller;

import com.example.api.entity.Vote;
import com.example.api.services.VoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("/vote")
@CrossOrigin("*")
public class VoteController {

    @Autowired
    private VoteService service;

    @GetMapping("/getProjectVotes/{id}")
    public List<Vote> getVotesByProjectId(@PathVariable int id) {return service.getVotesByProjectId(id);}

    @GetMapping("/getVote/{id}")
    public Vote getVoteById(@PathVariable int id) {return service.getVoteById(id);}

    @PostMapping("/createVote")
    public Vote createVote(Vote vote) {return service.createVote(vote);}

    @PutMapping("/place/{voteId}/{itemId}")
    public String placeVote(@PathVariable("voteId") int voteId, @PathVariable("itemId") int itemId) {return service.placeVote(voteId,itemId);}


}
