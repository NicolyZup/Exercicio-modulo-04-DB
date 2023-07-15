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
                    userService.consultarRebeldes();
                    break;
                case 2:
                    System.out.println("Informe o nome do rebelde:");
                    String nome = scanner.nextLine();

                    System.out.println("Informe a idade do rebelde:");
                    int idade = scanner.nextInt();
                    scanner.nextLine();

                    System.out.println("Informe o gênero do rebelde (masculino/feminino):");
                    String genero = scanner.nextLine();

                    System.out.println("Informe a localização do rebelde:");
                    String localizacao = scanner.nextLine();

                    userService.adicionarRebelde(nome,idade,genero,localizacao);
                    break;
                case 3:
                    System.out.println("Informe o id do rebelde que deseja alterar localização:");
                    int idRebelde = scanner.nextInt();
                    scanner.nextLine();

                    System.out.println("Informe a nova localização:");
                    String novaLocalizacao = scanner.nextLine();

                    userService.alterarLocalizacao(novaLocalizacao,idRebelde);
                    break;
                case 4:
                    System.out.println("Informe o id do rebelde traidor:");
                    int rebeldeTraidor = scanner.nextInt();

                    userService.reportarRebeldeTraidor(rebeldeTraidor);
                    break;
                case 5:
                    userService.consultarTraidores();
                    break;
                case 6:
                    System.out.println("Informe o id do rebelde que será adicionado recurso:");
                    int idRebeldeRecurso = scanner.nextInt();

                    System.out.println("Recursos disponíveis");
                    System.out.println("--------------------");
                    userService.listarRecursos();
                    System.out.println("Escolha o id do recurso que deseja adicionar ao rebelde:");
                    int escolha = scanner.nextInt();
                    scanner.nextLine();
                    userService.adicionarRecurso(idRebeldeRecurso,escolha);
                    break;
                case 7:
                    System.out.println("Informe o id do rebelde que deseja consultar os recursos:");
                    int idRebeldeConsultaRecursos = scanner.nextInt();

                    userService.consultarRecursosRebelde(idRebeldeConsultaRecursos);
                    break;
                case 8:
                    System.out.println("Informe o id do rebelde que deseja excluir:");
                    int idRebeldeExcluir = scanner.nextInt();

                    userService.excluirRebelde(idRebeldeExcluir);
                    break;
                case 9:
                    System.out.println("Encerrando o programa...");
                    break;
                default:
                    System.out.println("Opção inválida, tente novamente.");
                    break;
            }
        } while (opcao != 9);
    }

    public void menuExibir() {
        Scanner entrada = new Scanner(System.in);
        System.out.println("-------------------------------------------");
        System.out.println("Qual operação deseja realizar?");
        System.out.println("(1) Consultar rebeldes");
        System.out.println("(2) Adicionar rebelde");
        System.out.println("(3) Atualizar localização de rebelde");
        System.out.println("(4) Reportar rebelde traidor");
        System.out.println("(5) Consultar rebeldes traidores");
        System.out.println("(6) Adicionar recurso a rebelde");
        System.out.println("(7) Consultar recurso de rebelde");
        System.out.println("(8) Deletar rebelde");
        System.out.println("(9) Sair do sistema");
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
