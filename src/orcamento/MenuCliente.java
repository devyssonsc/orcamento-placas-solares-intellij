/**
 *
 */
package orcamento;

import java.util.Scanner;

/**
 *
 */
public class MenuCliente {


    /**
     * @param args
     */
    public static void mainClient(Gerir gestor, String email) {
        Scanner input = new Scanner(System.in);

        int option;

        for(Administrador user:gestor.getListaUtilizadores()) {
            if(user.getEmail().equals(email)) {
                System.out.println("Logado como: " + email);

                do {
                    System.out.println("Como podemos te ajudar?\n"
                            + "1) Consultar dados dos painéis\n"
                            + "2) Consultar o meu orçamento para a instalação de painéis\n"
                            + "0) Log out");
                    option = input.nextInt();
                    input.nextLine();
                } while (option < 0 || option > 2);

                while(option != 0) {
                    switch(option) {
                        case 1:

                            System.out.println("\n********************\n");
                            break;

                        case 2:

                            System.out.println("\n********************\n");
                            break;

                    }

                    do {
                        System.out.println("Como podemos te ajudar?\n"
                                + "1) Consultar dados dos painéis\n"
                                + "2) Consultar o meu orçamento para a instalação de painéis\n"
                                + "0) Log out");
                        option = input.nextInt();
                        input.nextLine();
                    } while (option < 0 || option > 2);
                }
            }
        }
        input.close();	}

}
