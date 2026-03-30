package juego;
//CTRL ALT L
//para alinear el berenjenal

public abstract class Player {

    private String name;
    private int attackPoints;
    private int defensePoints;
    private int life;

    /* Fase-1
    public Player() {
        System.out.println("Creamos Player: ");
    }*/

//Constructores

    public Player(String name, int attackPoints, int defensePoints, int life) {
        this.name = name;
        this.attackPoints = attackPoints;
        this.defensePoints = defensePoints;
        this.life = life;
    }


//Getters setters

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

    // otthers
    @Override
    public String toString() {
        return getName() + " PA:" + getAttackPoints() + " / PD:" + getDefensePoints() + " / PV:" + getLife();
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

}