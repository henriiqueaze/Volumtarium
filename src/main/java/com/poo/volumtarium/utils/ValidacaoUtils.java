package com.poo.volumtarium.utils;

import com.poo.volumtarium.model.entities.ONG;
import com.poo.volumtarium.model.entities.Oportunidade;
import com.poo.volumtarium.model.entities.Voluntario;
import com.poo.volumtarium.model.exceptions.FaltandoCampoException;
import com.poo.volumtarium.model.exceptions.ListaVazia;
import com.poo.volumtarium.model.exceptions.MesmoNomeError;
import javafx.application.Platform;
import javafx.scene.control.Alert;

import java.util.ArrayList;

public class ValidacaoUtils {

    public static void validarCamposObrigatorios(Object... campos) throws FaltandoCampoException {
        for (Object campo : campos) {
            if (campo == null) {
                throw new FaltandoCampoException("Todos os campos obrigatórios devem ser preenchidos.");
            }

            if (campo instanceof String && ((String) campo).trim().isEmpty()) {
                throw new FaltandoCampoException("Todos os campos obrigatórios devem ser preenchidos.");
            }
        }
    }

    public static void verificarListas(ArrayList<ONG> ONGs, ArrayList<Voluntario> voluntarios, ArrayList<Oportunidade> oportunidades) throws ListaVazia {
        if (ONGs.isEmpty() && voluntarios.isEmpty() && oportunidades.isEmpty()) {
            throw new ListaVazia("Listas Vazias");
        }
    }

    public static void verificarNome(ArrayList<ONG> ongs, String nomeVerificar) throws FaltandoCampoException {
        for (ONG ong : ongs) {
            if (ong.getNome().equals(nomeVerificar)) {
                throw new FaltandoCampoException("Nome da ONG já existe.");
            }
        }
    }


    public static void exibirMensagemSucesso(String mensagem) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Sucesso");
        alert.setContentText(mensagem);
        alert.showAndWait();
    }

    public static void exibirMensagemErro(String mensagem) {
        Platform.runLater(() -> {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erro");
            alert.setContentText(mensagem);
            alert.showAndWait();
        });
    }

    public static boolean isNumeric(String str) {
        if (str == null) {
            return false;
        }

        try {
            Integer.parseInt(str);
            return true;
        }

        catch (NumberFormatException e) {
            return false;
        }
    }

}
