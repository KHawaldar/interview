package org.example.football;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class FootballData {
    public List<Round> getRounds() {
        return rounds;
    }

    public void setRounds(List<Round> rounds) {
        this.rounds = rounds;
    }
    @JsonProperty("rounds")
    private List<Round> rounds;
    @JsonProperty("name")
    private String name;

}
