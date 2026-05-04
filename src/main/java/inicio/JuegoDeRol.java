package inicio;//CTRL ALT L
//para alinear el berenjenal
//Recorda afegir al professor com a col·laborador:
//
//usuari: joange
//
//email:jgcamarena@ieseljust.com

import juego.*;
import util.Funcionetes;
import java.util.ArrayList;
import java.util.Random;

public class JuegoDeRol {
    // atrbts fase 6
    static ArrayList<Player> jugadores = new ArrayList<>();
    static int vidaInicial = 100;
    static ArrayList<Item> objetos = new ArrayList<>();
    static ArrayList<Team> equipos = new ArrayList<>();
// metodos Fase 06
//MENUSES JUFADORES=====================================================

    public static void crearJugador() {
    char tipo = Funcionetes.leerChar("Tipo de jugador A-Alien, W-Warrior, P-Persona: ");
    String nombre = Funcionetes.leerString("Nombre del jugador: ");

    int puntosAtaque;
    do {
        puntosAtaque = Funcionetes.leerInt("Puntos de ataque entre 1 y 100: ");
    } while (puntosAtaque < 1 || puntosAtaque > 100);

    int puntosDefensa = 100 - puntosAtaque;

    Player jugadorNuevo;

    if (tipo == 'A' || tipo == 'a') {
        jugadorNuevo = new Alien(nombre, puntosAtaque, puntosDefensa, vidaInicial);
    } else if (tipo == 'W' || tipo == 'w') {
        jugadorNuevo = new Warrior(nombre, puntosAtaque, puntosDefensa, vidaInicial);
    } else {
        jugadorNuevo = new Humano(nombre, puntosAtaque, puntosDefensa, vidaInicial);
    }

    if (jugadores.contains(jugadorNuevo)) {
        System.out.println("Ese jugador ya existe");
    } else {
        jugadores.add(jugadorNuevo);
        System.out.println("Jugador creado");
    }
}

    public static void mostrarJugadores() {
        if (jugadores.isEmpty()) {
            System.out.println("No hay jugadores");
        } else {
            for (Player jugador : jugadores) {
                System.out.println(jugador);
            }
        }
    }

    public static void borrarJugador() {
        String nombre = Funcionetes.leerString("Nombre del jugador a borrar: ");

        for (int i = 0; i < jugadores.size(); i++) {
            if (jugadores.get(i).getName().equals(nombre)) {
                jugadores.remove(i);
                System.out.println("Jugador borrado");
                return;
            }
        }

        System.out.println("No existe ese jugador");
    }
//MENUSES equipo=====================================================

    public static void crearEquipo() {
        String nombre = Funcionetes.leerString("Nombre del equipo: ");

        Team equipoNuevo = new Team(nombre);

        if (equipos.contains(equipoNuevo)) {
            System.out.println("Ese equipo ya existe");
        } else {
            equipos.add(equipoNuevo);
            System.out.println("Equipo creado");
        }
    }

    public static void mostrarEquipos() {
        if (equipos.isEmpty()) {
            System.out.println("No hay equipos");
        } else {
            for (Team equipo : equipos) {
                System.out.println(equipo);
            }
        }
    }

    public static void borrarEquipo() {
        String nombre = Funcionetes.leerString("Nombre del equipo a borrar: ");

        for (int i = 0; i < equipos.size(); i++) {
            if (equipos.get(i).getName().equals(nombre)) {
                equipos.remove(i);
                System.out.println("Equipo borrado");
                return;
            }
        }

        System.out.println("No existe ese equipo");
    }

    public static void asignarEquipoAJugador() {
        String nombreJugador = Funcionetes.leerString("Nombre del jugador: ");
        String nombreEquipo = Funcionetes.leerString("Nombre del equipo: ");

        Player jugadorEncontrado = null;
        Team equipoEncontrado = null;

        for (Player jugador : jugadores) {
            if (jugador.getName().equals(nombreJugador)) {
                jugadorEncontrado = jugador;
            }
        }

        for (Team equipo : equipos) {
            if (equipo.getName().equals(nombreEquipo)) {
                equipoEncontrado = equipo;
            }
        }

        if (jugadorEncontrado == null) {
            System.out.println("No existe ese jugador");
        } else if (equipoEncontrado == null) {
            System.out.println("No existe ese equipo");
        } else {
            equipoEncontrado.addPlayer(jugadorEncontrado);
            jugadorEncontrado.addTeam(equipoEncontrado);
            System.out.println("Jugador asignado al equipo");
        }
    }
//MENUSES OBJETOS=====================================================
    public static void crearObjeto() {
        String nombre = Funcionetes.leerString("Nombre del objeto: ");
        int atk = Funcionetes.leerInt("Bonus ataque: ");
        int def = Funcionetes.leerInt("Bonus defensa: ");

        Item nuevo = new Item(nombre, atk, def);
        objetos.add(nuevo);

        System.out.println("Objeto creado");
    }

    public static void mostrarObjetos() {
        if (objetos.isEmpty()) {
            System.out.println("No hay objetos");
        } else {
            for (Item obj : objetos) {
                System.out.println(obj.getName() + " BA:" + obj.getAttackBonus() + " / BD:" + obj.getDefenseBonus());
            }
        }
    }

    public static void borrarObjeto() {
        String nombre = Funcionetes.leerString("Nombre del objeto a borrar: ");

        for (int i = 0; i < objetos.size(); i++) {
            if (objetos.get(i).getName().equals(nombre)) {
                objetos.remove(i);
                System.out.println("Objeto borrado");
                return;
            }
        }

        System.out.println("No existe ese objeto");
    }

    public static void asignarObjetoAJugador() {
        String nombreJugador = Funcionetes.leerString("Nombre del jugador: ");
        String nombreObjeto = Funcionetes.leerString("Nombre del objeto: ");

        Player jugadorEncontrado = null;
        Item objetoEncontrado = null;

        for (Player jugador : jugadores) {
            if (jugador.getName().equals(nombreJugador)) {
                jugadorEncontrado = jugador;
            }
        }

        for (Item obj : objetos) {
            if (obj.getName().equals(nombreObjeto)) {
                objetoEncontrado = obj;
            }
        }

        if (jugadorEncontrado == null) {
            System.out.println("No existe ese jugador");
        } else if (objetoEncontrado == null) {
            System.out.println("No existe ese objeto");
        } else {
            jugadorEncontrado.addItem(objetoEncontrado);
            System.out.println("Objeto asignado al jugador");
        }
    }
//===== JUEGO PROIOP
public static void jugar() {
    Random random = new Random();
    ArrayList<Player> jugadoresVivos = new ArrayList<>();

    do {
        jugadoresVivos.clear();

        for (Player jugador : jugadores) {
            if (jugador.getLife() > 0) {
                jugadoresVivos.add(jugador);
            }
        }

        if (jugadoresVivos.size() < 2) {
            System.out.println(" FIN ");
            break;
        }

        int posAtacante = random.nextInt(jugadoresVivos.size());
        int posDefensor;

        do {
            posDefensor = random.nextInt(jugadoresVivos.size());
        } while (posDefensor == posAtacante);

        Player atacante = jugadoresVivos.get(posAtacante);
        Player defensor = jugadoresVivos.get(posDefensor);

        atacante.attack(defensor);

    } while (jugadoresVivos.size() >= 2);
}


//======================================================================================================
//======================================================================================================
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
        System.out.println("Fase 05, terminada.");
        /*
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
        */
    }

    public static void provaFase6() {
        int opcion;

        do {
            System.out.println("===== JUEGO DE ROL =====");
            System.out.println("1. Configuracion");
            System.out.println("2. Jugar");
            System.out.println("3. Salir");

            opcion = Funcionetes.leerInt("Elige opcion: ");

            switch (opcion) {
                case 1:
                    menuConfiguracion();
                    break;
                case 2:
                    jugar();
                    break;
                case 3:
                    System.out.println("Salimos");
                    break;
                default:
                    System.out.println("Opción incorrecta");
                    break;
            }
        } while (opcion != 3);
    }

    public static void menuConfiguracion() {
        int opcion;

        do {
            System.out.println("===== CONFIGURACION =====");
            System.out.println("1. Gestion de Jugadores");
            System.out.println("2. Gestion de Equipos");
            System.out.println("3. Gestion de Objetos");
            System.out.println("4. Salir");

            opcion = Funcionetes.leerInt("Elige opcion: ");

            switch (opcion) {
                case 1:
                    menuJugadores();
                    break;
                case 2:
                    menuEquipos();
                    break;
                case 3:
                    menuObjetos();
                    break;
                case 4:
                    System.out.println("Volviendo al menu anterior");
                    break;
                default:
                    System.out.println("Opcion incorrecta");
                    break;
            }
        } while (opcion != 4);
    }

    public static void menuJugadores() {
        int opcion;

        do {
            System.out.println("===== JUGADORES =====");
            System.out.println("1. Crear Jugador");
            System.out.println("2. Mostrar Jugadores");
            System.out.println("3. Borrar Jugador");
            System.out.println("4. Salir");

            opcion = Funcionetes.leerInt("Elige opcion: ");

            switch (opcion) {
                case 1:
                    crearJugador();
                    break;
                case 2:
                    mostrarJugadores();
                    break;
                case 3:
                    borrarJugador();
                    break;
                case 4:
                    System.out.println("Volviendo al menu anterior");
                    break;
                default:
                    System.out.println("Opcion incorrecta");
                    break;
            }
        } while (opcion != 4);
    }

    public static void menuEquipos() {
        int opcion;

        do {
            System.out.println("===== EQUIPOS =====");
            System.out.println("1. Crear Equipo");
            System.out.println("2. Mostrar Equipo");
            System.out.println("3. Borrar Equipo");
            System.out.println("4. Asignar Equipo a Jugador");
            System.out.println("5. Salir");

            opcion = Funcionetes.leerInt("Elige opcion: ");

            switch (opcion) {
                case 1:
                    crearEquipo();
                    break;
                case 2:
                    mostrarEquipos();
                    break;
                case 3:
                    borrarEquipo();
                    break;
                case 4:
                    asignarEquipoAJugador();
                    break;
                case 5:
                    System.out.println("Volviendo al menu anterior");
                    break;
                default:
                    System.out.println("Opcion incorrecta");
                    break;
            }
        } while (opcion != 5);
    }

    public static void menuObjetos() {
        int opcion;

        do {
            System.out.println("===== OBJETOS =====");
            System.out.println("1. Crear Objeto");
            System.out.println("2. Mostrar Objetos");
            System.out.println("3. Borrar Objetos");
            System.out.println("4. Asignar Objeto a Jugador");
            System.out.println("5. Salir");

            opcion = Funcionetes.leerInt("Elige opcion: ");

            switch (opcion) {
                case 1:
                    crearObjeto();
                    break;
                case 2:
                    mostrarObjetos();
                    break;
                case 3:
                    borrarObjeto();
                    break;
                case 4:
                    asignarObjetoAJugador();
                    break;
                case 5:
                    System.out.println("Volviendo al menu anterior");
                    break;
                default:
                    System.out.println("Opcion incorrecta");
                    break;
            }
        } while (opcion != 5);
    }

    public static void provaFase7() {
        System.out.println("Nada aún");
    }
//========================================================================================
//                                          MAIN
//========================================================================================

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


    }//FIN main
}// FIN FIN