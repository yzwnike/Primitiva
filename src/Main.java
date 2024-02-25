import java.util.Scanner;
import java.util.Arrays;

public class VehiNico_Primitiva {
    public static void main(String[] args) {
        menuPrincipal();
    }

    private static void menuPrincipal() {
        Scanner scanner = new Scanner(System.in);
        boolean salir = false;

        while (!salir) {
            System.out.println("***** Loteria *****");
            System.out.println("1. Hacer apuesta");
            System.out.println("2. Girar el bombo");
            System.out.println("3. Juego nuevo");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");
            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    hacerApuesta();
                    break;
                case 2:
                    girarBombo();
                    break;
                case 3:
                    juegoNuevo();
                    break;
                case 4:
                    salir = true;
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, seleccione una opción del menú.");
            }
        }
    }

    private static void hacerApuesta() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("***** Hacer apuesta *****");

        int[][] apuestas = new int[8][7];
        int contadorApuestas = 0;

        while (contadorApuestas < 8) {
            int[] apuesta = introducirApuesta();
            boolean existe = false;
            for (int[] a : apuestas) {
                if (Arrays.equals(a, apuesta)) {
                    System.out.println("Esta apuesta ya ha sido realizada. Por favor, ingrese otra.");
                    existe = true;
                    break;
                }
            }
            if (!existe) {
                apuestas[contadorApuestas] = apuesta;
                contadorApuestas++;
            }
        }
    }

    private static int[] introducirApuesta() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduzca su apuesta: ");
        int[] apuesta = new int[7];

        for (int i = 0; i < 6; i++) {
            apuesta[i] = leerEntero("Número " + (i + 1) + ": ", 1, 49);
        }
        apuesta[6] = leerEntero("Reintegro: ", 0, 9);

        return apuesta;
    }

    private static void girarBombo() {
        System.out.println("***** Girando el bombo *****");
        int[] combinacionGanadora = calcularCombinacion();
        System.out.println("Combinación ganadora: " + Arrays.toString(combinacionGanadora));
    }

    private static int[] calcularCombinacion() {
        int[] combinacionGanadora = new int[7];
        for (int i = 0; i < 6; i++) {
            combinacionGanadora[i] = (int) (Math.random() * 49) + 1;
        }
        combinacionGanadora[6] = (int) (Math.random() * 10);
        return combinacionGanadora;
    }

    private static void juegoNuevo() {
        System.out.println("***** Iniciando nuevo juego *****");
    }

    private static int leerEntero(String mensaje, int min, int max) {
        Scanner scanner = new Scanner(System.in);
        int numero;
        do {
            System.out.print(mensaje);
            while (!scanner.hasNextInt()) {
                System.out.println("Error: ingrese un número entero válido.");
                scanner.next();
            }
            numero = scanner.nextInt();
        } while (numero < min || numero > max);
        return numero;
    }
}
