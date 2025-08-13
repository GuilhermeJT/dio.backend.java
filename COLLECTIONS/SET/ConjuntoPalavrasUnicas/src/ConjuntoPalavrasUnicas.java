import java.util.HashSet;
import java.util.Set;

public class ConjuntoPalavrasUnicas {
    private Set<String> conjunto;



    public ConjuntoPalavrasUnicas(){
        conjunto = new HashSet<>();

    }

    public void adicionarPalavra(String palavra){
        conjunto.add(palavra);

    }

    public void removerPalavra(String palavra){
        String nome_remove = "";
        for(String p : conjunto){
            if(p.equalsIgnoreCase(palavra)){
                nome_remove = p;
                break;
            }
        }
        conjunto.remove(nome_remove);
    }

    public void verificarPalavra(String palavra) {
        if (conjunto.contains(palavra)) {
            System.out.println("A palavra " + palavra + " está presente");
        } else {
            System.out.println("Palavra não está presente");
        }
    }


    public void exibirPalavrasUnicas(){
        System.out.println(conjunto);
    }
}
