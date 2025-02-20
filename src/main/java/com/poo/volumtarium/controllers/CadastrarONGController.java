package com.poo.volumtarium.controllers;

import com.poo.volumtarium.model.entities.Gerenciador;
import com.poo.volumtarium.model.entities.ONG;
import com.poo.volumtarium.model.exceptions.FaltandoCampoException;
import com.poo.volumtarium.model.exceptions.ListaVazia;
import com.poo.volumtarium.utils.TelaUtils;
import com.poo.volumtarium.utils.ValidacaoUtils;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

public class CadastrarONGController {

    @FXML
    private ImageView voltar;

    @FXML
    private Button salvar;

    @FXML
    private TextField nomeField;

    @FXML
    private TextField contatoField;

    @FXML
    private TextField enderecoField;

    @FXML
    private TextField atuacaoField;

    @FXML
    private TextField descricaoField;

    private Gerenciador gerenciador;

    public void initialize() {
        this.gerenciador = Gerenciador.getInstance();
    }

    @FXML
    public void onSalvarAction() {
        try {
            ONG novaOng = criarONGAPartirCampos();

            ValidacaoUtils.verificarNome(gerenciador.getOngs(), novaOng.getNome());

            ONG ong = new ONG(0, novaOng.getNome(), novaOng.getEndereco(), novaOng.getAreaAtuacao(), novaOng.getDescricao(), novaOng.getContato());
            gerenciador.addOng(ong);
            System.out.println("ONG criada com sucesso: " + novaOng);

            ValidacaoUtils.exibirMensagemSucesso("ONG cadastrada com sucesso!");
        }

        catch (FaltandoCampoException e) {
            ValidacaoUtils.exibirMensagemErro("Erro ao cadastrar ONG: " + e.getMessage());
        }
    }


    private ONG criarONGAPartirCampos() throws FaltandoCampoException {
        int id = 0;
        String nome = nomeField.getText();
        String endereco = enderecoField.getText();
        String areaAtuacao = atuacaoField.getText();
        String contato = contatoField.getText();
        String descricao = descricaoField.getText();

        ValidacaoUtils.validarCamposObrigatorios(nome, endereco, areaAtuacao, descricao, contato);

        return new ONG(id, nome, endereco, areaAtuacao, descricao, contato);
    }

    @FXML
    public void onVoltarAction() {
        TelaUtils.abrirNovaTela(voltar.getScene().getWindow(), "index.fxml", "Menu Principal");
    }

}
