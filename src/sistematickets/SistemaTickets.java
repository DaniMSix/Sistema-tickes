/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistematickets;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

/**
 *
 * @author Usuario
 */
public class SistemaTickets extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("vistas/FXMLInicio.fxml"));
        Scene escenario = new Scene(root);
        stage.setResizable(false);
        stage.getIcons().add(new Image("sistematickets/img/usuarios.png"));
        stage.setScene(escenario);
        stage.setTitle("Inicio de Sesión");
        stage.show();
    }
    
    public static void main(String[] args) {
        launch(args);
    }
    
}
