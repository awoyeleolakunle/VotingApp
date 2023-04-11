package utils;

import data.model.Party;
import dtos.Request.PartyRegisterRequest;

public class PartyMapper {

    public static Party map(PartyRegisterRequest partyRegisterRequest){
        Party party = new Party();
        party.setName(partyRegisterRequest.getName());
        return party;
    }
    public static void map(PartyRegisterRequest partyRegisterRequest, Party party) {
        party.setName(partyRegisterRequest.getName());
    }
}
