import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class GerenciadorAlunos {

    private Set<Aluno> listaAlunos;

    public GerenciadorAlunos() {
        this.listaAlunos = new HashSet<>();
    }

    public void adicionarAluno(String nome, Long matricula, double media){
        listaAlunos.add(new Aluno(nome, matricula, media));
    }

    public void removerAluno(long matricula){
        Aluno a = null;
        if(!listaAlunos.isEmpty()){
            for(Aluno p : listaAlunos){
                if(p.getMatricula() == matricula){
                    a = p;
                    break;
                }
            }
        }
        listaAlunos.remove(a);
    }

    public void exibirAlunosPorNome() {
        if (listaAlunos.isEmpty()) {
            System.out.println("Conjunto vazio.");
            return;
        }

        Set<Aluno> ordenados = new TreeSet<>(
                Comparator.comparing(Aluno::getNome, String.CASE_INSENSITIVE_ORDER)
                        .thenComparing(Aluno::getMatricula)
        );

        ordenados.addAll(listaAlunos);
        ordenados.forEach(System.out::println);
    }

    public void exibirAlunosPorNota() {
        if (listaAlunos.isEmpty()) {
            System.out.println("Conjunto vazio.");
            return;
        }

        Set<Aluno> ordenados = new TreeSet<>(
                Comparator.comparingDouble(Aluno::getNota)
                        .thenComparing(Aluno::getMatricula)
        );

        ordenados.addAll(listaAlunos);
        System.out.println(ordenados);
    }



    public void exibirAlunos(){
        System.out.println(listaAlunos);
    }
}
