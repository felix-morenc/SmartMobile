package com.example.api.interfaces;

import com.example.api.entity.Vote;

import java.util.List;

public interface IVoteRepository {

    List<Vote> getVotesByProjectId(int id);

    Vote getVoteById(int id);

    Vote createVote(Vote vote);

    String placeVote(int voteId, int itemId);
}
