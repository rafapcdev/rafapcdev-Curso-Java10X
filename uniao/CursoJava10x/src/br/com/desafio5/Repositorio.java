package br.com.desafio5;

import java.util.ArrayList;
import java.util.List;

public class Repositorio <T>{
    private List<T> itens = new ArrayList<>();

    public void salvar(T item){
        itens.add(item);
    }

    public List<T> listartodos() {
        return itens;

    }

    public List<T> filtrarPorTipo(Class<? extends T>tipo) {
        List<T> filtrados = new ArrayList<>();
        for (T item : itens) {
            if(tipo.isInstance(item)){
                filtrados.add(item);
            }
            
        }
        return filtrados;
    }
}
