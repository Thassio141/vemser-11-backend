package ContaCorrente;

public class Main {
    public static void main(String[] args) {

        Cliente cliente = new Cliente("Thassio","123.456.789-01");
        Cliente cliente2 = new Cliente("Maicon","321.556.355-02");
        cliente.setContato(new Contato("telefone pessoal","79 998482992",1));
        cliente.setEnderecos(new Endereco(1,321,"Rua Nourival da Silva","Casa","49140-49","Aracaju","Sergipe","Brasil"));
        cliente2.setContato( new Contato("telefone para emergencias da empresa","79 998565712",2));
        cliente2.setEnderecos(new Endereco(2,123,"Avenida Borges de Medeiros","Casa","95670‑092","Gramado","Rio Grande do Sul", "Brasil"));

        ContaCorrente conta = new ContaCorrente(cliente,"12345","2",100,20);
        ContaPagamento contaPg = new ContaPagamento(cliente, "54321","3",1000);
        ContaPoupanca contaPoupanca = new ContaPoupanca(cliente2,"54321","1",200);

        conta.imprimir();
        contaPg.imprimir();
        contaPoupanca.imprimir();

        conta.depositar(50);
        conta.sacar(30);
        conta.transferir(contaPg, 30);
        conta.imprimir();

        contaPg.depositar(20);
        contaPg.sacar(30);
        contaPg.transferir(conta,40);
        contaPg.imprimir();

        contaPoupanca.depositar(500);
        contaPoupanca.sacar(200);
        contaPoupanca.transferir(conta,10);
        contaPoupanca.imprimir();
    }
}