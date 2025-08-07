// IPhone.java
public class IPhone implements ReprodutorMusical,
        AparelhoTelefonico,
        NavegadorInternet {

    // Reprodutor Musical
    @Override
    public void tocar() {
        System.out.println("iPhone: tocando música");
    }

    @Override
    public void pausar() {
        System.out.println("iPhone: música pausada");
    }

    @Override
    public void selecionarMusica(String musica) {
        System.out.println("iPhone: selecionada a música '" + musica + "'");
    }

    // Aparelho Telefônico
    @Override
    public void ligar(String numero) {
        System.out.println("iPhone: ligando para " + numero);
    }

    @Override
    public void atender() {
        System.out.println("iPhone: chamada atendida");
    }

    @Override
    public void iniciarCorreioVoz() {
        System.out.println("iPhone: iniciando correio de voz");
    }

    // Navegador na Internet
    @Override
    public void exibirPagina(String url) {
        System.out.println("iPhone: exibindo página " + url);
    }

    @Override
    public void adicionarNovaAba() {
        System.out.println("iPhone: nova aba aberta");
    }

    @Override
    public void atualizarPagina() {
        System.out.println("iPhone: página atualizada");
    }
}
