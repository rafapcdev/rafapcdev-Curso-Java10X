package br.com.desafio5;

import java.util.Scanner;

public class Main {
    static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        BancoKonoha banco = new BancoKonoha();
        boolean opcao = false;
        int contas = 0;
        ContaBancaria contaLogada = null;

        while (!opcao) {
            if (contaLogada == null) {
                System.out.println("\n------------MENU INICIAL-----------");
                System.out.println("Digite 1 para criar uma nova conta");
                System.out.println("Digite 2 para ver a lista de contas");
                System.out.println("Digite 3 para fazer login");
                System.out.println("Digite 4 para sair");

                int opcaoVerifica = scanner.nextInt();
                scanner.nextLine();
                switch (opcaoVerifica) {
                    case 1:
                        contas++;
                        int nvconta = contas;
                        System.out.println("Obrigado voce escolheu a opcao criar uma nova conta.");
                        System.out.println("escolha (1) para conta corrente\n (2) para conta Pupanca");
                        int v2 = scanner.nextInt();
                        scanner.nextLine();
                        System.out.println("digite seu nome por favor");
                        String n = scanner.nextLine();
                        if (n.trim().isEmpty()) {  // Validação: Nome não vazio
                            System.out.println("Nome inválido. Tente novamente.");
                            contas--;  // Reverte contador
                            break;
                        }
                        if (v2 == 1) {
                            ContaCorrente contaCorrente = new ContaCorrente(nvconta, n, 0.0);
                            banco.adcionarConta(contaCorrente);
                            System.out.println("conta criada com sucesso");
                            break;
                        } else if (v2 == 2) {
                            ContaPoupanca contaPoupanca = new ContaPoupanca(nvconta, n, 0.0);
                            banco.adcionarConta(contaPoupanca);
                            System.out.println("conta poupanca criada com sucesso");
                            break;
                        } else {
                            System.out.println("Opcao Invalida");
                            contas--;
                            break;
                        }
                    case 2:
                        System.out.println("Lista de contas (Set): " + banco.getContas());
                        System.out.println("Mapa de contas (ID -> Conta): " + banco.getMapaDeContas());
                        break;
                    case 3:
                        System.out.println("Digite o número da sua conta:");
                        int idLogin = scanner.nextInt();
                        scanner.nextLine();
                        ContaBancaria contaTentativa = banco.getMapaDeContas().get(idLogin);
                        if (contaTentativa == null) {
                            System.out.println("Conta não encontrada.");
                            break;
                        }
                        System.out.println("Digite seu nome para confirmar:");
                        String nomeLogin = scanner.nextLine();
                        if (contaTentativa.getNome().equalsIgnoreCase(nomeLogin.trim())) {
                            contaLogada = contaTentativa;
                            System.out.println("Login realizado! Bem-vindo, " + contaLogada.getNome() + ".");
                        } else {
                            System.out.println("Nome incorreto.");
                        }
                        break;

                    case 6:
                        opcao = true;
                        System.out.println("Saindo...");
                        break;
                    default:
                        System.out.println("opcao invalida");

                }
            } else {
                System.out.println("\n------------MENU LOGADO-----------");
                System.out.println("Conta logada: " + contaLogada.getNumeroDaConta() + " - " + contaLogada.getNome());
                System.out.println("Digite 1 para depositar na sua conta");
                System.out.println("Digite 2 para ver saldo da sua conta");
                System.out.println("Digite 3 para transferir da sua conta");
                System.out.println("Digite 4 para logout");

                int opcao1 = scanner.nextInt();
                scanner.nextLine();

                switch (opcao1){
                    case 1:
                        System.out.println("voce escolheu a Opcao depositar, " +
                                "\nDigite o numero da conta para deposito ");
                        int idDeposito = scanner.nextInt();
                        ContaBancaria contaDeposito = banco.getMapaDeContas().get(idDeposito);
                        if (contaDeposito == null) {
                            System.out.println("conta nao encontrada");
                            break;
                        }
                        System.out.println("Digite o Valor que deseja depositar na " + contaDeposito);
                        double valorDeposito = scanner.nextDouble();
                        if (valorDeposito <= 0) {
                            System.out.println("valor invalido, valor precisa ser positivo");
                            break;
                        }
                        contaDeposito.depositar(valorDeposito);
                        System.out.println("Deposito realizado com sucesso!! Novo saldo: R$" + contaDeposito.consultarSaldo());
                        break;
                    case 2:
                        System.out.println("Digite o numero da conta para ver saldo: ");
                        int idSaldo = scanner.nextInt();
                        ContaBancaria contaSaldo = banco.getMapaDeContas().get(idSaldo);
                        if (contaSaldo == null) {
                            System.out.println("Conta nao encontrada");
                        } else {
                            System.out.println("Saldo da conta " + idSaldo + ": R$ " + contaSaldo.consultarSaldo());
                        }
                    case 3:
                        System.out.println("Digite o número da conta de destino:");
                        int idDestino = scanner.nextInt();
                        ContaBancaria contaDestino = banco.getMapaDeContas().get(idDestino);
                        if (contaDestino == null) {
                            System.out.println("Conta de destino não encontrada.");
                            break;
                        }
                        if (contaLogada.getNumeroDaConta() == idDestino) {
                            System.out.println("Não é possível transferir para a mesma conta.");
                            break;
                        }
                        System.out.println("Digite o valor a transferir:");
                        double valorTransferencia = scanner.nextDouble();
                        if (valorTransferencia <= 0) {
                            System.out.println("Valor deve ser positivo.");
                            break;
                        }
                        BancoKonoha.Transferencia(contaLogada, contaDestino, valorTransferencia);
                        break;

                    case 4:  // Logout
                        contaLogada = null;
                        System.out.println("Logout realizado. Voltando ao menu inicial.");
                        break;

                    default:
                        System.out.println("Opção inválida.");

                }

            }
        }
        scanner.close();
    }
}