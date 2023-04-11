package dtos.Response;

import data.model.Party;

public class PartyResponse {
    private String name;
    private int id;
    private int voteCount;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getVoteCount() {
        return voteCount;
    }

    public void setVoteCount(int voteCount) {
        this.voteCount =voteCount;
    }

    @Override
    public String toString() {
        return "PartyResponse{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", voteCount=" + voteCount +
                '}';
    }
}
