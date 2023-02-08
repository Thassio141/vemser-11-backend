public class ContaCorrente {

    Cliente cliente = new Cliente();
    String numeroConta;
    int agencia;
    double saldo, chequeEspecial;


    public void imprimirContaCorrente(){
        System.out.printf("Numero da Conta: %s Agencia: %d Saldo: %f Cheque Especial: %f",numeroConta,agencia,saldo,chequeEspecial);
    }

    public boolean sacar(double valor){
        if ( valor <= 0 ){
            return false;
        }
        else if  (saldo + chequeEspecial >= valor ){
            saldo = saldo - valor;
            return true;
        }
        else {
            return false;
        }
    }

    public boolean depositar(double valor){
        if ( valor <= 0 ){
            return false;
        }
        else{
            saldo += valor;
            return true;
        }
    }

    public double retornarSaldoComChequeEspecial(){
        return saldo + chequeEspecial;
    }

    public boolean transferir(ContaCorrente conta, double valor){
        if ( valor <= 0){
            return false;
        }
        else if ( saldo + chequeEspecial >= valor){
            saldo = saldo - valor;
            conta.depositar(valor);
            return true;
        }
        return false;
    }
}
