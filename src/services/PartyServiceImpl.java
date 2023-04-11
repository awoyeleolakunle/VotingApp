package services;

import data.model.Party;
import data.repository.PartyRepository;
import data.repository.PartyRepositoryImpl;
import dtos.Request.PartyRegisterRequest;
import dtos.Response.PartyResponse;
import utils.PartyMapper;

public class PartyServiceImpl implements PartyService {
    private static Party party;
    private static PartyRepository partyRepository = new PartyRepositoryImpl();
    private static PartyResponse response;

    @Override
    public PartyResponse registerParty(PartyRegisterRequest partyRegisterRequest) {
        party = new Party();
        PartyMapper.map(partyRegisterRequest, party);
        partyRepository.saveParty(party);
        System.out.println(partyRepository.saveParty(party) + " i'm registered here first");
        System.out.println(partyRepository.findPartyById(party.getId()) + " am I registered");
        response = new PartyResponse();
        response.setName(party.getName());
        response.setId(party.getId());
        response.setVoteCount(party.getVoteCount());
        return response;
    }

    @Override
    public PartyResponse findParty(int partyId) {
       validateParty(partyId);
        party = partyRepository.findPartyById(partyId);
            response = new PartyResponse();
            response.setName(party.getName());
            response.setId(party.getId());
            response.setVoteCount(party.getVoteCount());
            return response;
    }

    @Override
    public int voteCount(int  partyId) {
       party = partyRepository.findPartyById(partyId);
       party.setVoteCount(party.getVoteCount()+1);
        return party.getVoteCount();
    }

    private static void validateParty(int partyId){
        if (partyRepository.findPartyById(partyId)
                .getId()!=partyId)
            throw new IllegalArgumentException("Party Not Found");
    }

}
