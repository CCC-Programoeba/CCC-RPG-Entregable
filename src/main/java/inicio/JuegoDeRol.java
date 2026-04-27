package inicio;//CTRL ALT L
//para alinear el berenjenal
//Recorda afegir al professor com a col·laborador:
//
//usuari: joange
//
//email:jgcamarena@ieseljust.com

import juego.*;
import util.Funcionetes;

public class JuegoDeRol {
    //FASE 01
    public static void provaFase1() {
        System.out.println("Fase 01, terminada");
        /*
        Humano humano01 = new Humano("Carlos", 30, 10, 100);
        Alien alien01 = new Alien("HermenegildoBraulioJosé", 40, 5, 100);
        Tanque tanque01 = new Tanque("Anselmo el Gordo", 20, 15, 200);
        */
    }

    //FASE 02
    public static void provaFase2() {
        System.out.println("Fase 2, terminada");
        /*
        Humano humano01 = new Humano("Carlos", 30, 10, 100);
        Alien alien01 = new Alien("HermenegildoBraulioJosé", 40, 5, 100);
        Tanque tanque01 = new Tanque("Anselmo el Gordo", 20, 15, 200);

        System.out.println(humano01);
        System.out.println(alien01);
        System.out.println(tanque01);

        humano01.attack(alien01);
        alien01.attack(tanque01);
        tanque01.attack(humano01);
        */
    }

    public static void provaFase3() {

        System.out.println("Fase 03, terminada");
/*
        Humano humano01 = new Humano("Carlos", 30, 10, 100);
        Alien alien01 = new Alien("HermenegildoBraulioJosé", 40, 5, 100);
        Warrior warrior01 = new Warrior("Anselmo el Gordo", 20, 15, 200);

        System.out.println(humano01);
        System.out.println(alien01);
        System.out.println(warrior01);

        humano01.attack(alien01);
        alien01.attack(warrior01);
        warrior01.attack(humano01);
*/
    }

    public static void provaFase4() {
        System.out.println("Fase 04, terminada.");
/*
            // Jugadores
        Humano humano01 = new Humano("Carlos", 30, 10, 100);
        Alien alien01 = new Alien("HermenegildoBraulioJosé", 40, 5, 100);
        Warrior warrior01 = new Warrior("Anselmo el Gordo", 20, 15, 200);
        Humano humano02 = new Humano("Carlos", 30, 10, 100); // Igual a humano01
            //Equipos
        Team equip01 = new Team("EQ 01");
        Team equip02 = new Team("EQ 02");
        Team equip03 = new Team("EQ 01.2");

        System.out.println("Equipoos");
        System.out.println(equip01);
        System.out.println(equip02);
            //Cada jugador en us equipo
        equip01.addPlayer(humano01);
        equip01.addPlayer(alien01);
        equip02.addPlayer(warrior01);
        equip02.addPlayer(alien01);

        System.out.println(equip01);
        System.out.println(equip02);
            //Cosas con el alien
        System.out.println("Quito alien01 DE equip01: ");
        equip01.removePlayer(alien01);
        System.out.println(equip01);
        System.out.println("alien01 ahora es del equipos: " + alien01.getTeams().size());
        System.out.println(alien01);

        System.out.println("EQUALS de Player");
        System.out.println("humano01.equals(humano02)?" + humano01.equals(humano02));
        System.out.println("humano01.equals(alien01) ?" + humano01.equals(alien01));
        System.out.println("humano01.equals(humano01)?" + humano01.equals(humano01));

        System.out.println("EQUALS de Team");
        System.out.println("equip01.equals(equip01)" + equip01.equals(equip01));
        System.out.println("equip01.equals(equip02): " + equip01.equals(equip02));
        System.out.println("equip01.equals(equip03): " + equip01.equals(equip03));
*/
    }

    public static void provaFase5() {
        System.out.println("Fase 05");
        // Jugadores
        Humano humano01 = new Humano("Carlos", 30, 10, 100);
        Alien alien01 = new Alien("HermenegildoBraulioJosé", 40, 5, 100);
        Warrior warrior01 = new Warrior("Anselmo el Gordo", 20, 15, 200);
        Humano humano02 = new Humano("Krakatonio", 30, 10, 100);

        // Items
        Item revolver = new Item("Revolver", 2, 0);
        Item chaleco = new Item("Chaleco", 0, 1);

        humano01.addItem(revolver);
        humano02.addItem(chaleco);

        System.out.println(humano01);
        System.out.println(humano02);

        humano01.attack(alien01);
        humano02.attack(warrior01);
    }

    public static void provaFase6() {
        System.out.println("Nada aún");
    }

    public static void provaFase7() {
        System.out.println("Nada aún");
    }

    public static void main(String[] args) {
        int opcion;
        System.out.println("====================");
        System.out.println("=   JUEGO DE ROL   =");
        System.out.println("====================");
        do {
            opcion = Funcionetes.leerInt("\nElige fase (del 1 al 7), 0 para SALIR: ");
            switch (opcion) {
                case 1: {
                    provaFase1();
                }
                break;
                case 2: {
                    provaFase2();
                }
                break;
                case 3: {
                    provaFase3();
                }
                break;
                case 4: {
                    provaFase4();
                }
                break;
                case 5: {
                    provaFase5();
                }
                break;
                case 6: {
                    provaFase6();
                }
                break;
                case 7: {
                    provaFase7();
                }
                break;
                case 0: {
                    System.out.println("ADIOS");
                }
                break;
            }
        } while (opcion != 0);


    }
}