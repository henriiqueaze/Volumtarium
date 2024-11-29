import entities.ONG;
import entities.Oportunidade;
import entities.Voluntario;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    //coloquei esses elementos fora do main para serem variaveis globais, para facilitar uso dessas variáveis no código inteiro da classe
    private static final Scanner input = new Scanner(System.in);
    private static final ArrayList<ONG> ongs = new ArrayList<>();
    private static final ArrayList<Oportunidade> oportunidades = new ArrayList<>();
    private static final ArrayList<Voluntario> voluntarios = new ArrayList<>();
    private static boolean sair = false;

    public static void main(String[] args) {
        int opcao;

        while (!sair) {
                exibirMenu();
                opcao = input.nextInt();
                input.nextLine();

            switch (opcao) {
                case 1 -> cadastrarONG();
                case 2 -> cadastrarOportunidade();
                case 3 -> listarONGs();
                case 4 -> listarOportunidades();
                case 5 -> cadastrarVoluntario();
                case 6 -> inscreverVoluntario();
                case 7 -> sair();
                default -> System.out.println("Opção inválida.");
            }
        }
    }

    private static void exibirMenu() {
        System.out.println("Volumtarium");
        System.out.println("[1] - Cadastrar ONG");
        System.out.println("[2] - Cadastrar Oportunidade");
        System.out.println("[3] - Listar ONGs");
        System.out.println("[4] - Listar Oportunidades");
        System.out.println("[5] - Cadastrar Voluntário");
        System.out.println("[6] - Inscrever Voluntário em Oportunidade");
        System.out.println("[7] - Sair");
        System.out.print("Escolha uma opção: ");
    }

    private static void cadastrarONG() {
        System.out.print("Nome da ONG: ");
        String nome = input.nextLine();
        System.out.print("Endereço: ");
        String endereco = input.nextLine();
        System.out.print("Área de atuação: ");
        String areaAtuacao = input.nextLine();
        System.out.print("Descrição: ");
        String descricao = input.nextLine();
        System.out.print("Contato: ");
        String contato = input.nextLine();
                           //lembrar de colocar esse ID para ser autoincrementável
        ONG ong = new ONG(ongs.size() + 1, nome, endereco, areaAtuacao, descricao, contato);
        ongs.add(ong);
        System.out.println("ONG cadastrada com sucesso!");
    }

    private static void cadastrarOportunidade() {
        if (ongs.isEmpty()) {
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

        for (ONG o : ongs) {
            System.out.println(o.getId() + " - " + o.getNome());
        }

        int idOng = input.nextInt();
        input.nextLine();

        ONG ongEscolhida = null;
        for (ONG o : ongs) {
            if (o.getId() == idOng) {
                ongEscolhida = o;
                break;
            }
        }

        if (ongEscolhida != null) {                     //autoincrementar esse ID
            Oportunidade oportunidade = new Oportunidade(oportunidades.size() + 1, descricao, requisitos, localizacao, idOng);
            oportunidades.add(oportunidade);
            ongEscolhida.adicionarOportunidade(oportunidade);
            System.out.println("Oportunidade cadastrada com sucesso!");
        }

        else {
            System.out.println("ONG não encontrada.");
        }
    }

    private static void listarONGs() {
        if (ongs.isEmpty()) {
            System.out.println("Nenhuma ONG cadastrada.");
        }

        else {
            System.out.println("ONGs cadastradas:");
            for (ONG o : ongs) {
                System.out.println("ID: " + o.getId() + ", Nome: " + o.getNome());
            }
        }
    }

    private static void listarOportunidades() {
        if (oportunidades.isEmpty()) {
            System.out.println("Nenhuma oportunidade cadastrada.");
        }

        else {
            System.out.println("Oportunidades cadastradas:");
            for (Oportunidade o : oportunidades) {
                System.out.println("ID: " + o.getId() + ", Descrição: " + o.getDescricao());
            }
        }
    }

    private static void cadastrarVoluntario() {
        System.out.print("Nome do voluntário: ");
        String nome = input.nextLine();
        System.out.print("Idade: ");
        int idade = input.nextInt();
        input.nextLine();
        System.out.print("Localização: ");
        String localizacao = input.nextLine();
        System.out.print("Perfil: ");
        String perfil = input.nextLine();
        System.out.print("Contato: ");
        String contato = input.nextLine();
                                              //Autoincrementar também
        Voluntario voluntario = new Voluntario(voluntarios.size() + 1, nome, idade, localizacao, perfil, contato);
        voluntarios.add(voluntario);
        System.out.println("Voluntário cadastrado com sucesso!");
    }

    private static void inscreverVoluntario() {
        if (voluntarios.isEmpty() || oportunidades.isEmpty()) {
            System.out.println("Não há voluntários ou oportunidades disponíveis.");
            return;
        }

        System.out.println("Escolha um voluntário pelo ID:");
        for (Voluntario voluntario : voluntarios) {
            System.out.println(voluntario.getId() + " - " + voluntario.getNome());
        }
        int idVoluntario = input.nextInt();
        input.nextLine();

        System.out.println("Escolha uma oportunidade pelo ID:");
        for (Oportunidade oportunidade : oportunidades) {
            System.out.println(oportunidade.getId() + " - " + oportunidade.getDescricao());
        }
        int idOportunidade = input.nextInt();
        input.nextLine();

        Voluntario voluntarioEscolhido = null;
        for (Voluntario voluntario : voluntarios) {
            if (voluntario.getId() == idVoluntario) {
                voluntarioEscolhido = voluntario;
                break;
            }
        }

        Oportunidade oportunidadeEscolhida = null;
        for (Oportunidade oportunidade : oportunidades) {
            if (oportunidade.getId() == idOportunidade) {
                oportunidadeEscolhida = oportunidade;
                break;
            }
        }

        if (voluntarioEscolhido != null && oportunidadeEscolhida != null) {
            oportunidadeEscolhida.inscreverVoluntario(voluntarioEscolhido);
            System.out.println("Voluntário inscrito com sucesso!");
        }

        else {
            System.out.println("Voluntário ou oportunidade não encontrada.");
        }
    }

    private static void sair() {
        System.out.println("Saindo do programa...");
        input.close();
        sair = true;
    }
}
