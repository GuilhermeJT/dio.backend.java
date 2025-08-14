import java.util.HashSet;
import java.util.Set;

public class ListaTarefas {

    private Set<Tarefa> listaTarefa;

    public ListaTarefas() {
        this.listaTarefa = new HashSet<>();
    }


    public void adicionarTarefa(String descricao){
        listaTarefa.add(new Tarefa(descricao));
    }

    public void removerTarefa(String descricao){
        Tarefa t = null;
        if(!listaTarefa.isEmpty()){
            for(Tarefa tLista : listaTarefa){
                if(tLista.getDescricao().equalsIgnoreCase(descricao)){
                    t = tLista;
                    break;
                }
            }
            listaTarefa.remove(t);

        }
    }

    public void exibirTarefas(){
        System.out.println(listaTarefa);
    }

    public int contarTarefas(){
        return listaTarefa.size();
    }

    public Set<Tarefa> obterTarefasConcluidas(){
        Set<Tarefa> tarefasConcluidas = new HashSet<>();
        if(!listaTarefa.isEmpty()){
            for(Tarefa t : listaTarefa){
                if(t.isStatus()){
                    tarefasConcluidas.add(t);
                }
            }
        }
        return tarefasConcluidas;
    }

    public Set<Tarefa> obterTarefasPendentes(){
        Set<Tarefa> tarefasPendentes = new HashSet<>();
        if(!listaTarefa.isEmpty()){
            for(Tarefa t : listaTarefa){
                if(!t.isStatus()){
                    tarefasPendentes.add(t);
                }
            }
        }
        return tarefasPendentes;
    }



    public void marcarTarefaConcluida(String descricao){
        if(!listaTarefa.isEmpty()){
            for(Tarefa t : listaTarefa){
                if(t.getDescricao().equalsIgnoreCase(descricao)){
                    t.setStatus(true);
                    break;
                }
            }
        }
    }

    public void marcarTarefaPendente(String descricao){
        if(!listaTarefa.isEmpty()){
            for(Tarefa t : listaTarefa){
                if(t.getDescricao().equalsIgnoreCase(descricao)){
                    t.setStatus(false);
                    break;
                }
            }
        }
    }

    public void limparListaTarefas(){
        listaTarefa.clear();
        System.out.println("Lista apos a limpeza:" + listaTarefa);

    }


}
