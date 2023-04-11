package dtos.Request;

public class VotersRegisterRequest {
    private String name;
    private int voterRegistrationNumber;

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

    @Override
    public String toString() {
        return "VotersRegisterRequest{" +
                "name='" + name + '\'' +
                ", voterRegistrationNumber=" + voterRegistrationNumber +
                '}';
    }
}
