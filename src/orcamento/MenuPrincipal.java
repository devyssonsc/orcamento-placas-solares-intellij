/**
 *
 */
package orcamento;

import java.util.Scanner;


/**
 *
 */
public class MenuPrincipal {

    /**
     * @param args
     */
    public static void main(String[] args) {
        Gerir gestor = new Gerir();

        Scanner input = new Scanner(System.in);

        int signOption;
        String email = "";
        String password;

        Cliente devysson = new Cliente("Devysson", "devyssonsc@gmail.com", "Devyla#03", 200, (double) 50);
        gestor.inserirUsuario(devysson);

        System.out.println(gestor.getListaUtilizadores().getFirst().getUserId());

        do {
            System.out.println("Seja bem-vindo! é um prazer tê-lo conosco.");
            System.out.println("1) Fazer login");
            System.out.println("2) Criar um perfil");
            signOption = input.nextInt();
            input.nextLine();
        } while(signOption < 0 && signOption <= 2);

        if(signOption == 1) {
            boolean loginRealizado = false;
            while(!loginRealizado) {
                do {
                    System.out.print("Email: ");
                    email = input.nextLine();
                }while(!gestor.validarEmail(email));

                do {
                    System.out.print("Senha: ");
                    password = input.nextLine();
                } while(password.equals("")); //gestor.validarSenha(password)

                loginRealizado = gestor.fazerLogin(email, password);
            }
            System.out.println("Login realizado!\n");
            MenuCliente.mainClient(gestor, email);
        } else {
            String nome;
            int consumoUltimoMes;
            int pagamentoUltimoMes;


            do {
                System.out.println("Nome: ");
                nome = input.nextLine();
            } while(nome.equals(""));

            do {
                System.out.println("Email: ");
                email = input.nextLine();
            } while(!gestor.validarEmail(email));

            do {
                System.out.println("Senha:\n"
                        + "-Pelo menos 8 caractéres.\n"
                        + "-Pelo menos 1 letra maiúscula.\n"
                        + "-Pelo menos 1 letra minúscula.\n"
                        + "-Pelo menos 1 número\n"
                        + "-Pelo menos 1 caractere especial (@#$%&)\n");
                password = input.nextLine();
            } while(!gestor.validarSenha(password));

            do {
                System.out.println("Quantos Kwh foram consumidos na rua residência no último mês?: ");
                consumoUltimoMes = input.nextInt();
                input.nextLine();
            } while(consumoUltimoMes < 0);

            do {
                System.out.println("Qual foi o valor da fatura paga nesse último mês?: ");
                pagamentoUltimoMes = input.nextInt();
                input.nextLine();
            } while(pagamentoUltimoMes < 0);

            Cliente newCliente = new Cliente(nome, email, password, consumoUltimoMes, pagamentoUltimoMes);
            gestor.getListaUtilizadores().add(newCliente);

            MenuCliente.mainClient(gestor, gestor.getListaUtilizadores().getLast().getEmail());
        }

        input.close();
    }

}