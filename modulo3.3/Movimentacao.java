package com.br.vemser;

public interface Movimentacao {
    boolean sacar(double valor);
    boolean depositar(double valor);
    boolean transferir(com.br.vemser.Conta conta, double valor);
}
