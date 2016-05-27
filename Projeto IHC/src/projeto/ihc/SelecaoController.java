/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projeto.ihc;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author AnaIsabel
 */
public class SelecaoController implements Initializable {

    @FXML
    private AnchorPane background;
    @FXML
    private Button helpButton;
    @FXML
    private Button powerButton;
    @FXML
    private Button settingsButton;
    @FXML
    private Button airButton;
    @FXML
    private Button waterButton;
    @FXML
    private Button earthButton;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    /**
     * This method switches the atual screen to the help screen
     */
    private void helpButtonClicked(MouseEvent event) throws IOException {
        FXMLLoader  fxmlLoader = new FXMLLoader(getClass().getResource("AjudaPrincipal.fxml"));
        Parent root = (Parent) fxmlLoader.load();
        helpButton.getScene().setRoot(root);
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
        FXMLLoader  fxmlLoader = new FXMLLoader(getClass().getResource("Definicoes.fxml"));
        Parent root = (Parent) fxmlLoader.load();
        settingsButton.getScene().setRoot(root);
    }

    @FXML
    /**
     * This method switches the atual screen to the home screen
     */
    private void airButtonClicked(MouseEvent event) throws IOException {
        FXMLLoader  fxmlLoader = new FXMLLoader(getClass().getResource("Home.fxml"));
        Parent root = (Parent) fxmlLoader.load(); 
        HomeController home = fxmlLoader.<HomeController>getController();
        airButton.getScene().setRoot(root);
        home.setRobot("Airbot");
    }

    @FXML
    /**
     * This method switches the atual screen to the home screen
     */
    private void waterButtonClicked(MouseEvent event) throws IOException {
        FXMLLoader  fxmlLoader = new FXMLLoader(getClass().getResource("Home.fxml"));
        Parent root = (Parent) fxmlLoader.load(); 
        HomeController home = fxmlLoader.<HomeController>getController();
        waterButton.getScene().setRoot(root);
        home.setRobot("Waterbot");
    }

    @FXML
    /**
     * This method switches the atual screen to the home screen
     */
    private void earthButtonClicked(MouseEvent event) throws IOException {
        
        FXMLLoader  fxmlLoader = new FXMLLoader(getClass().getResource("Home.fxml"));
        Parent root = (Parent) fxmlLoader.load(); 
        HomeController home = fxmlLoader.<HomeController>getController();
        earthButton.getScene().setRoot(root);
        home.setRobot("Earthbot");
    }
    
    
}
