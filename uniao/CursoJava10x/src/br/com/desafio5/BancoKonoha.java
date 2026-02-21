package br.com.desafio5;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class BancoKonoha {
    private List<ContaBancaria> contas = new ArrayList<>();
    private HashMap<Integer, ContaBancaria> mapaDeContas = new HashMap<>();

    public void adcionarConta(ContaBancaria conta){
        if (contas.contains(contas)){
            System.out.println("Conta com número " + conta.getNumeroDaConta() + " já existe. Não adicionada.");
        }else {
            contas.add(conta);
            mapaDeContas.put(conta.getNumeroDaConta(), conta);
            System.out.println("Conta Criada com sucesso !!!");
        }

    }
    public <T extends ContaBancaria> List<T>filtrarContasPorTipo(Class<T> tipo){
        List<T> filtradas = new ArrayList<>();
        for (ContaBancaria conta : contas ){
            if (tipo.isInstance(conta)){
                filtradas.add(tipo.cast(conta));
            }
        }
        return filtradas;
    }
    public ContaBancaria buscarContaPorId(int id){
        return mapaDeContas.get(id);
    }

    public static void Transferencia(ContaBancaria origin,ContaBancaria destino, double valor){
        if(origin.consultarSaldo() > valor){
            origin.depositar(-valor);
            destino.depositar(valor);
            System.out.println("Transferencia realizada com sucesso.\n a conta de destino: "+destino+ "\n recebeu o valor de: " + valor+ " \n da conta de origen; "+ origin);
        } else {
            System.out.println("tranferencia negada por falta de saldo");
        }
    }

    public List<ContaBancaria> getContas() {
        return contas;
    }

    public void setContas(List<ContaBancaria> contas) {
        this.contas = contas;
    }

    public HashMap<Integer, ContaBancaria> getMapaDeContas() {
        return mapaDeContas;
    }

    public void setMapaDeContas(HashMap<Integer, ContaBancaria> mapaDeContas) {
        this.mapaDeContas = mapaDeContas;
    }
}
