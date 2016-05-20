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
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.GridPane;
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
    
    private AnchorPane helpBlackLayout;
    @FXML
    private GridPane mainGrid;
    @FXML
    private TextField idText;
    @FXML
    private TextField passText;
    @FXML
    private GridPane gridUpperBar;
    private GridPane gridButton;
    @FXML
    private GridPane gridMainWindow;
    private AnchorPane helpUpperBlackLayout;
    private AnchorPane buttonBlackScreen;
    @FXML
    private GridPane gridButtons;
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
        helpBlackLayout = new AnchorPane(); 
        gridMainWindow.add(helpBlackLayout, 0, 0,gridMainWindow.REMAINING,gridMainWindow.REMAINING);
        helpBlackLayout.setStyle("-fx-background-color: black;");
        helpBlackLayout.setOpacity(0.6);
        idText.toFront();
        passText.toFront();
        loginButton.toFront();
        helpUpperBlackLayout = new AnchorPane();
        gridUpperBar.add(helpUpperBlackLayout,0,0,gridUpperBar.REMAINING - 1,gridUpperBar.REMAINING);
        helpUpperBlackLayout.setStyle("-fx-background-color: black;");
        helpUpperBlackLayout.setOpacity(0.6);        
        


        buttonBlackScreen = new AnchorPane();
        gridButton.add(buttonBlackScreen, 0, 0,gridButton.REMAINING,gridButton.REMAINING);
        buttonBlackScreen.setStyle("-fx-background-color: black;");
        buttonBlackScreen.setOpacity(0.6);
        powerButton.toFront();
//Bringing the buttons that we want to show mto front
      
    }
    
    
    
}
