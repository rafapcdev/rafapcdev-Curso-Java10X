package Anvacado;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {


        List<Ninjas> ninjas = new ArrayList<>();
        ninjas.add(new Ninjas("Konoha","Naruto Uzumaki", 17));
        ninjas.add(new Ninjas("Konoha","Jyraia", 55));
        ninjas.add(new Ninjas("Konoha","Shikamaru nara", 19));
        ninjas.add(new Ninjas("Nevoa","Zabusa", 40));
        ninjas.add(new Ninjas("Nevoa","Ninja da nevoa2", 30));
        ninjas.add(new Ninjas("Akatsuki","Tobi", 27));
        ninjas.add(new Ninjas("Akatsuki","Deidara", 12));

        //organizando poe idade
       ninjas.stream()
               .sorted((n1,n2) ->Integer.compare(n1.getIdade(), n2.getIdade()))
               .forEach(System.out::println);

        System.out.println("===================================================");

        //filtrar ataves de aldeia
        ninjas.stream()
               .filter(ninja -> ninja.getAldeia().equalsIgnoreCase("Nevoa"))
               .forEach(System.out::println);

        System.out.println("===================================================");

        //organizando por nome
       ninjas.stream()
               .sorted((n1, n2) ->String.CASE_INSENSITIVE_ORDER.compare(n1.getNome(), n2.getNome()))
               .forEach(System.out::println);
        System.out.println("===================================================");

        ninjas.stream()
                .sorted((n1,n2)-> n1.getNome().compareTo(n2.getNome()))
                .forEach(System.out::println);

        //mostrar e mapear um atributo
        ninjas.stream()
                .map(Ninjas::getNome)
                .forEach(System.out::println);

        System.out.println("===================================================");

        Ninjas ninjaMaisVelho = ninjas.stream()
                .max((n1,n2) -> Integer.compare(n1.getIdade(), n2.getIdade()))
                .orElse(null);
        System.out.println("O Ninja mais velho é:" + ninjaMaisVelho);



    }
}
