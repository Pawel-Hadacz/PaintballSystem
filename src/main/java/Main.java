import Helper.Address;
import Helper.Experience;
import Helper.SocialStatus;
import Model.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        List<String> rules = new ArrayList<>();
        rules.add("Nie można przekraczać lini na arenie");
        Team t1 = new Team("Morsy","Niebieski");
        t1.setPlayersLeftInGame(5);
        Team t2 = new Team("Lwy","Czerwony");
        t2.setPlayersLeftInGame(0);

        // klasa abstrakcyjna i poliformizm
        Match openMatch = new OpenMatch("CXXAD2",50,"Gniezno",20);
        Match rankedMatch = new RankedMatch("OPKOPA",40,"Wola",Experience.AMATEUR,100);
        rankedMatch.addTeam(t1);
        rankedMatch.addTeam(t2);
        CustomMatch customMatch = new CustomMatch("JKHSC22",60,"Mura",rules);
        customMatch.setCurrentCondition("Zdobyta flaga");
        customMatch.setWinCondition("Zdobyta flaga");


        System.out.println(openMatch.finishMatch());
        System.out.println(rankedMatch.finishMatch());
        System.out.println(customMatch.finishMatch());

        //dziedziczenie wieloaspektowe
        Person person = new Person("546456", "Tomasz",24, SocialStatus.ADULT,"M");
        person.setIdentityCard(Optional.of("5465465464"));
        System.out.println(person);

        // overlapping
        Arena arena1 = new Arena("Ziemia", new Address("Moniuszki","Poznan","Polska","11-1111"),20,100,105,false);
        arena1.checkCustom();
        arena1.checkOpen();
        arena1.checkRanked();
        System.out.println(arena1);

    }
}
