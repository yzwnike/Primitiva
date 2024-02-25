import java.util.Scanner;

public class VehiNico_Primitiva {
    public static void main(String[] args) {
        menuPrincipal();
    }

    private static void menuPrincipal(){
        System.out.println("***** PRIMITIVA ******");

        int[] aposta = introduirAposta();
        int[] combinacioGuanyadora = calcularCombinacioGuanyadora();
        int premi;

        if (combinacioGuanyadora != null) {
            System.out.println("La combinació ganadora és: ");

            for (int i = 0; i < combinacioGuanyadora.length - 1; i++) {
                System.out.print(combinacioGuanyadora[i] + " ");
            }

            System.out.println("Reintegrament " + combinacioGuanyadora[combinacioGuanyadora.length - 1]);
        }

        premi = comprovarEncerts(aposta, combinacioGuanyadora);
        System.out.println("El teu premi és: "+premi+" €");
    }

    private static int[] introduirAposta(){
        System.out.println("Introdueix la teva aposta: ");
        int[] aposta = new int[7];
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < 6; i++) {
            aposta[i] = llegirInt("Número " + (i + 1) + ": ", 1, 49);
        }
        aposta[6] = llegirInt("Reintegrament: ", 0, 9);

        return aposta;
    }

    private static int[] calcularCombinacioGuanyadora(){
        int[] combinacio = new int[7];
        for (int i = 0; i < 6; i++) {
            combinacio[i] = (int) (Math.random() * 49) + 1;
        }
        combinacio[6] = (int) (Math.random() * 10);
        return combinacio;
    }

    private static int comprovarEncerts(int[] aposta, int[] combinacioGuanyadora){
        int premi = 0;
        int encerts = 0;
        boolean reintegrament = false;

        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                if (aposta[i] == combinacioGuanyadora[j]) {
                    encerts++;
                    break;
                }
            }
        }
        if (aposta[6] == combinacioGuanyadora[6]) {
            reintegrament = true;
        }

        premi += encerts * 20;
        if (reintegrament) {
            premi += 6;
        }

        return premi;
    }

    private static int llegirInt(String missatge, int min, int max) {
        Scanner scanner = new Scanner(System.in);
        int x = 0;
        boolean valorCorrecte = false;
        do {
            System.out.println(missatge);
            valorCorrecte = scanner.hasNextInt();
            if (!valorCorrecte){
                System.out.println("ERROR: Valor no enter.");
                scanner.nextLine();
            } else {
                x = scanner.nextInt();
                scanner.nextLine();
                if (x < min || x > max){
                    System.out.println("Opció no vàlida");
                    valorCorrecte = false;
                }
            }
        } while (!valorCorrecte);

        return x;
    }
}

