package com.cricketcrickbuzz.dto;

import java.util.ArrayList;

public class List {
}

// import com.fasterxml.jackson.databind.ObjectMapper; // version 2.11.1
// import com.fasterxml.jackson.annotation.JsonProperty; // version 2.11.1
/* ObjectMapper om = new ObjectMapper();
Root root = om.readValue(myJsonString, Root.class); */
class AdDetail{
    public String name;
    public String layout;
    public int position;
}

class AppIndex{
    public String seoTitle;
    public String webURL;
}

class Filters{
    public ArrayList<String> matchType;
}

class Inngs1{
    public int inningsId;
    public int runs;
    public int wickets;
    public double overs;
}

class Match{
    public MatchInfo matchInfo;
    public MatchScore matchScore;
}

class MatchInfo{
    public int matchId;
    public int seriesId;
    public String seriesName;
    public String matchDesc;
    public String matchFormat;
    public String startDate;
    public String endDate;
    public String state;
    public String status;
    public Team1 team1;
    public Team2 team2;
    public VenueInfo venueInfo;
    public int currBatTeamId;
    public String seriesStartDt;
    public String seriesEndDt;
    public boolean isTimeAnnounced;
    public String stateTitle;
}

class MatchScore{
    public Team1Score team1Score;
    public Team2Score team2Score;
}

class Root{
    public ArrayList<TypeMatch> typeMatches;
    public Filters filters;
    public AppIndex appIndex;
    public String responseLastUpdated;
}

class SeriesAdWrapper{
    public int seriesId;
    public String seriesName;
    public ArrayList<Match> matches;
}

class SeriesMatch{
    public SeriesAdWrapper seriesAdWrapper;
    public AdDetail adDetail;
}

class Team1{
    public int teamId;
    public String teamName;
    public String teamSName;
    public int imageId;
}

class Team1Score{
    public Inngs1 inngs1;
}

class Team2{
    public int teamId;
    public String teamName;
    public String teamSName;
    public int imageId;
}

class Team2Score{
    public Inngs1 inngs1;
}

class TypeMatch{
    public String matchType;
    public ArrayList<SeriesMatch> seriesMatches;
}

class VenueInfo{
    public int id;
    public String ground;
    public String city;
    public String timezone;
}

