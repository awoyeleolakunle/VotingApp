import data.model.Party;
import data.model.Voter;
import dtos.Request.PartyRegisterRequest;
import dtos.Request.VotersRegisterRequest;
import org.junit.jupiter.api.Test;
import services.*;

import static org.junit.jupiter.api.Assertions.*;

class VotingAppImplTest {

    private static VotingAppService votingAppService = new VotingAppImpl();
    private static Voter voter = new Voter();
    private static Party party = new Party();
    private static PartyService partyService = new PartyServiceImpl();
    private static VotersService votersService = new VotersServiceImpl();
    private static PartyRegisterRequest partyRegisterRequest;
    private static VotersRegisterRequest votersRegisterRequest;

    @Test
    public void voterCanCastVoteForAParty(){

        partyRegisterRequest = new PartyRegisterRequest();
        partyRegisterRequest.setName("PDP");
        partyService.registerParty(partyRegisterRequest);
        System.out.println(partyService.findParty(1).getId() + "yeah yeah");
        System.out.println(partyService.findParty(1).getVoteCount() + "yeah yeah");
        System.out.println(partyService.findParty(1).getName() + " yeah yeah yeah");


        PartyRegisterRequest partyRegisterRequest1 = new PartyRegisterRequest();

        partyRegisterRequest1.setName("APC");
        partyService.registerParty(partyRegisterRequest1);
        System.out.println(partyService.findParty(2).getId());

        votersRegisterRequest = new VotersRegisterRequest();
        votersRegisterRequest.setName("Chibuzo");
        votersService.registerVoter(votersRegisterRequest);



        VotersRegisterRequest votersRegisterRequest1 = new VotersRegisterRequest();
        votersRegisterRequest1.setName("Chief");
        votersService.registerVoter(votersRegisterRequest1);
        VotersRegisterRequest votersRegisterRequest2 = new VotersRegisterRequest();
        votersRegisterRequest2.setName("FM");
        votersService.registerVoter(votersRegisterRequest2);


        System.out.println(votersService.findVoter(1).getVoteCount());

        votingAppService.castVote(2,1);

        votingAppService.castVote(1,2);

        System.out.println(votersService.findVoter(1).getVoteCount() + "first vote");

        votingAppService.castVote(1,3);

        System.out.println(votersService.findVoter(1).getVoteCount() + "here");


        // System.out.println(partyService.findParty(1).getVoteCount());
        assertEquals(2, partyService.findParty(1).getVoteCount());
    }
}