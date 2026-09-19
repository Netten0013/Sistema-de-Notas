package sistemaacademico;

public class Nota {

    private Aluno aluno;
    private double valor;
    private String descricao;

    public Nota(Aluno aluno, double valor, String descricao) {
        if (aluno == null) {
            throw new IllegalArgumentException(
                    "A nota precisa estar associada a um aluno."
            );
        }

        validarValor(valor);

        this.aluno = aluno;
        this.valor = valor;
        this.descricao = descricao;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public double getValor() {
        return valor;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setValor(double valor) {
        validarValor(valor);
        this.valor = valor;
    }

    private void validarValor(double valor) {
        if (valor < 0 || valor > 10) {
            throw new IllegalArgumentException(
                    "A nota deve estar entre 0 e 10."
            );
        }
    }

    public void exibirNota() {
        System.out.printf(
                "Aluno: %s | Atividade: %s | Nota: %.2f%n",
                aluno.getNome(),
                descricao,
                valor
        );
    }
}