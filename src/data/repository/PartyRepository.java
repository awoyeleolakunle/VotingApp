package data.repository;

import data.model.Party;

import java.util.List;

public interface PartyRepository {

    Party saveParty(Party party);

    int count();


    Party findPartyById(int id);

     int countPartyVote(int partyId);

    void deletePartyById(int partyId);

    void deleteAllParties();

    List<Party> findAllParties();
}
