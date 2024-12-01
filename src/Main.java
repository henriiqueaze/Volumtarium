import entities.*;
import Exceptions.*;

import java.util.Scanner;

public class Main {
    private static final Scanner input = new Scanner(System.in);
    private static final Gerenciador gerenciador = new Gerenciador();
    private static boolean sair = false;

    public static void main(String[] args) throws IdadeIncorreta, EntradaNaoEsperada {
        int opcao;

        while (!sair) {
            exibirMenu();
            opcao = input.nextInt();
            input.nextLine();

            switch (opcao) {
                case 1 -> cadastrarONG();
                case 2 -> cadastrarOportunidade();
                case 3 -> cadastrarVoluntario();
                case 4 -> listarONGs();
                case 5 -> listarOportunidades();
                case 6 -> listarVoluntarios();
                case 7 -> inscreverVoluntario();
                case 8 -> sair();
                default -> System.out.println("Opção inválida.");
            }
        }
    }

    private static void exibirMenu() {
        System.out.println("Volumtarium");
        System.out.println("[1] - Cadastrar ONG");
        System.out.println("[2] - Cadastrar Oportunidade");
        System.out.println("[3] - Cadastrar Voluntário");
        System.out.println("[4] - Listar ONGs");
        System.out.println("[5] - Listar Oportunidades");
        System.out.println("[6] - Listar Voluntários");
        System.out.println("[7] - Inscrever Voluntário em Oportunidade");
        System.out.println("[8] - Sair");
        System.out.print("Escolha uma opção: ");
    }

    private static void cadastrarONG() {
        System.out.print("Nome da ONG: ");
        String nome = input.nextLine();
        // Pode usar utilização do Set: É ideal para evitar duplicatas, pois não permite elementos repetidos.
        // List: Pode conter duplicatas, mas permite que você faça buscas explícitas com o método contains.
        // Caso precise de uma lista ordenada, você pode usar um TreeSet no lugar do HashSet.
        // Se precisar associar informações ao nome (ex.: telefone, endereço), use um Map:
        System.out.print("Endereço: ");
        String endereco = input.nextLine();
        System.out.print("Área de atuação: ");
        String areaAtuacao = input.nextLine();
        System.out.print("Descrição: ");
        String descricao = input.nextLine();
        System.out.print("Contato: ");
        String contato = input.nextLine();

        gerenciador.cadastrarONG(nome, endereco, areaAtuacao, descricao, contato);
    }

    private static void cadastrarOportunidade() throws EntradaNaoEsperada {
        if (gerenciador.getOngs().isEmpty()) {
            System.out.println("Nenhuma ONG cadastrada.");
            return;
        }

        System.out.print("Descrição: ");
        String descricao = input.nextLine();
        System.out.print("Requisitos: ");
        String requisitos = input.nextLine();
        System.out.print("Localização: ");
        String localizacao = input.nextLine();

        System.out.println("Escolha uma ONG pelo ID:");
        for (ONG ong : gerenciador.getOngs()) {
            System.out.println(ong.getId() + " - " + ong.getNome());
        }

        int idOng = input.nextInt();
        input.nextLine();

        gerenciador.cadastrarOportunidade(descricao, requisitos, localizacao, idOng);
    }

    private static void listarONGs() {
        gerenciador.listarONGs();
    }

    private static void listarOportunidades() {
        gerenciador.listarOportunidades();
    }

    private static void listarVoluntarios() {
        gerenciador.listarVoluntarios();
    }

    private static void cadastrarVoluntario() throws IdadeIncorreta, EntradaNaoEsperada {
        System.out.print("Nome do voluntário: ");
        String nome = input.nextLine();
        System.out.print("Idade: ");
        int idade = input.nextInt();
        input.nextLine();
        System.out.print("Localização: ");
        String localizacao = input.nextLine();
        System.out.print("Contato: ");
        String contato = input.nextLine();
        System.out.println("Escolha o tipo de voluntário");
        System.out.println("[1] - Voluntário Remoto");
        System.out.println("[2] - Voluntário Local");
        System.out.print("Escolha uma opção: ");
        byte escolhaVoluntario = input.nextByte();
        input.nextLine();
        System.out.print("Habilidades: ");
        String habilidades = input.nextLine();

        gerenciador.cadastrarVoluntario(nome, idade, localizacao, contato, escolhaVoluntario, habilidades);
    }

    private static void inscreverVoluntario() {
        gerenciador.listarVoluntarios();
        System.out.print("ID do voluntário: ");
        int idVoluntario = input.nextInt();
        gerenciador.listarOportunidades();
        System.out.print("ID da oportunidade: ");
        int idOportunidade = input.nextInt();
        input.nextLine();

        try {
            gerenciador.inscreverVoluntario(idVoluntario, idOportunidade);
        }

        catch (EntradaNaoEsperada e) {
            System.out.println(e.getMessage());
        }
    }

    private static void sair() {
        System.out.println("Saindo...");
        sair = true;
    }
}