package Model;

import javax.persistence.Entity;
import java.util.List;

@Entity
public class CustomMatch extends Match {

    private List<String> rules;
    private String winCondition;
    private String currentCondition;
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
}
