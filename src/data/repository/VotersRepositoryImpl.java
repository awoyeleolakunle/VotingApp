package data.repository;

import data.model.Voter;

import java.util.ArrayList;
import java.util.List;

public class VotersRepositoryImpl implements VotersRepository{

    private int count;
    List<Voter> voters = new ArrayList<>();
    @Override
    public Voter saveVoter(Voter voter) {
        boolean votersHasNotRegister = voter.getVoterRegistrationNumber()==0;
        if (votersHasNotRegister){
            voter.setVoterRegistratioNumber(generateRegistrationNumber());
            voters.add(voter);
            count++;
        }
        return voter;
    }

    private int generateRegistrationNumber() {
        return count+1;
    }

    @Override
    public Voter findVoterByVoterRegistrationNumber(int votersRegistrationNumber) {
        for (Voter voter: voters) {
            if (voter.getVoterRegistrationNumber()== votersRegistrationNumber)
                return voter;
        }
        return null;
    }

    @Override
    public void deleteVoterByVoterRegistrationNumber(int voterRegistrationNumber) {
        for (Voter voter: voters) {
            if(voter.getVoterRegistrationNumber()==voterRegistrationNumber)
                voters.remove(voter);
            count--;
        }
    }

    @Override
    public void deleteAllVoters() {
        voters.removeAll(voters);
        count = voters.size();
        }

    @Override
    public int countTotalVoters() {
        return count;
    }

    @Override
    public List<Voter> findAllVoters() {
        return voters;
    }

}
