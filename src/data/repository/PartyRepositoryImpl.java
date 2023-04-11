package data.repository;

import data.model.Party;

import java.util.ArrayList;
import java.util.List;

public class PartyRepositoryImpl implements PartyRepository {

    List<Party> parties = new ArrayList<>();
    private int count;

    @Override
    public Party saveParty(Party party) {
        boolean partyHasNotBeenRegistered = party.getId() == 0;
        if (partyHasNotBeenRegistered) {
            party.setId(generateId());
            parties.add(party);
            count++;
        }
        return party;
    }

    @Override
    public int count() {
        return count;
    }

    @Override
    public Party findPartyById(int id) {

        for (Party party: parties) {
            if (party.getId() == id) return
                    party;
        // return parties.get(1);
    }

         return null;
}


    @Override
    public int countPartyVote(int partyId) {
        return parties.get(partyId-1).getVoteCount();

    }


    @Override
    public void deletePartyById(int partyId) {
        for (Party party: parties) {
            if(party.getId() == partyId)
                parties.remove(party);
            count--;
            break;
        }

    }

    @Override
    public void deleteAllParties() {
            parties.removeAll(parties);
            count = parties.size();
        }

    @Override
    public List<Party> findAllParties() {
        return parties;
    }


    private int generateId() {
        return count + 1;

    }

}
