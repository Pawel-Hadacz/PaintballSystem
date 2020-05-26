package Model;

import Helper.Experience;
import Helper.SocialStatus;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Player extends Person{

    private Team team;
    private Map<String,Match> matchQualificator = new HashMap<>();
    private List<Marker> markers = new ArrayList<>(); //asocjacja binarna 1 - *, tutaj *
    private int matchesPlayed;
    private Experience experienceLvl;

    public Player(String PESEL, String name, int age, SocialStatus socialStatus, String gender, int matchesPlayed, Experience experienceLvl) {
        super(PESEL, name, age, socialStatus, gender);
        this.matchesPlayed = matchesPlayed;
        this.experienceLvl = experienceLvl;
    }

    public void addMarker(Marker newMarker){ // połączenie zwrotne
        if(!markers.contains(newMarker)){
            markers.add(newMarker);
            newMarker.setPlayer(this);
        }
    }
    public void removeMarker(Marker markerToRemove){
        if(markers.contains(markerToRemove)){
            markers.remove(markerToRemove);
        }
    }
    public void addMatchQualificator(Match newMatch){ //Asocjacja kwalifikowana
        if(!matchQualificator.containsKey(newMatch.getName())){
            matchQualificator.put(newMatch.getName(),newMatch);
            newMatch.addPlayer(this);
        }
    }
    public Map<String, Match> getMatchQualificator() {
        return matchQualificator;
    }

    public void setMatchQualificator(Map<String, Match> matchQualificator) {
        this.matchQualificator = matchQualificator;
    }
    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        if(this.team!=null){
            this.team.removePlayer(this);
        }
        team.addPlayer(this);
        this.team = team;

    }



    @Override
    public String toString() {
        StringBuilder info = new StringBuilder("Player: " + getName() + "\n");
        for(Marker marker : markers) {
            info.append(" ").append(marker.getName()).append("\n");
        }
        return info.toString();
    }
}
