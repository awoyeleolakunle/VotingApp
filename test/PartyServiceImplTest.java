import data.model.Party;
import data.repository.PartyRepository;
import data.repository.PartyRepositoryImpl;
import dtos.Request.PartyRegisterRequest;
import dtos.Response.PartyResponse;
import org.junit.jupiter.api.Test;
import services.PartyService;
import services.PartyServiceImpl;
import utils.PartyMapper;

import static org.junit.jupiter.api.Assertions.*;

class PartyServiceImplTest {
    static PartyService partyService = new PartyServiceImpl();
    static Party party;
    static PartyRepository partyRepository = new PartyRepositoryImpl();

    @Test

    public void partyNameIsNotNull(){
        party = new Party();
        PartyRegisterRequest partyRegisterRequest = new PartyRegisterRequest();
        partyRegisterRequest.setName("PDP");
        partyService.registerParty(partyRegisterRequest);
        assertEquals("PDP", partyService.findParty(1).getName());
    }
    @Test
    public void findPartyById(){;
        PartyRegisterRequest partyRegisterRequest = new PartyRegisterRequest();
        partyRegisterRequest.setName("PDP");
       PartyResponse response = partyService.registerParty(partyRegisterRequest);
        assertEquals(1, response.getId());
    }
}