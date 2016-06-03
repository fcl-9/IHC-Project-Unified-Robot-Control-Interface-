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
import javafx.stage.Stage;


/**
 *
 * @author fabio
 */
public class DefinicoesController implements Initializable {
    
    private Label label;
    @FXML
    private AnchorPane background;
    @FXML
    private Button helpButton;
    @FXML
    private Button powerButton;
    @FXML
    private Button backButton;
    
    private String robot;
    
    private CommonButtons comBtn;
    
    private void handleButtonAction(ActionEvent event) {
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        robot = "";
        comBtn = new CommonButtons();
    }  
    
    @FXML
    /**
     * This method switches the atual screen to the help screen
     */
    private void helpButtonClicked(MouseEvent event) throws IOException {
        comBtn.askHelp(helpButton, background, robot);
    }

    @FXML
    /**
     * This method closes the application
     */
    private void powerButtonClicked(MouseEvent event) {
        comBtn.closeApp(powerButton);
    }

    @FXML
    /**
     * This method switches the atual screen to the previous one
     */
    private void backButtonClicked(MouseEvent event) throws IOException {
        FXMLLoader  fxmlLoader = new FXMLLoader(getClass().getResource("Home.fxml"));
        Parent root = (Parent) fxmlLoader.load(); 
        backButton.getScene().setRoot(root);
        background.getChildren().clear();
        if (robot.equals("Waterbot")) {
            HomeController home = fxmlLoader.<HomeController>getController();
            home.setRobot("Waterbot");
        }
    }
    
    /**
     * This method will indicate the robot that is select because of the transitions to previous screens
     * @param name 
     */
    public void setRobot (String name) {
        robot = name;
    }
}
