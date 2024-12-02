package com.poo.volumtarium.utils;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.io.IOException;

public class TelaUtils {

    public static void abrirNovaTela(Window windowAtual, String fxmlArquivo, String titulo) {
        try {
            FXMLLoader loader = new FXMLLoader(TelaUtils.class.getResource("/com/poo/volumtarium/views/" + fxmlArquivo));
            Parent root = loader.load();

            Stage novaTela = new Stage();
            novaTela.setTitle(titulo);
            novaTela.setScene(new Scene(root));
            novaTela.show();

            fecharJanelaAtual(windowAtual);
        }

        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void fecharJanelaAtual(Window windowAtual) {
        if (windowAtual instanceof Stage) {
            ((Stage) windowAtual).close();
        }
    }
}
