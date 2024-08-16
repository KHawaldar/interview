package org.example.football;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Team {
    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
    @JsonProperty("key")
    String key;
    @JsonProperty("name")
    String name;
    @JsonProperty("code")
    String code;
    @JsonProperty("date")
    String date;
}
