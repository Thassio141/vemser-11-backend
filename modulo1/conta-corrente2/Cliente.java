public class Cliente {

    private String nome, cpf;
    private Contato[] contato = new Contato[2];
    private Endereco[] enderecos = new Endereco[2];

    public Cliente(String nome, String cpf, Contato contato, Contato contato2, Endereco enderecos, Endereco enderecos2) {
        this.nome = nome;
        this.cpf = cpf;
        this.contato[0] = contato;
        this.contato[1] = contato2;
        this.enderecos[0] = enderecos;
        this.enderecos[1] = enderecos2;
    }

    //- imprimirContatos(): colocar verificação de lista if(c!=null)
    //- imprimirEnderecos(): colocar verificação de lista if(e!=null)

    public void imprimirContatos(){
            for ( int x = 0 ; x < contato.length ; x ++) {
                if (contato[x] != null){
                    contato[x].imprimirContato();
                }
            }
    }

    public void imprimirEndercos(){
        for ( int x = 0; x < enderecos.length; x ++){
            if (contato[x] != null) {
                enderecos[x].imprimirEndereco();
            }
        }
    }

    public void imprimirCliente(){
        System.out.println("Nome: " + nome + ", CPF: " + cpf);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Contato[] getContato() {
        return contato;
    }

    public void setContato(Contato[] contato) {
        this.contato = contato;
    }

    public Endereco[] getEnderecos() {
        return enderecos;
    }

    public void setEnderecos(Endereco[] enderecos) {
        this.enderecos = enderecos;
    }
}
