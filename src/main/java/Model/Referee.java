package Model;

import Helper.SocialStatus;

import javax.persistence.Entity;

@Entity
public class Referee extends Person {
    private String licence;
    private int matchNumber;

    public Referee() {
    }

    public Referee(String licence, int matchNumber) {
        this.licence = licence;
        this.matchNumber = matchNumber;
    }

    public Referee(String PESEL, String name, int age, SocialStatus socialStatus, String gender, String licence, int matchNumber) {
        super(PESEL, name, age, socialStatus, gender);
        this.licence = licence;
        this.matchNumber = matchNumber;
    }

    public Referee(String PESEL, String name, int age, SocialStatus socialStatus, String gender) {
        super(PESEL, name, age, socialStatus, gender);
    }
}
