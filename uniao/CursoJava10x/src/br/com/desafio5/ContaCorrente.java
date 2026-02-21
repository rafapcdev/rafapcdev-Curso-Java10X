package br.com.desafio5;

public class ContaCorrente extends ContaBancaria{
    public ContaCorrente(int numeroDaConta, String nome, double saldo) {
        super(numeroDaConta, nome, saldo, TipoConta.CORRENTE);
    }

    @Override
    public double depositar(double valor) {
        double novosaldo = this.getSaldo() + valor;
        setSaldo(novosaldo);
        return getSaldo();
    }

    public ContaCorrente() {
        super(0.0);
    }
}
