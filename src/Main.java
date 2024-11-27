
import entities.ONG;
import entities.Oportunidade;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<ONG> ongs = new ArrayList<>();
        ArrayList<Oportunidade> oportunidades = new ArrayList<>();
        int opcao;

        do {
            System.out.println("Volumtarium");
            System.out.println("[1] - Cadastrar ONG");
            System.out.println("[2] - Cadastrar Oportunidade");
            System.out.println("[3] - Listar ONGs");
            System.out.println("[4] - Listar Oportunidades");
            System.out.println("[5] - Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    System.out.println("Cadastro de ONG");
                    System.out.print("Nome: ");
                    String nome = scanner.nextLine();
                    System.out.print("Endereço: ");
                    String endereco = scanner.nextLine();
                    System.out.print("Área de atuação: ");
                    String areaAtuacao = scanner.nextLine();
                    System.out.print("Descrição: ");
                    String descricao = scanner.nextLine();
                    System.out.print("Contato: ");
                    String contato = scanner.nextLine();

                    ONG ong = new ONG(ongs.size() + 1, nome, endereco, areaAtuacao, descricao, contato);
                    ongs.add(ong);
                    System.out.println("ONG cadastrada com sucesso!");
                    break;

                case 2:
                    if (ongs.isEmpty()) {
                        System.out.println("Nenhuma ONG cadastrada.");

                    }
                    
                    else {
                        System.out.println("Cadastro de Oportunidade");
                        System.out.print("Descrição: ");
                        String descOportunidade = scanner.nextLine();
                        System.out.print("Requisitos: ");
                        String requisitos = scanner.nextLine();
                        System.out.print("Localização: ");
                        String localizacao = scanner.nextLine();
                        System.out.println("Escolha uma ONG pelo ID:");

                        for (ONG o : ongs) {
                            System.out.println(o.getId() + " - " + o.getNome());
                        }

                        int idOng = scanner.nextInt();
                        scanner.nextLine();

                        ONG ongEscolhida = null;
                        for (ONG o : ongs) {
                            if (o.getId() == idOng) {
                                ongEscolhida = o;
                                break;
                            }
                        }

                        if (ongEscolhida != null) {
                            Oportunidade oportunidade = new Oportunidade(oportunidades.size() + 1, descOportunidade, requisitos, localizacao, idOng);
                            oportunidades.add(oportunidade);
                            ongEscolhida.adicionarOportunidade(oportunidade);
                            System.out.println("Oportunidade cadastrada com sucesso!");
                        }

                        else {
                            System.out.println("ONG não encontrada.");
                        }
                    }

                    break;

                case 3:
                    System.out.println("Lista de ONGS");
                    if (ongs.isEmpty()) {
                        System.out.println("Nenhuma ONG cadastrada.");
                    }

                    else {
                        for (ONG o : ongs) {
                            System.out.println("ID: " + o.getId() + ", Nome: " + o.getNome());
                        }
                    }

                    break;

                case 4:
                    System.out.println("Lista de Oportunidades");
                    if (oportunidades.isEmpty()) {
                        System.out.println("Nenhuma oportunidade cadastrada.");
                    }

                    else {
                        for (Oportunidade o : oportunidades) {
                            System.out.println("ID: " + o.getId() + ", Descrição: " + o.getDescricao());
                        }
                    }

                    break;

                case 5:
                    System.out.println("Saindo do programa...");
                    break;

                default:
                    System.out.println("Opção inválida.");
            }
        }

        while (opcao != 5);

        scanner.close();
    }
}

