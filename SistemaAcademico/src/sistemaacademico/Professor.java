package sistemaacademico;

public class Professor extends Pessoa {

    private static int contadorRegistros = 1;
    private static int contadorDisciplinas = 1;
    private static int contadorTurmas = 1;

    private String registro;

    public Professor(String nome, String cpf, String email) {
        super(nome, cpf, email);

        this.registro = String.format(
                "PROF%03d",
                contadorRegistros
        );

        contadorRegistros++;
    }

    public String getRegistro() {
        return registro;
    }

    public Aluno cadastrarAluno(
            String nome,
            String cpf,
            String email
    ) {
        return new Aluno(nome, cpf, email);
    }

    public Disciplina cadastrarDisciplina(
            String nome,
            int cargaHoraria
    ) {
        if (cargaHoraria <= 0) {
            throw new IllegalArgumentException(
                    "A carga horária deve ser maior que zero."
            );
        }

        String codigo = String.format(
                "DISC%03d",
                contadorDisciplinas
        );

        contadorDisciplinas++;

        return new Disciplina(codigo, nome, cargaHoraria);
    }

    public Turma criarTurma(
            Disciplina disciplina,
            Professor professor
    ) {
        String codigo = String.format(
                "TURMA%03d",
                contadorTurmas
        );

        contadorTurmas++;

        return new Turma(codigo, disciplina, professor);
    }

    public Nota lancarNota(
            Aluno aluno,
            double valor,
            String descricao
    ) {
        return new Nota(aluno, valor, descricao);
    }

    @Override
    public void exibirDados() {
        System.out.println(
                "Professor: " + getNome()
                        + " | Registro: " + registro
                        + " | CPF: " + getCpf()
                        + " | E-mail: " + getEmail()
        );
    }
}