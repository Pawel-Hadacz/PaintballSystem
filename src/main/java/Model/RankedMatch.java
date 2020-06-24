package Model;

import Helper.Experience;

import javax.persistence.Entity;


@Entity
public class RankedMatch extends Match {
    private Experience levelRequired;
    private int maxAmmunitionAmount;

    public RankedMatch(String name, int duration, String localization, Experience levelRequired, int maxAmmunitionAmount) {
        super(name, duration, localization);
        this.levelRequired = levelRequired;
        this.maxAmmunitionAmount = maxAmmunitionAmount;
    }

    public Experience getLevelRequired() {
        return levelRequired;
    }

    public void setLevelRequired(Experience levelRequired) {
        this.levelRequired = levelRequired;
    }

    public int getMaxAmmunitionAmount() {
        return maxAmmunitionAmount;
    }

    public void setMaxAmmunitionAmount(int maxAmmunitionAmount) {
        this.maxAmmunitionAmount = maxAmmunitionAmount;
    }

    @Override
    public boolean finishMatch() { // polimorficzne wołanie metod
        for(Team t : super.getTeams()){
            if(t.getPlayersLeftInGame()==0){
                return true;
            }
        }
        return false;
    }
}
