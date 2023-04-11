package data.model;

public class Voter {
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

    public void setVoterRegistratioNumber(int votersRegNum) {
        this.voterRegistrationNumber = votersRegNum;
    }
    public void setVoteCount(int voteCount) {
        this.voteCount = voteCount;
    }

    public int getVoteCount() {
        return voteCount;
    }

    @Override
    public String toString() {
        return "Voter{" +
                "name='" + name + '\'' +
                ", voterRegistrationNumber=" + voterRegistrationNumber +
                ", voteCount=" + voteCount +
                '}';
    }
}



