package entities;

import java.util.ArrayList;
import java.util.List;

public class Oportunidade {
    private int id;
    private String descricao;
    private String requisitos;
    private String localizacao;
    private int idONG;
    private final List<Voluntario> voluntariosInscritos;

    public Oportunidade(int id, String descricao, String requisitos, String localizacao, int idONG) {
        this.id = id;
        this.descricao = descricao;
        this.requisitos = requisitos;
        this.localizacao = localizacao;
        this.idONG = idONG;
        this.voluntariosInscritos = new ArrayList<>();
    }

    public void cadastrarOportunidade() {
        System.out.println("Oportunidade cadastrada: " + this.descricao);
    }

    public void atualizarOportunidade(String novaDescricao, String novosRequisitos, String novaLocalizacao) {
        this.descricao = novaDescricao;
        this.requisitos = novosRequisitos;
        this.localizacao = novaLocalizacao;
        System.out.println("Oportunidade atualizada: " + this.descricao);
    }

    public void removerOportunidade() {
        System.out.println("Oportunidade removida: " + this.descricao);
    }

    public List<Voluntario> listarVoluntariosInscritos() {
        return this.voluntariosInscritos;
    }

    public void inscreverVoluntario(Voluntario voluntario) {
        this.voluntariosInscritos.add(voluntario);
        System.out.println("Voluntário inscrito na oportunidade: " + this.descricao);
    }

    public void removerVoluntario(Voluntario voluntario) {
        this.voluntariosInscritos.remove(voluntario);
        System.out.println("Voluntário removido da oportunidade: " + this.descricao);
    }

    public List<Voluntario> getVoluntariosInscritos() {
        return voluntariosInscritos;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getRequisitos() {
        return requisitos;
    }

    public void setRequisitos(String requisitos) {
        this.requisitos = requisitos;
    }

    public String getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(String localizacao) {
        this.localizacao = localizacao;
    }

    public int getIdONG() {
        return idONG;
    }

    public void setIdONG(int idONG) {
        this.idONG = idONG;
    }
}