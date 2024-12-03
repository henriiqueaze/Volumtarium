package com.poo.volumtarium.utils;

import com.poo.volumtarium.model.exceptions.FaltandoCampoException;
import javafx.application.Platform;
import javafx.scene.control.Alert;

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
        } catch (NumberFormatException e) {
            return false;
        }
    }

}
