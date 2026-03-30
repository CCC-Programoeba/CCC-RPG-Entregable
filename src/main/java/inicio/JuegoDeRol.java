package inicio;
//Recorda afegir al professor com a col·laborador:
//
//usuari: joange
//
//email:jgcamarena@ieseljust.com
import juego.Alien;
import juego.Humano;
import juego.Tanque;
import util.Funcionetes;

public class JuegoDeRol {

    public static void provaFase1(){
        System.out.println("Fase 1");
        Humano humano01 = new Humano();
        Alien alien01 = new Alien();
        Tanque tanque01 = new Tanque();
    }
    public static void provaFase2(){System.out.println("Nada aún");}
    public static void provaFase3(){System.out.println("Nada aún");}
    public static void provaFase4(){System.out.println("Nada aún");}
    public static void provaFase5(){System.out.println("Nada aún");}
    public static void provaFase6(){System.out.println("Nada aún");}
    public static void provaFase7(){System.out.println("Nada aún");}

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
        }while(opcion!=0);



    }
}
