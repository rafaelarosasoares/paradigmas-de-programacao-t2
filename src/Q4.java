import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Q4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> numeros = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            System.out.println("Insira um número:");
            int numero = scanner.nextInt();
            numeros.add(numero);
        }

        long somaIntervalo1 = contarNumerosNoIntervalo(numeros, 0, 25);
        long somaIntervalo2 = contarNumerosNoIntervalo(numeros, 26, 50);
        long somaIntervalo3 = contarNumerosNoIntervalo(numeros, 51, 75);
        long somaIntervalo4 = contarNumerosNoIntervalo(numeros, 76, 100);

        System.out.println("Quantidade de números no intervalo [0,25]: " + somaIntervalo1);
        System.out.println("Quantidade de números no intervalo [26,50]: " + somaIntervalo2);
        System.out.println("Quantidade de números no intervalo [51,75]: " + somaIntervalo3);
        System.out.println("Quantidade de números no intervalo [76,100]: " + somaIntervalo4);
    }

    private static long contarNumerosNoIntervalo(List<Integer> numeros, int inicio, int fim) {
        return numeros.stream()
                .filter(numero -> numero >= inicio && numero <= fim)
                .count();
    }
}
