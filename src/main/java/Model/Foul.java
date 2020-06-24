package Model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
@Entity
public class Foul {
    @Id
    @GeneratedValue
    private Long foulId;
    private String name;
    private int timeOfFoul;
    private String importance;
    //@ManyToOne
   // private Match match;
    private static List<Foul> fouls = new ArrayList<>();

    public Foul() {
    }

    public Foul(Match match, String name, String importance, int timeOfFoul)  {
        this.name = name;
        this.timeOfFoul = timeOfFoul;
        this.importance = importance;
//        this.match = match;
//        fouls.add(this);

    }
//    public static Foul createFoul(Match match,String name,String importance,int timeofFoul) throws Exception{
//        if(match == null){
//            throw new Exception("Mecz nie istnieje");
//        }
//        Foul foul = new Foul(match,name, importance,timeofFoul );
//        match.addFoul(foul);
//        return foul;
//    }
//    private static void addFoul(Foul foul){
//        fouls.add(foul);
//    }
//    private static void remoeFoul(Foul foul){
//        fouls.remove(foul);
//    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTimeofFoul() {
        return timeOfFoul;
    }

    public void setTimeofFoul(int timeofFoul) {
        this.timeOfFoul = timeofFoul;
    }

    public String getImportance() {
        return importance;
    }

    public void setImportance(String importance) {
        this.importance = importance;
    }

//    public Match getMatch() {
//        return match;
//    }
//
//    public void setMatch(Match match) {
//        this.match = match;
//    }
    @Override
    public String toString() { // przesłonięcie metody toString
        return "Foul{" +
                "name='" + name;

    }

}
