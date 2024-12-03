package com.poo.volumtarium.model.entities;

import java.util.ArrayList;
import java.util.List;

public class Oportunidade {
    private int id;
    private String descricao;
    private String requisitos;
    private ONG ONG;
    private List<Voluntario> voluntariosInscritos;

    public Oportunidade(String descricao, String requisitos, ONG ONG) {
        this.descricao = descricao;
        this.requisitos = requisitos;
        this.ONG = ONG;
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


    public ONG getIdONG() {
        return ONG;
    }

    public List<Voluntario> getVoluntariosInscritos() {
        return voluntariosInscritos;
    }
}
