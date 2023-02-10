public class ContaPoupanca extends Conta implements Impressao{
    public static double JUROS_MENSAL = 1.01;
    public void creditarTaxa(){
        setSaldo(getSaldo()*JUROS_MENSAL);
    }

    @Override
    public void imprimir() {
        System.out.printf("Conta Poupanca >Numero da Conta: %s Agencia: %s Saldo: %f\n",getNumeroConta(),getAgencia(),getSaldo());
    }

    public ContaPoupanca(Cliente cliente, String numeroConta, String agencia, double saldo) {
        super(cliente, numeroConta, agencia, saldo);
    }
}
