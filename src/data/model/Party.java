package data.model;

public class Party {
    private String name;
    private int id;
    private int voteCount;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getVoteCount() {
        return voteCount;
    }

    public void setVoteCount(int voteCount) {
        this.voteCount = voteCount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Party{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", voteCount=" + voteCount +
                '}';
    }
}
