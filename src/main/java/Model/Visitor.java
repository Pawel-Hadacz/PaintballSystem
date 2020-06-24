package Model;

import Helper.SocialStatus;

import javax.persistence.Entity;

@Entity
public class Visitor extends Person {
   private int visitNumber;

    public Visitor(){

   }

    public Visitor(int visitNumber) {
        this.visitNumber = visitNumber;
    }

    public Visitor(String PESEL, String name, int age, SocialStatus socialStatus, String gender, int visitNumber) {
        super(PESEL, name, age, socialStatus, gender);
        this.visitNumber = visitNumber;
    }
    public int getVisitNumber() {
        return visitNumber;
    }

    public void setVisitNumber(int visitNumber) {
        this.visitNumber = visitNumber;
    }
}
