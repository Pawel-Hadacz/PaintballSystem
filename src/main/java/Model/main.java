package Model;

import Helper.Address;
import Helper.Experience;
import Helper.SocialStatus;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class main {
    public static void main(String[] args) {
                StandardServiceRegistry registry = null;
                SessionFactory sessionFactory = null;

                List<String> rules = new ArrayList<>();
                rules.add("Nie można przekraczać lini na arenie");
                Team t1 = new Team("Morsy","Niebieski");
                t1.setPlayersLeftInGame(5);
                Team t2 = new Team("Lwy","Czerwony");
                t2.setPlayersLeftInGame(0);

                // klasa abstrakcyjna i poliformizm
                Match openMatch = new OpenMatch("CXXAD2",50,"Gniezno",20);
                Match rankedMatch = new RankedMatch("OPKOPA",40,"Wola",Experience.AMATEUR,100);
                rankedMatch.addTeam(t1);
                rankedMatch.addTeam(t2);
                CustomMatch customMatch = new CustomMatch("JKHSC22",60,"Mura",rules);
                customMatch.setCurrentCondition("Zdobyta flaga");
                customMatch.setWinCondition("Zdobyta flaga");


                System.out.println(openMatch.finishMatch());
                System.out.println(rankedMatch.finishMatch());
                System.out.println(customMatch.finishMatch());

                //dziedziczenie wieloaspektowe
                Person person = new Person("546456", "Tomasz",24, SocialStatus.ADULT,"M");
                person.setIdentityCard("5465465464");
                System.out.println(person);

                // overlapping
                Arena arena1 = new Arena("Ziemia", new Address("Moniuszki","Poznan","Polska","11-1111"),20,100,105,false);
                arena1.checkCustom();
                arena1.checkOpen();
                arena1.checkRanked();
                System.out.println(arena1);

                Player player = new Player("6545645646","Tomasz",22, SocialStatus.ADULT,"Mężczyzna",5, Experience.AMATEUR);
                Player player2 = new Player("99999999999","Marian",22,SocialStatus.ADULT,"Mężczyzna",55, Experience.INTERMEDIATE);
                Marker marker1 = new Marker("Axel",22,50);
                Marker marker2 = new Marker("Witsel",11,35);
                Marker marker3 = new Marker("Mono",4,20);
                Marker marker4 = new Marker("Rabit",2,100);


                player.addMarker(marker1);// przykład użycia asocjacji binarnej
                player.addMarker(marker2);//
                player.addMarker(marker3); //
                System.out.println(marker1);
                marker1.setPlayer(player2);
                System.out.println(marker1);
                System.out.println(player);
                System.out.println(player2);

                try{
                    registry = new StandardServiceRegistryBuilder()
                            .configure()
                            .build();
                    sessionFactory = new MetadataSources(registry)
                            .buildMetadata()
                            .buildSessionFactory(); // utworzenie tabel
                    Session session = sessionFactory.openSession();
                    session.beginTransaction();
                    session.save(marker1);
                    session.save(player2);

                    session.getTransaction().commit();
                    session.close();

            } catch (Exception e) {
                    e.printStackTrace();
                    StandardServiceRegistryBuilder.destroy(registry);
                } finally {
                    if (sessionFactory != null) {
                        sessionFactory.close();
                    }
                }
                }
            }
