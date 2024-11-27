package entities;

import java.util.Date;

public class Inscricao {
    private int id;
    private Date dataInscricao;
    private Status status;
    private int idVoluntario;
    private int idOportunidade;

    public Inscricao(int id, Date dataInscricao, Status status, int idVoluntario, int idOportunidade) {
        this.id = id;
        this.dataInscricao = dataInscricao;
        this.status = status;
        this.idVoluntario = idVoluntario;
        this.idOportunidade = idOportunidade;
    }

    public void inscreverVoluntario() {
        System.out.println("Voluntário inscrito!");
    }

    public void atualizarStatus(Status novoStatus) {
        this.status = novoStatus;
    }

    public void cancelarInscricao() {
        System.out.println("Inscrição cancelada!");
    }
}