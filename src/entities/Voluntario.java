package entities;

public abstract class Voluntario {
    private int id;
    private String nome;
    private int idade;
    private String localizacao;
    private String perfil;
    private String contato;

    public Voluntario(int id, String nome, int idade, String localizacao, String perfil, String contato) {
        this.id = id;
        this.nome = nome;
        this.idade = idade;
        this.localizacao = localizacao;
        this.perfil = perfil;
        this.contato = contato;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public int getIdade() {
        return idade;
    }

    public String getLocalizacao() {
        return localizacao;
    }

    public String getPerfil() {
        return perfil;
    }

    public String getContato() {
        return contato;
    }

    public abstract void inscreverEmOportunidade(Oportunidade oportunidade);

    public abstract void exibirInformacoes();
}