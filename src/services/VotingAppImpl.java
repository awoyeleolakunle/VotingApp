package services;

import data.model.Party;
import data.model.Voter;
import data.repository.PartyRepository;
import data.repository.PartyRepositoryImpl;
import data.repository.VotersRepository;
import data.repository.VotersRepositoryImpl;
import dtos.Response.PartyResponse;
import dtos.Response.VotersResponse;

public class VotingAppImpl implements VotingAppService{

    private static PartyService partyService = new PartyServiceImpl();
    private static PartyRepository partyRepository = new PartyRepositoryImpl();
    private static VotersService votersService = new VotersServiceImpl();
    private static Voter voter;
    private static Party party = new Party();
    private static PartyResponse response;

    private static VotersRepository votersRepository = new VotersRepositoryImpl();

    @Override
    public String castVote(int partyId, int votersRegNum){
       // verifyPartyAndVoter( partyId, votersRegNum);
        verifyVotersVoteCount(votersRegNum);

        partyService.voteCount(partyId);
        votersService.votersVoteCount(votersRegNum);
        response = new PartyResponse();
        response = partyService.findParty(partyId);
        response.setVoteCount(partyService.findParty(partyId).getVoteCount()+1);

        VotersResponse votersResponse = votersService.findVoter(votersRegNum);
        votersResponse.setVoteCount(votersService.findVoter(votersRegNum).getVoteCount()+1);

             return String.format("You voted for " +" "+ response.getName() );
        }

        private static void verifyPartyAndVoter(int partyId, int votersRegNum){
        if(partyService.findParty(partyId).getId()!= partyId &&
            votersService.findVoter(votersRegNum).getVoterRegistrationNumber()!=votersRegNum);
        throw new IllegalArgumentException("You entered invalid requirements or You've already voted");
        }

        private static void verifyVotersVoteCount(int votersRegNum){
        if(votersService.findVoter(votersRegNum).getVoteCount()>0)
            throw new IllegalArgumentException("You have already voted");
        }

}

