package Model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class Baggage {
    @Id
    @GeneratedValue
    private Long baggageId;
    private String setName;
    @ManyToOne
    private Person officeWorker;

    @OneToMany
    private List<Helmet> helmets = new ArrayList<>();

    public static Set<Helmet> allHelmets = new HashSet<>();

    public void addHelmet(Helmet helmet) throws Exception{
        if(helmets.contains(helmet)){
            if(allHelmets.contains(helmet)){
                throw new Exception("Kask jest już powiazany");
            }
            helmets.add(helmet);
            allHelmets.add(helmet);
        }
    }
    public Long getBaggageId() {
        return baggageId;
    }

    public void setBaggageId(Long baggageId) {
        this.baggageId = baggageId;
    }

    public String getSetName() {
        return setName;
    }

    public void setSetName(String setName) {
        this.setName = setName;
    }

    public List<Helmet> getHelmets() {
        return helmets;
    }

    public void setHelmets(List<Helmet> helmets) {
        this.helmets = helmets;
    }


}
