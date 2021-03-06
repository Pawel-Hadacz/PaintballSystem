package Model;

import Helper.Address;
import Helper.ArenaType;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;
import java.util.Set;

@Entity
public class  Arena { // overlapping) – spłaszczenie hierarchii
    private String name;
    private Address address;
    @Id
    @GeneratedValue
    private Long idArena;
    private int capacity;
    private int length;
    private int width;
    private static int reqLength = 105;
    private static int reqWidth = 100;
    private int minCapacity = 20;
    private int customObstacles = 0;
    private boolean isExperienceReq;

    @ElementCollection
    private List<String> requiredObstacles = new ArrayList<>();
    @OneToMany
    private List<Rent> rents = new ArrayList<>();

    @ElementCollection
    private Set<ArenaType> arenaTypes = EnumSet.of(ArenaType.ARENA);

    public Arena() {
    }

    public Arena(String name, Address address, int capacity, int length, int width, boolean isExperienceReq) {
        this.name = name;
        this.address = address;
        this.capacity = capacity;
        this.length = length;
        this.width = width;
        this.isExperienceReq = isExperienceReq;
    }

    public void addRent(Rent newRent) {
        if (!rents.contains(newRent)) {
        rents.add(newRent);
        newRent.setArena(this);
        }
    }


    public void removeRent(Rent rentToRemove) {
        if (!rents.contains(rentToRemove)) {
            rents.remove(rentToRemove);
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address adres) {
        this.address = address;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getWidth(
    ) {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void removeObstacle(String obstacle){
        if(!requiredObstacles.isEmpty() && requiredObstacles.contains(obstacle) ){
            requiredObstacles.remove(obstacle);
        }
    }
    public void addCustomObstacle(String customObstacle){
        requiredObstacles.add(customObstacle);
        customObstacles++;

    }
    public void checkRanked(){
        if(getWidth() == reqWidth && getLength()==reqLength){
            if(!arenaTypes.contains(ArenaType.RANKED)) {
                arenaTypes.add(ArenaType.RANKED);
            }
        }
    }
    public void checkCustom(){
        if(customObstacles>0){
            if(!arenaTypes.contains(ArenaType.CUSTOM)) {
                arenaTypes.add(ArenaType.CUSTOM);
            }
        }
    }
    public void checkOpen(){
        if(isExperienceReq==false){
            if(!arenaTypes.contains(ArenaType.OPEN)) {
                arenaTypes.add(ArenaType.OPEN);
            }
        }
    }

    public boolean isExperienceReq() {
        return isExperienceReq;
    }

    public void setExperienceReq(boolean experienceReq) {
        isExperienceReq = experienceReq;
    }

    public Set<ArenaType> getArenaTypes() {
        return arenaTypes;
    }

    public void setArenaTypes(EnumSet<ArenaType> arenaTypes) {
        this.arenaTypes = arenaTypes;
    }
    public List<String> getRequiredObstacles() {
        return requiredObstacles;
    }

    public void setRequiredObstacles(List<String> requiredObstacles) {
        this.requiredObstacles = requiredObstacles;
    }

    public List<Rent> getRents() {
        return rents;
    }

    public void setRents(List<Rent> rents) {
        this.rents = rents;
    }

    @Override
    public String toString() {
        return  name;
    }
}
