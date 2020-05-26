package Model;

import java.util.List;

public class Team {
    
    private List<Player> players;
    private String name;
    private String colour;
    private int playersLeftInGame;



    public Team(String name, String colour) {
        this.name = name;
        this.colour = colour;
    }

    public void addPlayer(Player newPlayer){ // połączenie zwrotne
        if(!players.contains(newPlayer)){
            players.add(newPlayer);
            newPlayer.setTeam(this);
        }
    }
    public void removePlayer(Player PlayerToRemove){
        if(players.contains(PlayerToRemove)){
            players.remove(PlayerToRemove);
        }
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColour() {
        return colour;
    }
    public int getPlayersLeftInGame() {
        return playersLeftInGame;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }
    public void setPlayersLeftInGame(int playersLeftInGame) {
        this.playersLeftInGame = playersLeftInGame;
    }
}
