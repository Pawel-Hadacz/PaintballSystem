package Model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
@Entity
public class Rent {
  //  private List<person> persons = new ArrayList<>(); // asocjacja z atrubutem
   // private List<Arena> arenas = new ArrayList<>(); // asocjacja atrubutem
    @ManyToOne
    private Arena arena;
    @ManyToOne
    private Person person;
    @Id
    @GeneratedValue
    private Long rentId;
    private String name;
    private LocalDate rentStart;
    private LocalDate rentEnd;
    private double cost;

    public Rent() {
    }

    public Long getRentId() {
        return rentId;
    }

    public void setRentId(Long rentId) {
        this.rentId = rentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return  name;
    }

    public LocalDate getRentStart() {
        return rentStart;
    }

    public void setRentStart(LocalDate rentStart) {
        this.rentStart = rentStart;
    }

    public LocalDate getRentEnd() {
        return rentEnd;
    }

    public void setRentEnd(LocalDate rentEnd) {
        this.rentEnd = rentEnd;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public Rent(String name, LocalDate rentStart, LocalDate rentEnd) {
        this.name = name;
        this.rentStart = rentStart;
        this.rentEnd = rentEnd;
    }

    public Arena getArena() {
        return arena;
    }

    public void setArena(Arena arena) {
        if(this.arena!=null){
            this.arena.removeRent(this);
        }
        arena.addRent(this);
        this.arena = arena;
    }

    public Person getPerson() {
        return person;
    }
    public void setPerson(Person person) {
        if(this.person!=null){
            this.person.removeRent(this);
       }
        person.addRent(this);
        this.person = person;
    }
 //   public void setRent(Rent rent) {
//
//    }

//    public void addperson(person newperson) {
//        if (!persons.contains(newperson)) {
//            persons.add(newperson);
//            newperson.setRent(this);
//        }
//    }
//
//    public void removeperson(person personToRemove) {
//        if (persons.contains(personToRemove)) {
//            persons.remove(personToRemove);
//        }
//    }
//
//
//    public void addArena(Arena newArena) {
//        if (!arenas.contains(newArena)) {
//            arenas.add(newArena);
//            newArena.setRent(this);
//        }
//    }
//
//    public void removeArena(Arena arenaToRemove) {
//        if (!arenas.contains(arenaToRemove)) {
//            arenas.remove(arenaToRemove);
//        }
//    }

//    @Override
//    public String toString() {
//        StringBuilder info = new StringBuilder("Rent: " + "\n");
//        for (Arena arena : arenas) {
//            info.append("arena: ").append(arena.getName()).append("\n");
//        }
//        for (person person : persons) {
//            info.append("person: ").append(person.personCode).append("\n");
//        }
//        return info.toString();
//    }


}
