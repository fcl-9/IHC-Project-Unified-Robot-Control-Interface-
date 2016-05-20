/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projeto.ihc;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.stage.Stage;


/**
 *
 * @author fabio
 */
public class LoginController implements Initializable {
    
    private Label label;
    @FXML
    private AnchorPane background;
    @FXML
    private Button loginButton;
    @FXML
    private Button helpLoginButton;
    @FXML
    private Button powerButton;
    
    private void handleButtonAction(ActionEvent event) {
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }    

    @FXML
    private void onLoginClicked(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Selecao.fxml"));
        loginButton.getScene().setRoot(root);
    }



    @FXML
    /**
     * Método que fará a interface ser fechada quando se clica no botão com o id
     * powerButton
     */
    private void powerButtonHandle(MouseEvent event) {
        Stage stage = (Stage) powerButton.getScene().getWindow();
        stage.close();
    }

    @FXML
    /**
     * Método que fará a interface ser modificada quando se clica no botão com o id helpLoginButton
     */
    private void helpLoginHandle(MouseEvent event) {
        Stage stage = (Stage) helpLoginButton.getScene().getWindow();
        
//stage.setOpacity(0.8);
    }
    
    
    
}
