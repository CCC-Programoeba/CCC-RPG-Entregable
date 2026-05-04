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
        if (attackPoints > 5) {
            super.hit(attackPoints);
        } else {
            System.out.println(getName() + " no le ha ehcho na");
        }
    }

}