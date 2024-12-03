package com.poo.volumtarium.model.entities;

public class VoluntarioLocal extends Voluntario {

    public VoluntarioLocal(int id, String nome, int idade, String localizacao, String contato) {
        super(id, nome, idade, localizacao, contato);
    }


    @Override
    public void inscreverEmOportunidade(Oportunidade oportunidade) {
        oportunidade.inscreverVoluntario(this);
        System.out.println(getNome() + " foi inscrito na oportunidade " + oportunidade.getDescricao() + " presencialmente.");
    }

    @Override
    public void exibirInformacoes() {
        System.out.println("Voluntário Local");
        System.out.println("ID: " + getId());
        System.out.println("Nome: " + getNome());
        System.out.println("Idade: " + getIdade());
        System.out.println("Localização: " + getLocalizacao());
        System.out.println("Contato: " + getContato());
    }
}