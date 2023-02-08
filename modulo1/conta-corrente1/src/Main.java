public class Main {
    public static void main(String[] args) {
        Cliente cliente = new Cliente();
        Cliente cliente2 = new Cliente();
        Contato contato = new Contato();
        Contato contato2 = new Contato();
        Endereco endereco = new Endereco();
        Endereco endereco2 = new Endereco();
        ContaCorrente conta = new ContaCorrente();
        ContaCorrente conta2 = new ContaCorrente();

        cliente.nome = "Thassio";
        cliente.cpf = "123.456.789-01";
        cliente.contato[0] = contato;
        cliente.contato[1] = contato2;
        cliente.enderecos[0] = endereco;
        cliente.enderecos[1] = endereco2;

        cliente2.nome = "Maicon";
        cliente2.cpf = "321.556.355-02";
        cliente2.contato[0] = contato;
        cliente2.contato[1] = contato2;
        cliente2.enderecos[0] = endereco;
        cliente2.enderecos[1] = endereco2;

        contato.telefone = "79 998482992";
        contato.descricao = "telefone pessoal";
        contato.tipo = 1;

        contato2.telefone = "79 998565712";
        contato2.descricao = "telefone para emergencias da empresa";
        contato2.tipo = 2;

        endereco.logradouro = "Rua Nourival da Silva";
        endereco.cep = "49140-49";
        endereco.tipo = 1;
        endereco.cidade = "Aracaju";
        endereco.complemento = "Casa";
        endereco.estado = "Sergipe";
        endereco.numero = 321;
        endereco.pais = "Brasil";

        endereco2.logradouro = "Avenida Borges de Medeiros\t";
        endereco2.cep = "95670‑092";
        endereco2.tipo = 2;
        endereco2.cidade = "Gramado";
        endereco2.complemento = "Casa";
        endereco2.estado = "Rio Grande do Sul";
        endereco2.numero = 123;
        endereco2.pais = "Brasil";

        conta.cliente = cliente;
        conta.numeroConta = "12345";
        conta.agencia = 1;
        conta.saldo = 10.0;
        conta.chequeEspecial = 20.0;

        conta2.cliente = cliente2;
        conta2.numeroConta = "54321";
        conta2.agencia = 2;
        conta2.saldo = 20000;
        conta2.chequeEspecial = 1000;

        cliente.imprimirCliente();
        cliente.imprimirContatos();
        cliente.imprimirEndercos();
        System.out.println("\n");
        cliente2.imprimirCliente();
        cliente2.imprimirContatos();
        cliente2.imprimirEndercos();
        System.out.println(" ");

        System.out.println("Saldo do Cheque especial R$" + conta.retornarSaldoComChequeEspecial() + " do cliente " + conta.cliente.nome);

        conta.depositar(50);
        conta.sacar(30);
        conta.transferir(conta2, 30);
        conta.imprimirContaCorrente();
    }
}