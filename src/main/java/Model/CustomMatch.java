package Model;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class CustomMatch extends Match {

    private List<String> rules;
    private String winCondition;
    private String currentCondition;
    @OneToMany
    private List<Team> teams = new ArrayList<>();

    public CustomMatch(String name, int duration, String localization, List<String> rules) {
        super(name, duration, localization);
        this.rules = rules;
    }

    public String getWinCondition() {
        return winCondition;
    }

    public String getCurrentCondition() {
        return currentCondition;
    }

    public void setWinCondition(String winCondition) {
        this.winCondition = winCondition;
    }

    public void setCurrentCondition(String currentCondition) {
        this.currentCondition = currentCondition;
    }

    @Override
    public boolean finishMatch() { // polimorficzne wołanie metod
        if(currentCondition.equals(winCondition)){
            return true;
        }
        return false;
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
