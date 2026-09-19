package sistemaacademico;

import java.util.ArrayList;
import java.util.List;

public class Turma {

    private String codigo;
    private Disciplina disciplina;
    private Professor professor;
    private List<Aluno> alunos;
    private List<Nota> notas;

    public Turma(
            String codigo,
            Disciplina disciplina,
            Professor professor
    ) {
        if (disciplina == null) {
            throw new IllegalArgumentException(
                    "A turma precisa possuir uma disciplina."
            );
        }

        if (professor == null) {
            throw new IllegalArgumentException(
                    "A turma precisa possuir um professor."
            );
        }

        this.codigo = codigo;
        this.disciplina = disciplina;
        this.professor = professor;

        this.alunos = new ArrayList<>();
        this.notas = new ArrayList<>();
    }

    public String getCodigo() {
        return codigo;
    }

    public void adicionarAluno(Aluno aluno) {
        if (aluno == null) {
            System.out.println("Não foi possível adicionar um aluno nulo.");
            return;
        }

        if (alunos.contains(aluno)) {
            System.out.println(
                    "O aluno " + aluno.getNome()
                            + " já está cadastrado na turma."
            );
            return;
        }

        alunos.add(aluno);
        aluno.adicionarTurma(this);

        System.out.println(
                "Aluno " + aluno.getNome()
                        + " adicionado à turma " + codigo + "."
        );
    }

    public void removerAluno(Aluno aluno) {
        if (alunos.remove(aluno)) {
            aluno.removerTurma(this);

            System.out.println(
                    "Aluno " + aluno.getNome()
                            + " removido da turma."
            );
        } else {
            System.out.println("O aluno não pertence a esta turma.");
        }
    }

    public void listarAlunos() {
        System.out.println("\nAlunos da turma " + codigo + ":");

        if (alunos.isEmpty()) {
            System.out.println("Nenhum aluno cadastrado.");
            return;
        }

        for (Aluno aluno : alunos) {
            aluno.exibirDados();
        }
    }

    public void adicionarNota(Nota nota) {
        if (nota == null) {
            System.out.println("Não é possível adicionar uma nota nula.");
            return;
        }

        if (!alunos.contains(nota.getAluno())) {
            System.out.println(
                    "A nota não foi adicionada porque o aluno "
                            + nota.getAluno().getNome()
                            + " não pertence à turma."
            );
            return;
        }

        notas.add(nota);
        nota.getAluno().adicionarNota(nota);
    }

    public void listarNotas() {
        System.out.println("\nNotas da turma " + codigo + ":");

        if (notas.isEmpty()) {
            System.out.println("Nenhuma nota cadastrada.");
            return;
        }

        for (Nota nota : notas) {
            nota.exibirNota();
        }
    }

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public Professor getProfessor() {
        return professor;
    }
}