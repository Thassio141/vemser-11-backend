package com.br.vemser;
import org.junit.Assert;
import org.junit.Test;
public class NovoTest {

    @Test
    public void deveTestarSaqueContaCorrenteSemSaldo() {
        //não dar certo o valor do saque (saque > saldo + ce)
        double saldo = 100.0;
        double chequeEspecial = 200.0;
        double valor = 400;

        ContaCorrente contaCorrente = new ContaCorrente();
        contaCorrente.setSaldo(saldo + chequeEspecial);

        boolean testSacarSemSaldo = contaCorrente.sacar(valor);

        Assert.assertFalse(testSacarSemSaldo);
    }

    @Test
    public void deveTestarDepositoNegativo() {
        double saldo = 2000.0;
        double valorDeposito = -1000.0;

        ContaCorrente contaCorrente = new ContaCorrente();
        contaCorrente.setSaldo(saldo);

        boolean testDepositarNegativo = contaCorrente.depositar(valorDeposito);

        Assert.assertFalse(testDepositarNegativo);
    }

    @Test
    public void deveTestarTransferenciaSemSaldo() {
        double saldo = 100.0;

        ContaCorrente contaCorrente = new ContaCorrente();
        ContaCorrente contaCorrente2 = new ContaCorrente();
        contaCorrente.setSaldo(0);
        contaCorrente2.setSaldo(saldo);

        boolean testarTransferenciaContas = contaCorrente.transferir(contaCorrente2,100);
        
        Assert.assertFalse(testarTransferenciaContas);
    }

    @Test
    public void deveTestarSaqueContaPagamentoSemSaldo() {
        double saldo = 100.0;
        double valor = 400;

        ContaPagamento contaPagamento = new ContaPagamento();
        contaPagamento.setSaldo(saldo);

        boolean testarSacarContaPagamento = contaPagamento.sacar(valor);

        Assert.assertFalse(testarSacarContaPagamento);
    }

    @Test
    public void deveTestarSaqueContaPoupancaSemSaldo() {
        double saldo = 100.0;
        double valor = 400;

        ContaPoupanca contaPoupanca= new ContaPoupanca();
        contaPoupanca.setSaldo(saldo);

        boolean testarSacarSaldoPoupanca = contaPoupanca.sacar(valor);

        Assert.assertFalse(testarSacarSaldoPoupanca);
    }
}
