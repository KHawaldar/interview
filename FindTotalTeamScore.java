package org.example.football;


import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;

import java.net.URL;
import java.util.List;

public class FindTotalTeamScore {

    //get the data
    public InputStream fetchTheData()  {
        String url_str =
                "https://s3.eu-west-1.amazonaws.com/hackajob-assets1.p.hackajob/challenges/football_session/football.json";
        //Create the URL object
        InputStream inputStream = null;
        try {
            URL url = new URL(url_str);
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            inputStream = urlConnection.getInputStream();
        }catch(IOException ioException){
            ioException.printStackTrace();
        }
        return inputStream;
    }

    public int findTheScore(String team) throws IOException {
        InputStream jsonData = fetchTheData();
        //Deserialize the jsonData to Object
        FootballData footballData = null;
        try {
            ObjectMapper mapper = new ObjectMapper();
            footballData = mapper.readValue(jsonData, FootballData.class);
        }catch(Exception exception){

        }
        //pass to the method to get the total score
         return find(footballData.getRounds(), team);

    }
    public int find(List<Round> rounds, String team_name){

        return rounds.stream()
                .flatMap(round -> round.getMatches().stream())
                .filter(match -> match.getTeam1().getName().equalsIgnoreCase(team_name)
                                ||
                                match.getTeam2().getName().equalsIgnoreCase(team_name)

                        )
                .mapToInt(match -> {
                    if (match.getTeam1().getName().equalsIgnoreCase(team_name)) {
                        return match.getScore1();
                    }
                    else {
                        return match.getScore2();
                    }
                })
                .sum();
    }

    public static void main(String[] args) throws IOException {
        FindTotalTeamScore findTotalTeamScore = new FindTotalTeamScore();
        System.out.println(findTotalTeamScore.findTheScore("Newcastle United"));
    }
}