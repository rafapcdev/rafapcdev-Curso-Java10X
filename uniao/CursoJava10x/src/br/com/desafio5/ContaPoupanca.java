package br.com.desafio5;

public class ContaPoupanca extends ContaBancaria{

    public ContaPoupanca(int numeroDaConta, String nome, double saldo) {
        super(numeroDaConta, nome, saldo, TipoConta.POUPANCA);
    }

    public ContaPoupanca() {
        super(0.0);
    }

    @Override
    public double depositar(double valor) {
        double valorComtaxa = valor - (valor * 0.01);
        setSaldo(getSaldo()+ valorComtaxa);


        return getSaldo();
    }
}

