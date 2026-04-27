package juego;

public class Humano extends Player {
//=============== Atributos ===============

//=============== Constructores ===============

    public Humano(String name, int attackPoints, int defensePoints, int life) {
        //System.out.print("Humano creado");
        super(name, attackPoints, defensePoints, life);

        if (this.getClass() == Humano.class && getLife() > 100) {
            setLife(100);
        }
    }

//=============== Getters y setters ===============


//=============== Funciones ===============

}