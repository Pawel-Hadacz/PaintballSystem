package Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Helmet {
    @Id
    @GeneratedValue
    private Long Id;
    private String name;
    @ManyToOne
    private Baggage baggage;

    public Helmet() {
    }

    public Helmet(String name, Baggage baggage) {
        this.name = name;
        this.baggage = baggage;
    }
    public Helmet createHelmet(Baggage baggage,String name) throws Exception{
        if(baggage == null){
            throw  new Exception("Nie ma takiego ekwpipuntku");
        }
        Helmet helmet = new Helmet(name, baggage);
        baggage.addHelmet(helmet);
        return helmet;
    }
}
