public abstract class Conta implements Movimentacao{

    private Cliente cliente;
    private String numeroConta , agencia;
    private double saldo;

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public String getNumeroConta() {
        return numeroConta;
    }

    public void setNumeroConta(String numeroConta) {
        this.numeroConta = numeroConta;
    }

    public String getAgencia() {
        return agencia;
    }

    public void setAgencia(String agencia) {
        this.agencia = agencia;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public boolean sacar(double valor){
        if ( valor <= 0 ){
            return false;
        }
        else if  (saldo >= valor ){
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

    public boolean transferir(Conta conta, double valor){
        if ( sacar(valor)){
            conta.depositar(valor);
            return true;
        }
        return false;
    }

    public Conta(Cliente cliente, String numeroConta, String agencia, double saldo) {
        this.cliente = cliente;
        this.numeroConta = numeroConta;
        this.agencia = agencia;
        this.saldo = saldo;
    }
}
