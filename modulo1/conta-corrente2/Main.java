public class Main {
    public static void main(String[] args) {
        Contato contato = new Contato("telefone pessoal","79 998482992",1);
        Contato contato2 = new Contato("telefone para emergencias da empresa","79 998565712",2);
        Endereco endereco = new Endereco(1,321,"Rua Nourival da Silva","Casa","49140-49","Aracaju","Sergipe","Brasil");
        Endereco endereco2 = new Endereco(2,123,"Avenida Borges de Medeiros","Casa","95670‑092","Gramado","Rio Grande do Sul", "Brasil");
        Cliente cliente = new Cliente("Thassio","123.456.789-01",contato,contato2, endereco, endereco2);
        Cliente cliente2 = new Cliente("Maicon","321.556.355-02",contato,contato2, endereco, endereco2);

        ContaCorrente conta = new ContaCorrente(cliente,"12345","2",10,20);
        ContaPoupanca conta2 = new ContaPoupanca(cliente2,"54321","1",20);

        cliente.imprimirCliente();
        cliente.imprimirContatos();
        cliente.imprimirEndercos();
        System.out.println("\n");
        cliente2.imprimirCliente();
        cliente2.imprimirContatos();
        cliente2.imprimirEndercos();
        System.out.println("\n");

        System.out.println("Saldo do Cheque especial R$" + conta.retornarSaldoComChequeEspecial() + " do cliente " + conta.getCliente().getNome());

        conta.depositar(50);
        conta.sacar(30);
        conta.transferir(conta2, 30);
        conta.imprimir();
        System.out.println("\n");
        conta2.imprimir();
    }
}