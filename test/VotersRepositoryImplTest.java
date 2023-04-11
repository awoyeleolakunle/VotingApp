import data.model.Voter;
import data.repository.VotersRepository;
import data.repository.VotersRepositoryImpl;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VotersRepositoryImplTest {

    private VotersRepository votersRepository = new VotersRepositoryImpl();
    private Voter voter;

    @Test
    public void saveOneVoter_CountIsOne(){
     voter = new Voter();
        assertEquals(1, votersRepository.countTotalVoters());
    }
    @Test
    public void findVoterById(){
        voter = new Voter();
        votersRepository.saveVoter(voter);
        votersRepository.findVoterByVoterRegistrationNumber(voter.getVoterRegistrationNumber());
        assertEquals(voter, votersRepository.findVoterByVoterRegistrationNumber(voter.getVoterRegistrationNumber()));

    }
    @Test
    public void voterCanBeDeletedTest(){
        voter = new Voter();
        votersRepository.saveVoter(voter);
        Voter newVoter = new Voter();
        votersRepository.saveVoter(newVoter);
        votersRepository.deleteVoterByVoterRegistrationNumber(voter.getVoterRegistrationNumber());
        assertEquals(1, votersRepository.countTotalVoters());
    }
@Test
    public void allVotersCanBeDeleted(){
        voter = new Voter();
        Voter newVote = new Voter();
        votersRepository.saveVoter(voter);
        votersRepository.saveVoter(newVote);
        votersRepository.deleteAllVoters();
        assertEquals(0, votersRepository.countTotalVoters());
}
@Test
public void findAllVotersTest(){
    voter = new Voter();
    Voter newVote = new Voter();
    votersRepository.saveVoter(voter);
    votersRepository.saveVoter(newVote);
    System.out.println(votersRepository.findAllVoters());
    assertEquals(2, votersRepository.countTotalVoters());
}

}