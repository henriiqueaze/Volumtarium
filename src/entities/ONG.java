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

    public void cadastrarONG() {
        System.out.println("ONG cadastrada: " + this.nome);
    }

    public void atualizarPerfil(String novoNome, String novoEndereco, String novaAreaAtuacao, String novaDescricao, String novoContato) {
        this.nome = novoNome;
        this.endereco = novoEndereco;
        this.areaAtuacao = novaAreaAtuacao;
        this.descricao = novaDescricao;
        this.contato = novoContato;
        System.out.println("Perfil atualizado para a ONG: " + this.nome);
    }

    public void removerONG() {
        System.out.println("ONG removida: " + this.nome);
    }

    public List<Oportunidade> buscarOportunidades() {
        return this.oportunidades;
    }

    public List<Voluntario> listarVoluntarios() {
        List<Voluntario> voluntarios = new ArrayList<>();
        for (Oportunidade oportunidades : this.oportunidades) {
            voluntarios.addAll(oportunidades.getVoluntariosInscritos());
        }
        return voluntarios;
    }

    public void adicionarOportunidade(Oportunidade oportunidade) {
        this.oportunidades.add(oportunidade);
        System.out.println("Oportunidade adicionada para a ONG: " + this.nome);
    }

    public void removerOportunidade(Oportunidade oportunidade) {
        this.oportunidades.remove(oportunidade);
        System.out.println("Oportunidade removida para a ONG: " + this.nome);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getAreaAtuacao() {
        return areaAtuacao;
    }

    public void setAreaAtuacao(String areaAtuacao) {
        this.areaAtuacao = areaAtuacao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getContato() {
        return contato;
    }

    public void setContato(String contato) {
        this.contato = contato;
    }
}