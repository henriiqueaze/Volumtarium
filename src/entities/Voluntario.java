package entities;

public abstract class Voluntario {
    protected int id;
    protected String nome;
    protected int idade;
    protected String localizacao;
    protected String perfil;
    protected String contato;

    public Voluntario(int id, String nome, int idade, String localizacao, String perfil, String contato){
        this.id = id;
        this.nome = nome;
        this.idade = idade;
        this.localizacao = localizacao;
        this.perfil = perfil;
        this.contato = contato;
    }
    public abstract void
        atualizarPerfil();

    public abstract void
        buscarOportunidade();

    public abstract void
        inscreverEmOportunidade(Oportunidade oportunidade);
}
