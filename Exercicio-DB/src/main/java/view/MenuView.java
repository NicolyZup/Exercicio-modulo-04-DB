package view;

import service.UserService;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MenuView {
    private Scanner scanner;
    private UserService userService;

    public MenuView() {
        scanner = new Scanner(System.in);
        userService = new UserService();
    }

    public void menuIniciar() {
        int opcao;
        do {
            menuExibir();
            opcao = opcaoEscolhida();

            switch (opcao) {
                case 1:
                    userService.consultaRebeldes();
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    System.out.println("Encerrando o programa...");
                    break;
                default:
                    System.out.println("Opção inválida, tente novamente.");
                    break;
            }
        } while (opcao != 6);
    }

    public void menuExibir() {
        Scanner entrada = new Scanner(System.in);
        System.out.println("-------------------------------------------");
        System.out.println("Qual operação deseja realizar?");
        System.out.println("(1) Consultar rebeldes");
        System.out.println("(2) Cadastrar rebelde");
        System.out.println("(3) Atualizar localização de rebelde");
        System.out.println("(4) Reportar rebelde traidor");
        System.out.println("(5) Consultar rebeldes traidores");
        System.out.println("(6) Adicionar recurso a rebelde");
        System.out.println("(7) Deletar rebelde");
        System.out.println("(8) Sair do sistema");
        System.out.println("-------------------------------------------");
    }

    public int opcaoEscolhida() {
        try {
            int opcao = scanner.nextInt();
            scanner.nextLine();
            return opcao;
        } catch (InputMismatchException e) {
            System.out.println(e.getMessage());
            scanner.nextLine();
        }
        return 1;
    }
}
