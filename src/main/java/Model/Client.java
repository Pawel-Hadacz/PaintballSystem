package Model;

import Helper.SocialStatus;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;
@Entity
public class Client extends Person {

    @Id
    @GeneratedValue
    private Long clientId;
    @OneToMany
    private List<Rent> rents = new ArrayList<>(); // asocjacja z atrubutem
    String clientCode;

    public Client() {
    }

    public Client(String PESEL, String name, int age, SocialStatus socialStatus, String gender, String clientCode) {
        super(PESEL, name, age, socialStatus, gender);
        this.clientCode = clientCode;
    }


    public String getClientCode() {
        return clientCode;
    }

    public void setClientCode(String clientCode) {
        this.clientCode = clientCode;
    }

    public void addRent(Rent newRent) {
        if (!rents.contains(newRent)) {
            rents.add(newRent);
            newRent.setClient(this);
        }
    }

    public void removeRent(Rent rentToRemove) {
        if (!rents.contains(rentToRemove)) {
            rents.remove(rentToRemove);
        }
    }

    @Override
    public String toString() {
        StringBuilder info = new StringBuilder("Client: " + "\n");
        for (Rent rent : rents) {
            info.append("rent: ").append(rent).append("\n");
        }
        return info.toString();
    }
}
