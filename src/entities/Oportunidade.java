package entities;

import java.util.ArrayList;
import java.util.List;

public class Oportunidade {
    private int id;
    private String descricao;
    private String requisitos;
    private String localizacao;
    private int idONG;
    private List<Voluntario> voluntariosInscritos;

    public Oportunidade(int id, String descricao, String requisitos, String localizacao, int idONG) {
        this.id = id;
        this.descricao = descricao;
        this.requisitos = requisitos;
        this.localizacao = localizacao;
        this.idONG = idONG;
        this.voluntariosInscritos = new ArrayList<>();
    }

    public void inscreverVoluntario(Voluntario voluntario) {
        this.voluntariosInscritos.add(voluntario);
    }

    public List<Voluntario> listarVoluntariosInscritos() {
        return voluntariosInscritos;
    }

    public int getId() {
        return id;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getRequisitos() {
        return requisitos;
    }

    public String getLocalizacao() {
        return localizacao;
    }

    public int getIdONG() {
        return idONG;
    }

    public List<Voluntario> getVoluntariosInscritos() {
        return voluntariosInscritos;
    }
}
