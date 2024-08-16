package org.example.football;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Round {
    public List<Match> getMatches() {
        return matches;
    }

    public void setMatches(List<Match> matches) {
        this.matches = matches;
    }

    @JsonProperty(value = "matches")
    private List<Match> matches;
    @JsonProperty(value = "name")
    private String name;

}
