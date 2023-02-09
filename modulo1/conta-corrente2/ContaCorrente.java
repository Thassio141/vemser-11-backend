public class ContaCorrente extends Conta implements Impressao{
    private double chequeEspecial;
    public void setChequeEspecial(double chequeEspecial) {
        this.chequeEspecial = chequeEspecial;
    }

    public boolean sacar(double valor){
        if ( valor <= 0 ){
            return false;
        }
        else if  (getSaldo() + chequeEspecial >= valor ){
            setSaldo(getSaldo() - valor);
            return true;
        }
        else {
            return false;
        }
    }

    public double retornarSaldoComChequeEspecial(){
        return getSaldo() + chequeEspecial;
    }

    @Override
    public void imprimir() {
        System.out.printf("Numero da Conta: %s Agencia: %s Saldo: %f Cheque Especial: %f",getNumeroConta(),getAgencia(),getSaldo(),chequeEspecial);
    }

    public ContaCorrente(Cliente cliente, String numeroConta, String agencia, double saldo, double chequeEspecial) {
        super(cliente, numeroConta, agencia, saldo);
        this.chequeEspecial = chequeEspecial;
    }
}
