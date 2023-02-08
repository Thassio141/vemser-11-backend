public class Cliente {

    String nome, cpf;
    Contato[] contato = new Contato[2];
    Endereco[] enderecos = new Endereco[2];

    public void imprimirContatos(){
        for ( int x = 0 ; x < contato.length ; x ++) {
            contato[x].imprimirContato();
        }
    }

    public void imprimirEndercos(){
        for ( int x = 0; x < enderecos.length; x ++){
            enderecos[x].imprimirEndereco();
        }
    }

    public void imprimirCliente(){
        System.out.println("Nome: " + nome + ", CPF: " + cpf);
    }
}
