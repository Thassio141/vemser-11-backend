package com.br.vemser;

import com.br.vemser.ContaCorrente;
import org.junit.Assert;
import org.junit.Test;

// caso de testes da minha conta corrente
public class ContaCorrenteTest {

    @Test
    public void deveTestarDepositoComSucesso() {
        // SETUP iniciar variáveis do meu teste...
        double saldo = 2000.0;
        double valorDeposito = 1000.0;
        double resultado = 3000.0;

        ContaCorrente contaCorrente = new ContaCorrente();
        contaCorrente.setSaldo(saldo);

        // ACT ... executar a ação
        boolean conseguiuDepositar = contaCorrente.depositar(valorDeposito);

        // ASSERT ... verificar o resultado

        // operacao
        Assert.assertTrue(conseguiuDepositar);
//        Assert.assertFalse(!conseguiuDepositar);
//        Assert.assertEquals(ESPERADO, VALOR);

        // saldo ESPERADO == VALOR
        Assert.assertEquals(resultado, contaCorrente.getSaldo(), 0);
    }

    @Test
    public void deveTestarDepositoComValoresNegativos() {
        // SETUP iniciar variáveis do meu teste...
        double saldo = 2000.0;
        double valorDeposito = -50.0;

        ContaCorrente contaCorrente = new ContaCorrente();
        contaCorrente.setSaldo(saldo);

        // ACT ... executar a ação
        boolean conseguiuDepositar = contaCorrente.depositar(valorDeposito);

        // ASSERT ... verificar o resultado

        // operacao
        Assert.assertFalse(conseguiuDepositar);

        // saldo ESPERADO == VALOR
        Assert.assertEquals(saldo, contaCorrente.getSaldo(), 0);
    }
}
