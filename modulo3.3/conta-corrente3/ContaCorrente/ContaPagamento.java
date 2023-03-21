package ContaCorrente;

public class ContaPagamento extends Conta implements Impressao{
    public ContaPagamento() {
    }

    static final double TAXA_SAQUE = 4.25;

    public ContaPagamento(Cliente cliente, String numeroConta, String agencia, double saldo) {
        super(cliente, numeroConta, agencia, saldo);
    }
    @Override
    public boolean sacar(double valor){
        if ( valor <= 0 ){
            return false;
        }
        else if  (getSaldo() >= valor + TAXA_SAQUE){
            setSaldo(getSaldo() - valor - TAXA_SAQUE);
            System.out.println("Saque de R$" + valor + " realizado com sucesso!");
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public boolean transferir(Conta conta, double valor){
        if ( valor <= 0 ){
            return false;
        }
        else if  (getSaldo() >= valor + TAXA_SAQUE){
            conta.depositar(valor);
            System.out.println("tranferencia de R$" + valor + " realizado com sucesso!");
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public void imprimir() {
        System.out.printf("Conta Pagamento > Numero da Conta: %s Agencia: %s Saldo: %f\n",getNumeroConta(),getAgencia(),getSaldo());
    }
}
