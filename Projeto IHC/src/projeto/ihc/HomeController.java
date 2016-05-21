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
import javafx.scene.layout.Pane;
import javafx.scene.layout.Region;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;


/**
 *
 * @author fabio
 */
public class HomeController implements Initializable {
    
    private Label label;
    @FXML
    private AnchorPane background;
    @FXML
    private Pane map;
    @FXML
    private Button helpButton;
    @FXML
    private Button powerButton;
    @FXML
    private Button settingsButton;
    @FXML
    private Button backButton;
    
    MyBrowser myBrowser;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        myBrowser = new MyBrowser();
        map.getChildren().add(myBrowser);
    }
    
    @FXML
    /**
     * This method switches the atual screen to the help screen
     */
    private void helpButtonClicked(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("AjudaPrincipal.fxml"));
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
        Parent root = FXMLLoader.load(getClass().getResource("Definicoes.fxml"));
        settingsButton.getScene().setRoot(root);
    }

    @FXML
    /**
     * This method switches the atual screen to the previous one
     */
    private void backButtonClicked(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Selecao.fxml"));
        settingsButton.getScene().setRoot(root);
    }
}

class MyBrowser extends Region{

    HBox toolbar;

    WebView webView = new WebView();
    WebEngine webEngine = webView.getEngine();

    public WebEngine getWebEngine() {
        return webEngine;
    }

    public MyBrowser(){

        final URL urlGoogleMaps = getClass().getResource("/resources/maps.html");
        webEngine.load(urlGoogleMaps.toExternalForm());

        getChildren().add(webView);

    }    
    
}
