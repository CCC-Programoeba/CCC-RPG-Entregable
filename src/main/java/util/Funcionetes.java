package util;
import java.util.Locale;
import java.util.Scanner;

public class Funcionetes {
    static Scanner entrada = new Scanner(System.in).useLocale(Locale.US);

    // --------------------------------------------------------------
    public static int leerInt(String pregunta) {
        int numero;
        do {
            try {
                System.out.println(pregunta);
                numero = entrada.nextInt(); // Si hem posat lletres va al catch
                entrada.nextLine();
                return numero;
            } catch (Exception e) { // Si hem posat lletres, avisa i buida el buffer
                System.out.print("Ha de ser un número entero: ");
                entrada.nextLine();
            }
        } while (true); // Bucle infinit fins que retornem el número correcte
    }

    // --------------------------------------------------------------
    public static float leerFloat(String pregunta) {
        float numero;
        do {
            try {
                System.out.println(pregunta);
                numero = entrada.nextFloat(); // Si hem posat lletres va al catch
                entrada.nextLine();
                return numero;
            } catch (Exception e) { // Si hem posat lletres, avisa i buida el buffer
                System.out.print("Ha de ser un número real: ");
                entrada.nextLine();
            }
        } while (true); // Bucle infinit fins que retornem el número correcte
    }

    // --------------------------------------------------------------
    public static Double leerDouble(String pregunta) {
        Double numero;
        do {
            try {
                System.out.println(pregunta);
                numero = entrada.nextDouble(); // Si hem posat lletres va al catch
                entrada.nextLine();
                return numero;
            } catch (Exception e) { // Si hem posat lletres, avisa i buida el buffer
                System.out.print("Ha de ser un número real: ");
                entrada.nextLine();
            }
        } while (true); // Bucle infinit fins que retornem el número correcte
    }

    // --------------------------------------------------------------
    public static char leerChar(String pregunta) {
        String texto;
        do {
            System.out.println(pregunta);
            texto = entrada.nextLine().trim();
            if (texto.length() == 1) {
                return texto.charAt(0);
            } else {
                System.out.println("Has d'introduir només un caràcter. Torna-ho a intentar:");
            }
        } while (true);
    }

    // --------------------------------------------------------------
    public static String leerString(String pregunta) {
        String texto;
        do {
            System.out.println(pregunta);
            texto = entrada.nextLine().trim();
            if (!texto.isEmpty()) {
                return texto;
            } else {
                System.out.println("No pot estar buit. Torna-ho a intentar:");
            }
        } while (true);
    }

    // --------------------------------------------------------------
    public static boolean isNumeric(String str) {
        try {
            Double.parseDouble(str);
            return true;
        }catch (NumberFormatException e){
            return false;
        }
    }
    // --------------------------------------------------------------
}

