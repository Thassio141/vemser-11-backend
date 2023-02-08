public class Endereco {

    int tipo , numero;
    String logradouro, complemento, cep ,cidade , estado, pais;

    public void imprimirEndereco(){
        if (tipo == 1){
            System.out.printf("Enderço: %s %s residental %d %s %s %s %s \n", logradouro, complemento, numero, cep , cidade, estado, pais );
        }
        else {
            System.out.printf("Enderço: %s %s comercial %d %s %s %s %s \n", logradouro, complemento, numero, cep , cidade, estado, pais );

        }
    }
}
