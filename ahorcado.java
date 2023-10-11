import java.util.*;

public class ahorcado {
    public static void main(String[] args) {
        String palabraSecreta = getPalabraSecreta();
        char[] palabraGuiones = getGuionesFromPalabra(palabraSecreta);
        boolean juegoTerminado = false;
        Scanner lector = new Scanner(System.in);
        int intentos = 3;
        boolean seHanDadoPistas = false;

        do {
            System.out.println("Te quedan " + intentos + " intentos");
            System.out.println(palabraGuiones);
            System.out.println("Ingresa una letra");
            char letra = lector.next().charAt(0);
            boolean algunaLetraAcertada = false;

            for (int i = 0; i < palabraSecreta.length(); i++) {
                if (palabraSecreta.charAt(i) == letra) {
                    palabraGuiones[i] = letra;
                    algunaLetraAcertada = true;
                }
            }

            if (!algunaLetraAcertada) {
                System.out.println("No has acertado ninguna letra");
                intentos--;
                if (intentos == 0) {
                    System.out.println("Has perdido porque agotaste los intentos");
                    juegoTerminado = true;
                } else if (!seHanDadoPistas) {
                    seHanDadoPistas = true;
                    System.out.println("Pistas:");
                    System.out.println("La primera letra es: " + palabraSecreta.charAt(0));
                    System.out.println("La última letra es: " + palabraSecreta.charAt(palabraSecreta.length() - 1));
                    System.out.println("La palabra tiene " + palabraSecreta.length() + " letras.");
                }
            } else {
                boolean juegoGanado = !hayGuiones(palabraGuiones);
                if (juegoGanado) {
                    System.out.println("Has ganado el juego");
                    juegoTerminado = true;
                }
            }
        } while (!juegoTerminado);

        lector.close();
    }

    static String getPalabraSecreta() {
        String[] palabras = { "puente", "azul", "television" };
        Random r = new Random();
        int n = r.nextInt(palabras.length);
        return palabras[n];
    }

    static char[] getGuionesFromPalabra(String palabra) {
        int nLetrasPalabraSecreta = palabra.length();
        char[] palabraGuiones = new char[nLetrasPalabraSecreta];

        for (int i = 0; i < palabraGuiones.length; i++) {
            palabraGuiones[i] = '_';
        }

        return palabraGuiones;
    }

    static boolean hayGuiones(char[] array) {
        for (char l : array) {
            if (l == '_') return true;
        }
        return false;
    }
}


