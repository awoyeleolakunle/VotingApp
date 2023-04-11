package data.repository;

import data.model.Voter;

import java.util.List;

public interface VotersRepository {
    Voter saveVoter(Voter voter);

    Voter findVoterByVoterRegistrationNumber(int id);

    void deleteVoterByVoterRegistrationNumber(int id);

    void deleteAllVoters();

    int countTotalVoters();

    List<Voter> findAllVoters();
}
