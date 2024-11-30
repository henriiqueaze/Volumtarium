package entities;

import Exceptions.*;

import java.util.ArrayList;

public class Gerenciador {
    private final ArrayList<ONG> ongs = new ArrayList<>();
    private final ArrayList<Oportunidade> oportunidades = new ArrayList<>();
    private final ArrayList<Voluntario> voluntarios = new ArrayList<>();

    public void cadastrarONG(String nome, String endereco, String areaAtuacao, String descricao, String contato) {
        ONG ong = new ONG(ongs.size() + 1, nome, endereco, areaAtuacao, descricao, contato);
        ongs.add(ong);
        System.out.println("ONG cadastrada com sucesso!");
    }

    public void cadastrarOportunidade(String descricao, String requisitos, String localizacao, int idOngEscolhida) throws EntradaNaoEsperada {
        ONG ongEscolhida = encontrarOngPorId(idOngEscolhida);

        if (ongEscolhida != null) {
            Oportunidade oportunidade = new Oportunidade(oportunidades.size() + 1, descricao, requisitos, localizacao, ongEscolhida);
            oportunidades.add(oportunidade);
            ongEscolhida.adicionarOportunidade(oportunidade);
            System.out.println("Oportunidade cadastrada com sucesso!");
        } else {
            System.out.println("ONG não encontrada.");
        }
    }

    public void cadastrarVoluntario(String nome, int idade, String localizacao, String perfil, String contato, byte escolhaVoluntario, String habilidades) throws IdadeIncorreta, EntradaNaoEsperada {
        if (idade < 18 || idade > 60) {
            throw new IdadeIncorreta("Idade não aceita pelos sistemas, apenas acima de 18 anos e menor de 60.");
        }

        Voluntario voluntario = switch (escolhaVoluntario) {
            case 1 -> new VoluntarioRemoto(voluntarios.size() + 1, nome, idade, localizacao, perfil, contato, habilidades);
            case 2 -> new VoluntarioLocal(voluntarios.size() + 1, nome, idade, localizacao, perfil, contato, habilidades);
            default -> throw new EntradaNaoEsperada("Escolha inválida para tipo de voluntário.");
        };

        voluntarios.add(voluntario);
        System.out.println("Voluntário cadastrado com sucesso!");
    }

    public void inscreverVoluntario(int idVoluntarioEscolhido, int idOportunidadeEscolhida) throws EntradaNaoEsperada {
        Voluntario voluntarioEscolhido = encontrarVoluntarioPorId(idVoluntarioEscolhido);
        Oportunidade oportunidadeEscolhida = encontrarOportunidadePorId(idOportunidadeEscolhida);

        if (voluntarioEscolhido == null || oportunidadeEscolhida == null) {
            System.out.println("Voluntário ou oportunidade não encontrados.");
            return;
        }

        oportunidadeEscolhida.inscreverVoluntario(voluntarioEscolhido);
        System.out.println("Voluntário inscrito com sucesso!");
    }

    private Voluntario encontrarVoluntarioPorId(int id) {
        for (Voluntario voluntario : voluntarios) {
            if (voluntario.getId() == id) {
                return voluntario;
            }
        }
        return null;
    }

    private Oportunidade encontrarOportunidadePorId(int id) {
        for (Oportunidade oportunidade : oportunidades) {
            if (oportunidade.getId() == id) {
                return oportunidade;
            }
        }
        return null;
    }

    private ONG encontrarOngPorId(int id) {
        for (ONG ong : ongs) {
            if (ong.getId() == id) {
                return ong;
            }
        }
        return null;
    }

    public void listarONGs() {
        if (ongs.isEmpty()) {
            System.out.println("Nenhuma ONG cadastrada.");
        } else {
            for (ONG ong : ongs) {
                System.out.println("[" + ong.getId() + "] - " + ong.getNome());
            }
        }
    }

    public void listarOportunidades() {
        if (oportunidades.isEmpty()) {
            System.out.println("Nenhuma oportunidade cadastrada.");
        } else {
            for (Oportunidade oportunidade : oportunidades) {
                System.out.println("[" + oportunidade.getId() + "] - " + oportunidade.getDescricao());
            }
        }
    }

    public void listarVoluntarios() {
        if (voluntarios.isEmpty()) {
            System.out.println("Nenhuma oportunidade cadastrada.");
        } else {
            for (Voluntario voluntario : voluntarios) {
                System.out.println("[" + voluntario.getId() + "] - " + voluntario.getNome());
            }
        }
    }


    public ArrayList<ONG> getOngs() {
        return ongs;
    }

    public ArrayList<Oportunidade> getOportunidades() {
        return oportunidades;
    }
}
