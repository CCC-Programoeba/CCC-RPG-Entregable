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
    private Item [] items;
    private int numItems;

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
        this.items = new Item[99];  //nº maximo de items en un jugador
        this.numItems = 0;          //Contador numItems++ segun vayamos añadiendo items al player
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

//Añadimos los items, aqui la defensa
    protected void hit(int attackPoints) {

        int masDef = 0;

        for (int i = 0; i < numItems; i++) {
            masDef = masDef + items[i].getDefenseBonus();
        }

        int defensaTotal = this.defensePoints + masDef;

        int damage = attackPoints - defensaTotal;

        if (damage < 0) {
            damage = 0;
        }

        int hpAntes = this.life;
        this.life = this.life - damage;

        if (this.life < 0) {
            this.life = 0;
        }

        System.out.println(this.name + " es golpeado con " + attackPoints
                + " puntos y se defiende con " + defensaTotal
                + ". HP: " + hpAntes + " - " + damage + " = " + this.life);
    }
//Aquie el ataque  de los items
    public void attack(Player p) {
        int masAtk = 0;
        /*for (Item item : items) {
            masAtk=item.getAttackBonus();
        }*/         //->si lo hago así me peta con un nullPointerException al llegar a un null
        for (int i = 0; i < numItems; i++) {
            masAtk = masAtk + items[i].getAttackBonus();
        }
        System.out.println("=====ANTES DEL ATAQUE=====");
        System.out.println("Atacante: " + getName() + " PA:" + getAttackPoints() + " / PD:" + getDefensePoints() + " / PV:" + getLife());
        System.out.println("Defensor: " + p.getName() + " PA:" + p.getAttackPoints() + " / PD:" + p.getDefensePoints() + " / PV:" + p.getLife());

        System.out.println("=====ATAQUE=====");

        int ataqueTotal = this.attackPoints + masAtk;
        p.hit(ataqueTotal);

        if (p.life > 0) {
            int masAtkDefensor = 0;

            for (int i = 0; i < p.numItems; i++) {
                masAtkDefensor = masAtkDefensor + p.items[i].getAttackBonus();
            }

            int ataqueTotalDefensor = p.attackPoints + masAtkDefensor;

            this.hit(ataqueTotalDefensor);
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
    public String toString() {
        String masestring = getName() + " PA:" + getAttackPoints() + " / PD:" + getDefensePoints() + " / PV:" + getLife()
                + " (pertenece a " + teams.size() + " equipos)";

        if (numItems > 0) {
            masestring = masestring + " tiene los items: \n";

            for (int i = 0; i < numItems; i++) {
                masestring = masestring + "- " + items[i].getName() + " AtkBonus:" + items[i].getAttackBonus()
                        + " / DefBonus:" + items[i].getDefenseBonus();
            }
        }

        return masestring;
    }

//===================== ITEMS =====================

    public void addItem(Item item) {
        this.items[numItems] = item;
        numItems++;
    }
    public void removeItem(Item item) {
        for (int i = 0; i < numItems; i++) {
            if (items[i] == item) {
                items[i] = items[numItems - 1];
                items[numItems - 1] = null;
                numItems--;
                return;
            }
        }
    }

//===================== EQUALS =====================

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