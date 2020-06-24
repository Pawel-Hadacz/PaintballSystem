package Model;


import Helper.PersonType;
import Helper.SocialStatus;

import javax.persistence.*;

import java.util.*;

@Entity
public class Person {
    @Id
    private String PESEL;
    private String name;
    private int age;
    @Enumerated
    private SocialStatus socialStatus; // dziedziczenie wieloaskpetkowe
    @OneToMany
    private List<Rent> rents = new ArrayList<>(); // asocjacja z atrubutem
    private String clientCode; // atrybut klienta
    private double salary; // atrybut pracownika
    private String employeeCode; // atrybut pracownika
    private String identityCard;
    private String permissionSlip;
    private String gender;



    @ElementCollection
    private Set<PersonType> arenaTypes = EnumSet.of(PersonType.PERSON);


    public Person() {
    }

    public Person(String PESEL, String name, int age, SocialStatus socialStatus, String gender) {
        this.PESEL = PESEL;
        this.name = name;
        this.age = age;
        this.socialStatus = socialStatus;
        this.gender = gender;
    }
    public void addRent(Rent newRent) {
        if (!rents.contains(newRent)) {
            rents.add(newRent);
            newRent.setPerson(this);
        }
    }

    public void removeRent(Rent rentToRemove) {
        if (!rents.contains(rentToRemove)) {
            rents.remove(rentToRemove);

        }
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

    public String getIdentityCard() {
        return identityCard;
    }

    public void setIdentityCard(String identityCard) {
        this.identityCard = identityCard;
    }

    public String getPermissionSlip() {
        return permissionSlip;
    }

    public void setPermissionSlip(String permissionSlip) {
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
    public void setPESEL(String PESEL) {
        this.PESEL = PESEL;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public SocialStatus getSocialStatus() {
        return socialStatus;
    }

    public void setSocialStatus(SocialStatus socialStatus) {
        this.socialStatus = socialStatus;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Set<PersonType> getArenaTypes() {
        return arenaTypes;
    }

    public void setArenaTypes(Set<PersonType> arenaTypes) {
        this.arenaTypes = arenaTypes;
    }

    @Override
    public String toString() {
        return "Person{" +
                "PESEL='" + PESEL + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", socialStatus=" + socialStatus +
                ", identityCard=" +
                ", permissionSlip=" +
                ", gender='" + gender + '\'' +
                '}';
    }
}
