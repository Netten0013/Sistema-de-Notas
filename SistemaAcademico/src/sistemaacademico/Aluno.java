package sistemaacademico;

import java.util.ArrayList;
import java.util.List;

public class Aluno extends Pessoa {

    private static int contadorMatriculas = 1;

    private String matricula;
    private List<Turma> turmas;
    private List<Nota> notas;

    public Aluno(String nome, String cpf, String email) {
        super(nome, cpf, email);

        this.matricula = String.format("ALU%03d", contadorMatriculas);
        contadorMatriculas++;

        this.turmas = new ArrayList<>();
        this.notas = new ArrayList<>();
    }

    public String getMatricula() {
        return matricula;
    }

    public void adicionarTurma(Turma turma) {
        if (!turmas.contains(turma)) {
            turmas.add(turma);
        }
    }

    public void removerTurma(Turma turma) {
        turmas.remove(turma);
    }

    public void adicionarNota(Nota nota) {
        if (nota != null && nota.getAluno() == this) {
            notas.add(nota);
        }
    }

    public void consultarNotas() {
        System.out.println("\nNotas do aluno " + getNome() + ":");

        if (notas.isEmpty()) {
            System.out.println("Nenhuma nota cadastrada.");
            return;
        }

        for (Nota nota : notas) {
            nota.exibirNota();
        }
    }

    public void consultarTurmas() {
        System.out.println("\nTurmas do aluno " + getNome() + ":");

        if (turmas.isEmpty()) {
            System.out.println("O aluno não está cadastrado em nenhuma turma.");
            return;
        }

        for (Turma turma : turmas) {
            System.out.println(
                    "Turma: " + turma.getCodigo()
                            + " | Disciplina: " + turma.getDisciplina().getNome()
                            + " | Professor: " + turma.getProfessor().getNome()
            );
        }
    }

    @Override
    public void exibirDados() {
        System.out.println(
                "Aluno: " + getNome()
                        + " | Matrícula: " + matricula
                        + " | CPF: " + getCpf()
                        + " | E-mail: " + getEmail()
        );
    }
}