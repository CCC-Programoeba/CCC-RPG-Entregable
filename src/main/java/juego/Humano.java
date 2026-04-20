// Humano.java
package juego;

public class Humano extends Player {
//=============== Atributos ===============

//=============== Constructores ===============

    public Humano(String name, int attackPoints, int defensePoints, int life) {
        super(name, attackPoints, defensePoints, life);

        if (this.getClass() == Humano.class && getLife() > 100) {
            setLife(100);
//System.out.print("Humano creado");
//=============== Getters y setters ===============

        }
    }
}