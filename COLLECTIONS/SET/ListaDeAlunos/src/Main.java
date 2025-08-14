
public class Main {
    public static void main(String[] args) {

        GerenciadorAlunos listaAlunos = new GerenciadorAlunos();


        listaAlunos.adicionarAluno("Guilherme",123456L,8);
        listaAlunos.adicionarAluno("Gabriel",789101L,7);
        listaAlunos.adicionarAluno("Igor",123456L,4);
        listaAlunos.adicionarAluno("Alex",1456L,2);

        //listaAlunos.exibirAlunos();

        //listaAlunos.removerAluno(123456L);


        //listaAlunos.exibirAlunosPorNome();
        listaAlunos.exibirAlunosPorNota();






    }
}