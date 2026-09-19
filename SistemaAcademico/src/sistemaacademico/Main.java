package sistemaacademico;

public class Main {

    public static void main(String[] args) {

        System.out.println("==================================");
        System.out.println("   SISTEMA ACADÊMICO DE NOTAS");
        System.out.println("==================================");


        Professor professor = new Professor(
                "Ahmed Nasser Eddine",
                "123.456.789-00",
                "ahmed007@estacio.com"
        );

        System.out.println("\n1. PROFESSOR CADASTRADO");
        professor.exibirDados();


        Disciplina disciplina =
                professor.cadastrarDisciplina(
                        "Programação Orientada a Objetos",
                        80
                );

        System.out.println("\n2. DISCIPLINA CADASTRADA");
        disciplina.exibirDados();


        Turma turma =
                professor.criarTurma(disciplina, professor);

        System.out.println("\n3. TURMA CRIADA");
        System.out.println("Código da turma: " + turma.getCodigo());
        System.out.println(
                "Disciplina: " + turma.getDisciplina().getNome()
        );
        System.out.println(
                "Professor: " + turma.getProfessor().getNome()
        );


        Aluno aluno1 = professor.cadastrarAluno(
                "Rafaela Vergotti",
                "111.124.908-55",
                "faela@email.com"
        );

        Aluno aluno2 = professor.cadastrarAluno(
                "Bruno Henrique",
                "903.544.323-22",
                "brunobh@estacio.com"
        );

        Aluno aluno3 = professor.cadastrarAluno(
                "Carlos Silva",
                "312.733.336-34",
                "carlin@email.com"
        );


        System.out.println("\n4. ADICIONANDO ALUNOS");

        turma.adicionarAluno(aluno1);
        turma.adicionarAluno(aluno2);
        turma.adicionarAluno(aluno3);


        System.out.println("\nTentando adicionar Ana novamente:");
        turma.adicionarAluno(aluno1);


        turma.listarAlunos();


        Nota nota1 = professor.lancarNota(
                aluno1,
                8.5,
                "Prova 1"
        );

        Nota nota2 = professor.lancarNota(
                aluno1,
                9.0,
                "Trabalho"
        );

        Nota nota3 = professor.lancarNota(
                aluno2,
                7.5,
                "Prova 1"
        );

        Nota nota4 = professor.lancarNota(
                aluno2,
                8.0,
                "Trabalho"
        );

        Nota nota5 = professor.lancarNota(
                aluno3,
                9.5,
                "Prova 1"
        );

        Nota nota6 = professor.lancarNota(
                aluno3,
                10.0,
                "Trabalho"
        );


        turma.adicionarNota(nota1);
        turma.adicionarNota(nota2);
        turma.adicionarNota(nota3);
        turma.adicionarNota(nota4);
        turma.adicionarNota(nota5);
        turma.adicionarNota(nota6);


        turma.listarNotas();


        aluno1.consultarNotas();


        aluno1.consultarTurmas();


        System.out.println("\nDADOS INDIVIDUAIS DOS OBJETOS");

        professor.exibirDados();
        disciplina.exibirDados();
        aluno1.exibirDados();


        System.out.println("\nALTERAÇÃO DO E-MAIL");

        System.out.println("E-mail anterior: " + aluno1.getEmail());

        aluno1.setEmail("ana.novo@email.com");

        System.out.println("Novo e-mail: " + aluno1.getEmail());


        System.out.println("\nALTERAÇÃO DE NOTA");

        System.out.println("Nota anterior: " + nota1.getValor());

        nota1.setValor(9.0);

        System.out.println("Nova nota: " + nota1.getValor());

        System.out.println("\n==================================");
        System.out.println("       EXECUÇÃO FINALIZADA");
        System.out.println("==================================");
    }
}