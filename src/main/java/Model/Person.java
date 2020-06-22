package Model;

import Helper.SocialStatus;

import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Optional;

//@Entity
public class Person {
    @Id
    private String PESEL;

    private String name;
    private int age;
    @Enumerated
    private SocialStatus socialStatus; // dziedziczenie wieloaskpetkowe

    private Optional<String> identityCard = Optional.empty();
    private Optional<String> permissionSlip = Optional.empty();
    private String gender;


    public Person() {
    }

    public Person(String PESEL, String name, int age, SocialStatus socialStatus, String gender) {
        this.PESEL = PESEL;
        this.name = name;
        this.age = age;
        this.socialStatus = socialStatus;
        this.gender = gender;
    }



    public String getPESEL() {
        return PESEL;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    public Optional<String> getIdentityCard() {
        return identityCard;
    }

    public void setIdentityCard(Optional<String> identityCard) {
        this.identityCard = identityCard;
    }

    public Optional<String> getPermissionSlip() {
        return permissionSlip;
    }

    public void setPermissionSlip(Optional<String> permissionSlip) {
        this.permissionSlip = permissionSlip;
    }
    public boolean buyAlcohol(){
        if(socialStatus==SocialStatus.ADULT){
            return true;
        }
         return false;

    }
    public boolean allowToPlayRankedMatch(){
        if(socialStatus==SocialStatus.CHILD){
            return false;
        }
         return true;
    }

    @Override
    public String toString() {
        String isPermissionEmpty = permissionSlip.isEmpty() ? "To nie jest dziecko" : getPermissionSlip().get();
        String isIdentityEmpty = identityCard.isEmpty() ? "To nie jest dorosły" : getIdentityCard().get();
        return "Person{" +
                "PESEL='" + PESEL + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", socialStatus=" + socialStatus +
                ", identityCard=" + isIdentityEmpty +
                ", permissionSlip=" + isPermissionEmpty  +
                ", gender='" + gender + '\'' +
                '}';
    }
}
