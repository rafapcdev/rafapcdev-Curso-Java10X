package br.com.desafio5;

public abstract class ContaBancaria implements Conta{
    private int numeroDaConta;
    private String nome;
    private double saldo;
    private TipoConta tipo;

    public ContaBancaria(double saldo) {
        this.saldo = saldo;
    }
    public ContaBancaria(int numeroDaConta, String nome,double saldo) {
        this.numeroDaConta = numeroDaConta;
        this.nome = nome;
        this.saldo = saldo;
    }

    public int getNumeroDaConta() {
        return numeroDaConta;
    }

    public void setNumeroDaConta(int numeroDaConta) {
        this.numeroDaConta = numeroDaConta;
    }

    public TipoConta getTipo() {
        return tipo;
    }

    public void setTipo(TipoConta tipo) {
        this.tipo = tipo;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public ContaBancaria(int numeroDaConta, String nome, double saldo, TipoConta tipo){
        this(numeroDaConta,nome,saldo);
        this.tipo = tipo;
    }

    @Override
    public abstract double depositar(double valor);

    @Override
    public String toString() {
        return "ContaBancaria{" +
                "numerodaconta=" + numeroDaConta +
                ", nome='" + nome + '\'' +
                "Saldo="+ saldo +
                '}';
    }

    @Override
    public double consultarSaldo() {
        return this.saldo;
    }

    public int getNumerodaconta() {
        return numeroDaConta;
    }

    public void setNumerodaconta(int numerodaconta) {
        this.numeroDaConta = numeroDaConta;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public ContaBancaria() {
    }
}
