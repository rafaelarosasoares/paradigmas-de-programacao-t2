import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Q5 {
    public static void main(String[] args) {
        List<String> codigos = new ArrayList<>();
        List<Double> precosCusto = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        String codigo;
        double precoCusto;
        do {
            System.out.print("Informe o código do produto (ou um código negativo para sair): ");
            codigo = scanner.nextLine();

            if (!codigo.startsWith("-")) {
                System.out.print("Informe o preço de custo do produto: ");
                precoCusto = scanner.nextDouble();

                scanner.nextLine();

                codigos.add(codigo);
                precosCusto.add(precoCusto);
            }
        } while (!codigo.startsWith("-"));

        List<Double> precosNovos = precosCusto.stream()
                .map(preco -> preco * 1.2)
                .collect(Collectors.toList());

        System.out.println("Códigos e preços após aumento de 20%:");

        for (int i = 0; i < codigos.size(); i++) {
            String codigoAtual = codigos.get(i);
            double precoCustoAtual = precosCusto.get(i);
            double precoNovo = precosNovos.get(i);

            System.out.println("Código: " + codigoAtual + " - Preço novo: " + precoNovo);
        }

        double mediaPrecosNovos = precosNovos.stream()
                .mapToDouble(Double::doubleValue)
                .average()
                .orElse(0.0);

        System.out.println("Média de preço dos produtos após o aumento: " + mediaPrecosNovos);
    }
}
