package Model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Rent {
  //  private List<Client> clients = new ArrayList<>(); // asocjacja z atrubutem
   // private List<Arena> arenas = new ArrayList<>(); // asocjacja atrubutem

    private Arena arena; //
    private Client client;

    private LocalDate rentStart;
    private LocalDate rentEnd;
    private double cost;

    public Rent(LocalDate rentStart, LocalDate rentEnd) {
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

    public Client getClient() {
        return client;
    }
    public void setClient(Client client) {
        if(this.client!=null){
            this.client.removeRent(this);
       }
        client.addRent(this);
        this.client = client;
    }
 //   public void setRent(Rent rent) {
//
//    }

//    public void addClient(Client newClient) {
//        if (!clients.contains(newClient)) {
//            clients.add(newClient);
//            newClient.setRent(this);
//        }
//    }
//
//    public void removeClient(Client clientToRemove) {
//        if (clients.contains(clientToRemove)) {
//            clients.remove(clientToRemove);
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
//        for (Client client : clients) {
//            info.append("client: ").append(client.clientCode).append("\n");
//        }
//        return info.toString();
//    }

    @Override
    public String toString() {
        if(arena==null){
            return "Rent{" +
                    "arena= null"  +
                    ", client=" + client +
                    '}';

        }else if(client==null)
            return "Rent{" +
                    "arena= " +arena  +
                    ", client==null"  +
                    '}';

        else {
            return "Rent{" +
                    "arena=" + arena.getName()+
                    ", client=" + client.getName() +
                    '}';
        }
    }
}
