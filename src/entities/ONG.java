package entities;

import java.util.ArrayList;
import java.util.List;

public class ONG {
    private int id;
    private String nome;
    private String endereco;
    private String areaAtuacao;
    private String descricao;
    private String contato;
    private List<Oportunidade> oportunidades;

    public ONG(int id, String nome, String endereco, String areaAtuacao, String descricao, String contato) {
        this.id = id;
        this.nome = nome;
        this.endereco = endereco;
        this.areaAtuacao = areaAtuacao;
        this.descricao = descricao;
        this.contato = contato;
        this.oportunidades = new ArrayList<>();
    }

    public void adicionarOportunidade(Oportunidade oportunidade) {
        this.oportunidades.add(oportunidade);
    }

    public void removerOportunidade(Oportunidade oportunidade) {
        this.oportunidades.remove(oportunidade);
    }

    public List<Oportunidade> listarOportunidades() {
        return this.oportunidades;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getAreaAtuacao() {
        return areaAtuacao;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getContato() {
        return contato;
    }

    public List<Oportunidade> getOportunidades() {
        return oportunidades;
    }
}
