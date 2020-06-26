package Controller;

import Config.DatabaseConfig;
import Helper.Address;
import Helper.SocialStatus;
import Model.Arena;
import Model.Person;
import Model.Rent;
import org.hibernate.Session;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.time.LocalDate;
import java.util.List;

public class ArenaController {
    private Session session = DatabaseConfig.getSession();
    private CriteriaBuilder builder = session.getCriteriaBuilder();

    public void rentArena(){

    }

    public void CreateArena(){

    }

    public List<Arena> findAllArenasCriteriaQuery() {
        CriteriaQuery<Arena> query = builder.createQuery(Arena.class);
        Root<Arena> root = query.from(Arena.class);
        query.select(root);
        TypedQuery<Arena> arenas = session.createQuery(query);
        return arenas.getResultList();
    }
    public void createSampleData(){
        Address waw = new Address("Lazienkowska", "Warszawa","Poland","01-234");
        Address krakow = new Address("Kościuszki", "Kraków","Poland","01-444");
        Arena arena = new Arena("Mone", waw,14,100,200,true);
        Arena arena2 = new Arena("Kome", krakow,200,200,200,false);
        Arena arena3 = new Arena("Ama", waw,350,105,145,true);
        Rent rent1 = new Rent("Wynajem1",LocalDate.of(2020,1,25),LocalDate.of(2020,1,26));
        Rent rent2 = new Rent("Wynajem2",LocalDate.of(2020,1,27),LocalDate.of(2020,1,28));
        Rent rent3 = new Rent("Wynajem3",LocalDate.of(2020,1,28),LocalDate.of(2020,1,29));
        Rent rent4 = new Rent("Wynajem4",LocalDate.of(2020,1,29),LocalDate.of(2020,1,30));
        Rent rent5 = new Rent("Wynajem5",LocalDate.of(2020,2,1),LocalDate.of(2020,1,2));
        Rent rent6 = new Rent("Wynajem6",LocalDate.of(2020,1,2),LocalDate.of(2020,1,3));
        arena.addRent(rent1);
        arena.addRent(rent2);
        arena.addRent(rent3);
        arena.addRent(rent4);
        arena2.addRent(rent5);
        arena2.addRent(rent6);
        Person p1 = new Person("546546545","Kasia",22, SocialStatus.ADULT,"Kobieta");

        session.beginTransaction();
        session.save(arena);
        session.save(rent1);
        session.save(rent2);
        session.save(rent3);
        session.save(rent4);
        session.save(arena2);
        session.save(rent5);
        session.save(rent6);
        session.save(p1);
        session.getTransaction().commit();

    }



}
