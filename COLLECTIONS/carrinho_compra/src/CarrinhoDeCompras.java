import java.util.ArrayList;
import java.util.List;

public class CarrinhoDeCompras {
    private List<Item> carinhoCompra;

    public CarrinhoDeCompras(){
        this.carinhoCompra = new ArrayList<>();
    }


    public void adicionarItem(String nome, double preco, int quantidade){
        carinhoCompra.add(new Item(nome, preco, quantidade));
    }

    public void removerItem(String nome){
        List<Item> itensRemover = new ArrayList<>();

        if(!carinhoCompra.isEmpty()){
            for(Item t : carinhoCompra){
                if(t.getNome().equalsIgnoreCase(nome)){
                    itensRemover.add(t);
                }
            }
            carinhoCompra.removeAll(itensRemover);
        }
        else{
            System.out.println("Lista está vazia!");
        }
    }

    public void calcularValorTotal(){
        double valor = 0;
        for(Item t : carinhoCompra){

            valor += (t.getPreco() * t.getQuantidade());
        }
        System.out.println("O valor total do items do carrinho: R$"+valor);
    }

    public void infosItem(){
        System.out.println(carinhoCompra);
    }

    public static void main(String[] args) {
        CarrinhoDeCompras carrinhoDeCompras = new CarrinhoDeCompras();

        carrinhoDeCompras.adicionarItem("Arroz",10,2);
        carrinhoDeCompras.adicionarItem("Feijão",5,1);

        carrinhoDeCompras.calcularValorTotal();
        carrinhoDeCompras.infosItem();

        carrinhoDeCompras.removerItem("Arroz");
        carrinhoDeCompras.infosItem();
    }


}

