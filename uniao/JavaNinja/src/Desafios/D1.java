package Desafios;

import java.util.Scanner;

public class D1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] ninjas = new String[18];
        int listadeninjas = 0 ;
        int menu = 0;

        while(menu !=3) {
            System.out.println(" 1- cadastrar ninja \n 2-listar \n 3-Sair");
            menu = scanner.nextInt();
            scanner.nextLine();

            switch (menu) {
                case 1:
                    System.out.println("adcionar novo ninja ao livro de cadastro da villa: ");

                    for (int i = listadeninjas; i < ninjas.length; i++) {
                        System.out.println("Nome: ");
                        ninjas[i] = scanner.nextLine();
                        listadeninjas++;

                        System.out.println("deseja add outro ninja? (sim/nao)");
                        String novoninja = scanner.nextLine();

                        if (novoninja.equalsIgnoreCase("nao")) {
                            System.out.println("saindo do loop");
                            break;
                        }
                    }
                    break;
                case 2:
                    System.out.println("Listando ninjas");
                    for (int i = 0; i < listadeninjas; i++) {
                        System.out.println(i + " - " + ninjas[i]);
                    }
                    break;
                case 3:
                    System.out.println("Encerrando o sistema... Até logo!");
                    break;

                default:
                    System.out.println("opcao invalida");
                    break;

            }
        }
        scanner.close();

    }
}
