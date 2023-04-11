package services;

import dtos.Request.VotersRegisterRequest;
import dtos.Response.VotersResponse;

public interface VotersService {

    VotersResponse registerVoter(VotersRegisterRequest votersRegisterRequest);
    VotersResponse findVoter(int voterRegistrationNumber);

    int votersVoteCount(int voterRegNum);
}
