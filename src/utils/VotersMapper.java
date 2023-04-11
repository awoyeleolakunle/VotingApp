package utils;

import data.model.Voter;
import dtos.Request.VotersRegisterRequest;

public class VotersMapper {


    public static Voter map(VotersRegisterRequest votersRegisterRequest){
      Voter voter = new Voter();
      voter.setName(votersRegisterRequest.getName());
      return voter;
    }
    public static void map(VotersRegisterRequest votersRegisterRequest, Voter voter) {
        voter.setName(votersRegisterRequest.getName());
    }
}
