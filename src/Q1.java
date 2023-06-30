import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Q1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Double> salarios = new ArrayList<>();
        List<Integer> numero_filhos = new ArrayList<>();

        double salario;
        int filhos;

        do {
            System.out.print("Salário (digite um valor negativo para sair): ");
            salario = scanner.nextDouble();

            if (salario >= 0) {
                salarios.add(salario);

                System.out.print("Quantidade de filhos: ");
                filhos = scanner.nextInt();
                numero_filhos.add(filhos);
            }
        } while (salario >= 0);

        double media_salarios = calculaMedia(salarios);
        double media_filhos = calculaMedia(numero_filhos);
        double maior_salario = buscaMaiorSalario(salarios);
        double percentual_salario_1000 = calculaPercentualAte1000(salarios);

        System.out.println("Valor médio dos salários: " + media_salarios);
        System.out.println("Média de filhos: " + media_filhos);
        System.out.println("Maior salário: " + maior_salario);
        System.out.println("Percentual de pessoas com salário de até R$1000: " + percentual_salario_1000 + "%");
    }

    private static double calculaMedia(List<? extends Number> lista) {
        return lista.stream()
                .mapToDouble(Number::doubleValue)
                .average()
                .orElse(0);
    }

    private static double buscaMaiorSalario(List<Double> salarios) {
        return salarios.stream()
                .mapToDouble(Double::doubleValue)
                .max()
                .orElse(0);
    }

    private static double calculaPercentualAte1000(List<Double> salarios) {
        long count = salarios.stream()
                .filter(salario -> salario <= 1000)
                .count();
        return (count / (double) salarios.size()) * 100;
    }
}
