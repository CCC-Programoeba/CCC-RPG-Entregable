package juego;

public class Warrior extends Humano {
//=============== Atributos ===============

    //=============== Constructores ===============
    public Warrior(String name, int attackPoints, int defensePoints, int life) {
        super(name, attackPoints, defensePoints, life);
    }

//=============== Getters y Setters ===============

//=============== Metodos ===============
    @Override
    protected void hit(int attackPoints) {

        int damage = attackPoints - getDefensePoints();

        if (damage <= 5) {
            damage = 0;
        }

        if (damage < 0) {
            damage = 0;
        }

        int hpAntes = getLife();

        setLife(getLife() - damage);

        if (getLife() < 0) {
            setLife(0);
        }

        System.out.println(getName() + " es golpeado con " + attackPoints
                + " puntos y se defiende con " + getDefensePoints()
                + ". HP: " + hpAntes + " - " + damage + " = " + getLife());
    }
    //System.out.print(", Clase Tanque\n");

}