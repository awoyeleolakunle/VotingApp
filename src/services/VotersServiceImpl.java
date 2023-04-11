package services;

import data.model.Voter;
import data.repository.VotersRepository;
import data.repository.VotersRepositoryImpl;
import dtos.Request.VotersRegisterRequest;
import dtos.Response.VotersResponse;
import utils.VotersMapper;

public class VotersServiceImpl implements VotersService{
    static Voter voter;
    static VotersRepository votersRepository = new VotersRepositoryImpl();
    @Override
    public VotersResponse registerVoter(VotersRegisterRequest votersRegisterRequest) {
        voter = new Voter();
        VotersMapper.map(votersRegisterRequest, voter);
        votersRepository.saveVoter(voter);
        VotersResponse response = new VotersResponse();
        response.setName(voter.getName());
        response.setVoterRegistrationNumber(voter.getVoterRegistrationNumber());

        return response;
    }

    @Override
    public VotersResponse findVoter(int voterRegistrationNumber) {
        validateVoter(voterRegistrationNumber);
            voter = votersRepository.findVoterByVoterRegistrationNumber(voterRegistrationNumber);
            VotersResponse response = new VotersResponse();
            response.setName(voter.getName());
            response.setVoterRegistrationNumber(voter.getVoterRegistrationNumber());
            response.setVoteCount(voter.getVoteCount());
            return response;

    }

    public int votersVoteCount(int voterRgNum){
        voter =votersRepository.findVoterByVoterRegistrationNumber(voterRgNum);
        voter.setVoteCount(voter.getVoteCount()+1);
        return voter.getVoteCount();
    }

    private static void validateVoter(int voterRegistrationNumber){
        if (votersRepository.findVoterByVoterRegistrationNumber(voterRegistrationNumber)
                .getVoterRegistrationNumber()!=voterRegistrationNumber)
            throw new IllegalArgumentException("Voter Not Found");
    }
}
