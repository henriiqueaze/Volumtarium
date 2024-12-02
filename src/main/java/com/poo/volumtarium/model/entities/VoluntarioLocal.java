package com.poo.volumtarium.model.entities;

public class VoluntarioLocal extends Voluntario {
    private String areaDeAtuacao;

    public VoluntarioLocal(int id, String nome, int idade, String localizacao, String contato, String areaDeAtuacao) {
        super(id, nome, idade, localizacao, contato);
        this.areaDeAtuacao = areaDeAtuacao;
    }

    public String getAreaDeAtuacao() {
        return areaDeAtuacao;
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
        System.out.println("Área de Atuação: " + areaDeAtuacao);
    }
}