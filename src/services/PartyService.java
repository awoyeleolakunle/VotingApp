package services;

import data.model.Party;
import dtos.Request.PartyRegisterRequest;
import dtos.Response.PartyResponse;

public interface PartyService {
        PartyResponse registerParty(PartyRegisterRequest partyRegisterRequest);

        PartyResponse findParty(int partyId);

        int voteCount(int partyId);
}
