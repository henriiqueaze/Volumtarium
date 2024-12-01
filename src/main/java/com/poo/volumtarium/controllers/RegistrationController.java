package com.poo.volumtarium.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.TextArea;

public class RegistrationController {
    @FXML
    private TextField orgNameField;
    @FXML
    private TextField addressField;
    @FXML
    private TextField areaField;
    @FXML
    private TextField contactField;
    @FXML
    private TextArea descriptionField;

    // Método que será chamado ao clicar no botão "Salvar"
    @FXML
    private void handleSave() {
        String orgName = orgNameField.getText();
        String address = addressField.getText();
        String area = areaField.getText();
        String contact = contactField.getText();
        String description = descriptionField.getText();

        // Aqui você pode processar os dados, como salvar ou validar
        System.out.println("Organização: " + orgName);
        System.out.println("Endereço: " + address);
        System.out.println("Área de Atuação: " + area);
        System.out.println("Contato: " + contact);
        System.out.println("Descrição: " + description);
    }
}
