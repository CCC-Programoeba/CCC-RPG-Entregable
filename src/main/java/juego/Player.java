package juego;
//CTRL ALT L
//para alinear el berenjenal

import java.util.ArrayList;

public abstract class Player {
    //=============== Atributos ===============
    private String name;
    private int attackPoints;
    private int defensePoints;
    private int life;
    private ArrayList<Team> teams;

    /* Fase-1
    public Player() {
        System.out.println("Creamos Player: ");
    }*/

//=============== Constructores ===============

    public Player(String name, int attackPoints, int defensePoints, int life) {
        this.name = name;
        this.attackPoints = attackPoints;
        this.defensePoints = defensePoints;
        this.life = life;
        this.teams = new ArrayList<>();
    }


//=============== Getters setters ===============

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAttackPoints() {
        return attackPoints;
    }

    public void setAttackPoints(int attackPoints) {
        this.attackPoints = attackPoints;
    }

    public int getDefensePoints() {
        return defensePoints;
    }

    public void setDefensePoints(int defensePoints) {
        this.defensePoints = defensePoints;
    }

    public int getLife() {
        return life;
    }

    public void setLife(int life) {
        this.life = life;
    }

    public ArrayList<Team> getTeams() {
        return teams;
    }

    public void setTeams(ArrayList<Team> teams) {
        this.teams = teams;
    }

    // otthers
    @Override
    public String toString() {
        return getName() + " PA:" + getAttackPoints() + " / PD:" + getDefensePoints() + " / PV:" + getLife()
                + " (pertenece a " + teams.size() + " equipos)";
    }

    protected void hit(int attackPoints) {
        int damage = attackPoints - this.defensePoints;

        if (damage < 0) {
            damage = 0;
        }

        int hpAntes = this.life;
        this.life = this.life - damage;

        if (this.life < 0) {
            this.life = 0;
        }

        System.out.println(this.name + " es golpeado con " + attackPoints
                + " puntos y se defiende con " + this.defensePoints
                + ". HP: " + hpAntes + " - " + damage + " = " + this.life);
    }

    public void attack(Player p) {
        System.out.println("=====ANTES DEL ATAQUE=====");
        System.out.println("Atacante: " + getName() + " PA:" + getAttackPoints() + " / PD:" + getDefensePoints() + " / PV:" + getLife());
        System.out.println("Defensor: " + p.getName() + " PA:" + p.getAttackPoints() + " / PD:" + p.getDefensePoints() + " / PV:" + p.getLife());

        System.out.println("=====ATAQUE=====");
        p.hit(this.attackPoints);

        if (p.life > 0) {
            this.hit(p.attackPoints);
        }

        System.out.println("=====DESPUÉS DEL ATAQUE=====");
        System.out.println("Atacante: " + getName() + " PA:" + getAttackPoints() + " / PD:" + getDefensePoints() + " / PV:" + getLife());
        System.out.println("Defensor: " + p.getName() + " PA:" + p.getAttackPoints() + " / PD:" + p.getDefensePoints() + " / PV:" + p.getLife());
    }

    public void addTeam(Team t) {
        if (teams.contains(t) == false) {
            teams.add(t);
        }
    }

    public void removeTeam(Team t) {
        teams.remove(t);
    }

    @Override
    public boolean equals(Object jugador) {
        if (this == jugador) return true;
        if (jugador instanceof Player == false) return false;

        Player other = (Player) jugador;

        if (name == null) {
            if (other.name != null) return false;
        } else {
            if (name.equals(other.name) == false) {
                return false;
            }
        }

        if (attackPoints != other.attackPoints) return false;
        if (defensePoints != other.defensePoints) return false;
        if (life != other.life) return false;

        return true;
    }

}