import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Q2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> votos = new ArrayList<>();

        int voto;
        do {
            System.out.println("\n-----\nVOTAR\n-----\nCandidatos: (1, 2, 3, 4)\nVoto nulo: (5)\nVoto em branco: (6)\nSeu voto:");
            voto = scanner.nextInt();
            if (voto >= 0 && voto <= 6) {
                votos.add(voto);
            }
        } while (voto != 0);

        long[] somaVotos = contarVotos(votos);

        for (int i = 1; i <= 4; i++) {
            System.out.println("Votos para o candidato " + i + ": " + somaVotos[i]);
        }
        System.out.println("Votos nulos: " + somaVotos[5]);
        System.out.println("Votos em branco: " + somaVotos[6]);
    }

    private static long[] contarVotos(List<Integer> votos) {
        long[] somaVotos = new long[7];

        for (int voto : votos) {
            if (voto >= 1 && voto <= 4) {
                somaVotos[voto]++;
            } else if (voto == 5) {
                somaVotos[5]++;
            } else if (voto == 6) {
                somaVotos[6]++;
            }
        }

        return somaVotos;
    }
}
