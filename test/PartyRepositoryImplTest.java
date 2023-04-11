import data.model.Party;
import data.repository.PartyRepository;
import data.repository.PartyRepositoryImpl;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PartyRepositoryImplTest {

    private PartyRepository partyRepository = new PartyRepositoryImpl();
    private Party party;


    @Test
    public void saveParty_IdIsOneTest(){
        party = new Party();
        partyRepository.saveParty(party);
        assertEquals(1, partyRepository.count());

    }

    @Test
    public void partyCanBe_FoundByIdTest(){
        party = new Party();
        partyRepository.saveParty(party);
        System.out.println(party);
        assertEquals(party,  partyRepository.findPartyById(party.getId()));
    }
    @Test
    public void partyVoteCanBeSavedAndCounted(){
        party = new Party();
        partyRepository.saveParty(party);
        partyRepository.countPartyVote(party.getId());
        System.out.println(partyRepository.findPartyById(party.getId()));
        assertEquals(0, partyRepository.findPartyById(party.getId()).getVoteCount());
    }
    @Test
    public void partyCanBeDeletedByIdTest(){
        party = new Party();
        partyRepository.saveParty(party);
        Party newParty = new Party();
        partyRepository.saveParty(newParty);
        partyRepository.deletePartyById(party.getId());
        assertEquals(1, partyRepository.count());
    }
    @Test
    public void allPartiesCanBeDeleted(){
        party = new Party();
        partyRepository.saveParty(party);
        Party newParty = new Party();
        partyRepository.saveParty(newParty);
        partyRepository.deleteAllParties();
        assertEquals(0, partyRepository.count());
    }

    @Test
    public void findAllPartiesTest(){
        party = new Party();
        partyRepository.saveParty(party);
        Party newParty = new Party();
        partyRepository.saveParty(newParty);
        System.out.println(partyRepository.findAllParties());
        assertEquals(2, partyRepository.count());
    }
}