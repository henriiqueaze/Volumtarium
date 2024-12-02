package com.poo.volumtarium.utils;

import com.poo.volumtarium.model.exceptions.FaltandoCampoException;
import javafx.scene.control.Alert;

public class ValidacaoUtils {

    public static void validarCamposObrigatorios(Object... campos) throws FaltandoCampoException {
        for (Object campo : campos) {
            if (campo instanceof String) {
                if (((String) campo).trim().isEmpty()) {
                    throw new FaltandoCampoException("Todos os campos são obrigatórios.");
                }
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
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Erro");
        alert.setContentText(mensagem);
        alert.showAndWait();
    }
}
