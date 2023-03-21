package ContaCorrente;

public class Endereco {

    private int tipo , numero;
    private String logradouro, complemento, cep ,cidade , estado, pais;

    public void imprimirEndereco(){
        if (tipo == 1){
            System.out.printf("Enderço: %s %s residental %d %s %s %s %s \n", logradouro, complemento, numero, cep , cidade, estado, pais );
        }
        else {
            System.out.printf("Enderço: %s %s comercial %d %s %s %s %s \n", logradouro, complemento, numero, cep , cidade, estado, pais );

        }
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public Endereco(int tipo, int numero, String logradouro, String complemento, String cep, String cidade, String estado, String pais) {
        this.tipo = tipo;
        this.numero = numero;
        this.logradouro = logradouro;
        this.complemento = complemento;
        this.cep = cep;
        this.cidade = cidade;
        this.estado = estado;
        this.pais = pais;
    }
}
