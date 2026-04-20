package juego;

import java.util.ArrayList;

public class Team {
    //=============== Atributos ===============

    private String name;
    private ArrayList<Player> players;

    //=============== Constructores ===============

    public Team() {
        this.players = new ArrayList<>();
    }

    public Team(String name) {
        this.name = name;
        this.players = new ArrayList<>();
    }

    //=============== Getters y Setters ===============

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }

    public void setPlayers(ArrayList<Player> players) {
        this.players = players;
    }

    //=============== Métodos ===============

    public void addPlayer(Player p) {
        if (!players.contains(p)) {
            players.add(p);
        }
    }

    public void removePlayer(Player p) {
        players.remove(p);
    }

    @Override
    public String toString() {
        String res = "Equipo " + name + ":\n";

        for (Player p : players) {      //Fori compacto
            res += p.toString() + "\n";
        }

        return res;
    }

    @Override
    public boolean equals(Object ekipo) {
        if (this == ekipo) return true;
        if (ekipo instanceof Team == false) return false;

        Team otherTeam = (Team) ekipo;

        if (name == null) {
            if (otherTeam.name != null) return false;
        } else {
            if (name.equals(otherTeam.name) == false) {
                return false;
            }
        }

        return players.equals(otherTeam.players);
    }
}