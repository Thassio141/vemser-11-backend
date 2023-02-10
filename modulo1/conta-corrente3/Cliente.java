import java.util.ArrayList;
public class Cliente {

    private String nome, cpf;
    private ArrayList<Contato> contatos = new ArrayList<>();
    private ArrayList<Endereco> enderecos = new ArrayList<>();


    public Cliente(String nome, String cpf) {
        this.nome = nome;
        this.cpf = cpf;
    }

    public void imprimirContatos() {
        for (int x = 0; x < contatos.size(); x++) {
            if (contatos.get(x) != null) {
                contatos.get(x).imprimirContato();
            }
        }
    }

    public void imprimirEndercos() {
        for (int x = 0; x < enderecos.size(); x++) {
            if (enderecos.get(x) != null) {
                enderecos.get(x).imprimirEndereco();
            }
        }
    }

    public void imprimirCliente() {
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

    public ArrayList<Contato> getContato() {
        return contatos;
    }

    public void setContato(Contato contatos) {
        this.contatos.add(contatos);
    }

    public ArrayList<Endereco> getEnderecos() {
        return enderecos;
    }

    public void setEnderecos(Endereco enderecos) {
        this.enderecos.add(enderecos);
    }
}

