package Model;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class OfficeWorker extends Person {
    @OneToMany
    private List<Baggage> baggageList = new ArrayList<>();
    public OfficeWorker() {
    }

}
