import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Q3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Aluno> alunos = new ArrayList<>();

        for (int i = 1; i <= 5; i++) {
            System.out.println("Matrícula do aluno " + i + ":");
            String matricula = scanner.nextLine();

            System.out.println("Nota 1 do aluno " + i + ":");
            double nota1 = scanner.nextDouble();

            System.out.println("Nota 2 do aluno " + i + ":");
            double nota2 = scanner.nextDouble();

            System.out.println("Nota 3 do aluno " + i + ":");
            double nota3 = scanner.nextDouble();

            scanner.nextLine();

            Aluno aluno = new Aluno(matricula, nota1, nota2, nota3);
            alunos.add(aluno);
        }

        for (Aluno aluno : alunos) {
            double media = calcularMediaPonderada(aluno);
            System.out.println("Matrícula: " + aluno.getMatricula());
            System.out.println("Notas: " + aluno.getNota1() + ", " + aluno.getNota2() + ", " + aluno.getNota3());
            System.out.println("Média: " + media);
            System.out.println("Situação: " + (media >= 5 ? "Aprovado" : "Reprovado"));
            System.out.println();
        }
    }

    private static double calcularMediaPonderada(Aluno aluno) {
        double maiorNota = Math.max(aluno.getNota1(), Math.max(aluno.getNota2(), aluno.getNota3()));
        return (maiorNota * 4 + aluno.getNota1() * 3 + aluno.getNota2() * 3) / 10;
    }

    private static class Aluno {
        private final String matricula;
        private final double nota1;
        private final double nota2;
        private final double nota3;

        public Aluno(String matricula, double nota1, double nota2, double nota3) {
            this.matricula = matricula;
            this.nota1 = nota1;
            this.nota2 = nota2;
            this.nota3 = nota3;
        }

        public String getMatricula() {
            return matricula;
        }

        public double getNota1() {
            return nota1;
        }

        public double getNota2() {
            return nota2;
        }

        public double getNota3() {
            return nota3;
        }
    }
}
