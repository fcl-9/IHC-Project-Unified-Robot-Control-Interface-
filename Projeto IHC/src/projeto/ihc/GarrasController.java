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
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;


/**
 *
 * @author fabio
 */
public class GarrasController implements Initializable {
    
    private Label label;
    @FXML
    private AnchorPane background;
    @FXML
    private Button helpButton;
    @FXML
    private Button powerButton;
    @FXML
    private Button settingsButton;
    @FXML
    private Button backButton;
    
    private String robot;
    @FXML
    private HBox pos1;
    
    private void handleButtonAction(ActionEvent event) {
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        robot = "";

    }    
    
    @FXML
    /**
     * This method switches the atual screen to the help screen
     */
    private void helpButtonClicked(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("AjudaPrincipal.fxml"));
        helpButton.getScene().setRoot(root);
        background.getChildren().clear();
    }

    @FXML
    /**
     * This method closes the application
     */
    private void powerButtonClicked(MouseEvent event) {
        Stage stage = (Stage) powerButton.getScene().getWindow();
        stage.close();
    }

    @FXML
    /**
     * This method switches the atual screen to the settings screen
     */
    private void settingsButtonClicked(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Definicoes.fxml"));
        settingsButton.getScene().setRoot(root);
        background.getChildren().clear();
    }

    @FXML
    /**
     * This method switches the atual screen to the previous one
     */
    private void backButtonClicked(MouseEvent event) throws IOException {
        FXMLLoader  fxmlLoader = new FXMLLoader(getClass().getResource("Home.fxml"));
        Parent root = (Parent) fxmlLoader.load(); 
        backButton.getScene().setRoot(root);
        HomeController home = fxmlLoader.<HomeController>getController();
        if (robot.equals("Waterbot")) {
            
            home.setRobot("Waterbot");
        }
        else if (robot.equals("Airbot")) {
            home.setRobot("Airbot");
        }
        else {
            home.setRobot("EarthBot");
        }
        background.getChildren().clear();
    }
    
    public void setRobot (String name) {
        robot = name;
    }

    @FXML
    private void posicao1(MouseEvent event) throws IOException {
        FXMLLoader  fxmlLoader = new FXMLLoader(getClass().getResource("Home.fxml"));
        Parent root = (Parent) fxmlLoader.load(); 
        backButton.getScene().setRoot(root);
        background.getChildren().clear();
        HomeController home = fxmlLoader.<HomeController>getController();
        if (robot.equals("Waterbot")) {
           
            home.setRobot("Waterbot");
        }
        else if (robot.equals("Airbot")) {
            home.setRobot("Airbot");
        }
        else {
            home.setRobot("EarthBot");
        }
        Text notificacao = new Text ("A garra assumiu a posição 1.\n");
        home.escreveNotificacao(notificacao);
    }
}
