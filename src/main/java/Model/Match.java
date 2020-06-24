package Model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Match { // klasa abstrakcyjna
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long matchId;
    private String name;
    private int duration;
    private String localization;
    private static List<Match> matches = new ArrayList<>();
  //  private List<Foul> fouls = new ArrayList<>();
    private static Set<Foul> allFouls = new HashSet<>();
    @OneToMany
    private List<Team> teams = new ArrayList<>();



    public Match(String name, int duration, String localization) {
        this.name = name;
        this.duration = duration;
        this.localization = localization;
    }
    private static void addMatch(Match match){
        matches.add(match);
    }
    private static void removeMatch(Match match){
        matches.remove(match);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getLocalization() {
        return localization;
    }

    public abstract boolean finishMatch(); // poliformizm

    public void setLocalization(String localization) {
        this.localization = localization;
    }

    public static List<Match> getMatches() {
        return matches;
    }

    public static void setMatches(List<Match> matches) {
        Match.matches = matches;
    }

//    public List<Foul> getFouls() {
//        return fouls;
//    }

//    public void setFouls(List<Foul> fouls) {
//        this.fouls = fouls;
//    }
//    public void addFoul(Foul foul) throws Exception {
//        if(!fouls.contains(foul)) {
//            if(allFouls.contains(foul)) {
//                throw new Exception("Ten faul został spowodowany w jakimś meczu");
//            }
//            fouls.add(foul);
//            allFouls.add(foul);
//        }
//    }
    public String toString() {
        String info = "Match{" +
                "name='" + name + '\''  + "}" + "\n";

//        for(Foul f : fouls){
//            info += " " + f.getName() + "\n";
//        }
        return info;
    }

    public Long getMatchId() {
        return matchId;
    }

    public void setMatchId(Long matchId) {
        this.matchId = matchId;
    }

    public List<Team> getTeams() {
        return teams;
    }

    public void setTeams(List<Team> teams) {
        this.teams = teams;
    }

    public void addTeam(Team newTeam){ // połączenie zwrotne
        if(!teams.contains(newTeam)){
            teams.add(newTeam);
        }
    }
    public void removeTeam(Team TeamToRemove){
        if(teams.contains(TeamToRemove)){
            teams.remove(TeamToRemove);
        }
    }


}
