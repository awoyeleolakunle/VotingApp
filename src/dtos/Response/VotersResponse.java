package dtos.Response;

public class VotersResponse {
    private String name;
    private int voterRegistrationNumber;
    private int voteCount;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getVoterRegistrationNumber() {
        return voterRegistrationNumber;
    }

    public void setVoterRegistrationNumber(int voterRegistrationNumber) {
        this.voterRegistrationNumber = voterRegistrationNumber;
    }

    public int getVoteCount() {
        return voteCount;
    }

    public void setVoteCount(int voteCount) {
        this.voteCount = voteCount;
    }

    @Override
    public String toString() {
        return "VotersResponse{" +
                "name='" + name + '\'' +
                ", voterRegistrationNumber=" + voterRegistrationNumber +
                ", voteCount=" + voteCount +
                '}';
    }
}
