package teste;
import org.junit.Assert;
import org.junit.Test;
import conta.*;
public class ContaTest {

    @Test
    public void deveTestarSaqueContaCorrenteSemSaldo() {
        double saldo = 100.0;
        double chequeEspecial = 200.0;
        double valor = 400;

        ContaCorrente contaCorrente = new ContaCorrente();
        contaCorrente.setSaldo(saldo);
        contaCorrente.setChequeEspecial(chequeEspecial);

        boolean testSacarSemSaldo = contaCorrente.sacar(valor);

        Assert.assertFalse(testSacarSemSaldo);
        Assert.assertEquals(saldo, contaCorrente.getSaldo(), 0);
    }

    @Test
    public void deveTestarDepositoNegativo() {
        double saldo = 2000.0;
        double valorDeposito = -1000.0;

        ContaCorrente contaCorrente = new ContaCorrente();
        contaCorrente.setSaldo(saldo);

        boolean testDepositarNegativo = contaCorrente.depositar(valorDeposito);

        Assert.assertFalse(testDepositarNegativo);
        Assert.assertEquals(saldo, contaCorrente.getSaldo(), 0);
    }

    @Test
    public void deveTestarTransferenciaSemSaldo() {
        double saldo = 0;
        double saldo2 = 100.0;

        ContaCorrente contaCorrente = new ContaCorrente();
        ContaCorrente contaCorrente2 = new ContaCorrente();
        contaCorrente.setSaldo(saldo);
        contaCorrente2.setSaldo(saldo2);

        boolean testarTransferenciaContas = contaCorrente.transferir(contaCorrente2,100);
        
        Assert.assertFalse(testarTransferenciaContas);
        Assert.assertEquals(saldo, contaCorrente.getSaldo(), 0);
        Assert.assertEquals(saldo2, contaCorrente2.getSaldo(), 0);
    }

    @Test
    public void deveTestarSaqueContaPagamentoSemSaldo() {
        double saldo = 100.0;
        double valor = 400;

        ContaPagamento contaPagamento = new ContaPagamento();
        contaPagamento.setSaldo(saldo);

        boolean testarSacarContaPagamento = contaPagamento.sacar(valor);

        Assert.assertFalse(testarSacarContaPagamento);
        Assert.assertEquals(saldo, contaPagamento.getSaldo(), 0);
    }

    @Test
    public void deveTestarSaqueContaPoupancaSemSaldo() {
        double saldo = 100.0;
        double valor = 400;

        ContaPoupanca contaPoupanca= new ContaPoupanca();
        contaPoupanca.setSaldo(saldo);

        boolean testarSacarSaldoPoupanca = contaPoupanca.sacar(valor);

        Assert.assertFalse(testarSacarSaldoPoupanca);
        Assert.assertEquals(saldo, contaPoupanca.getSaldo(), 0);
    }
}
