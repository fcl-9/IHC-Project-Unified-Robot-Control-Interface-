/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projeto.ihc;

import java.awt.Point;
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
import javafx.scene.image.ImageView;
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
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;


/**
 *
 * @author fabio
 */
public class HomeController implements Initializable {
    double orgSceneX, orgSceneY;
    double orgTranslateX, orgTranslateY, curJoyAngle, curJoySize;
    private Label label;
    @FXML
    private AnchorPane background;
    @FXML
    private Pane map;
    @FXML
    private Button helpButton;
    @FXML
    private Button sensorButton;
    @FXML
    private Button garrasButton;
    @FXML
    private Button powerButton;
    @FXML
    private Button settingsButton;
    @FXML
    private Button backButton;
    
    MyBrowser myBrowser;
    @FXML
    private ImageView cam2;
    @FXML
    private ImageView cam3;
    @FXML
    private ImageView cam4;
    @FXML
    private ImageView cam1;
    @FXML
    private Pane camPane2;
    @FXML
    private Pane camPane3;
    @FXML
    private Pane camPane4;
    @FXML
    private Pane camPane1;
    @FXML
    private AnchorPane paneGarraBaixo;
    @FXML
    private AnchorPane paneGarraControl;
    @FXML
    private Circle controlGarra;
    @FXML
    private Circle circleBaixoGarra;
    @FXML
    private AnchorPane paneMovBaixo;
    @FXML
    private AnchorPane paneMovControl;
    @FXML
    private Circle controlMov;
    @FXML
    private Circle circleBaixoMov;
    
    
    private int joyOutputRange = 100;
    private double joySizeGarras, joySizeMov, posicaoX, posicaoY;
    @FXML
    private Button garrasButton1;
    @FXML
    private Text tempoMissao;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ApresentaTempo apresentaTempo = new ApresentaTempo();
        tempoMissao.setText(Float.toString(apresentaTempo.getTempoPassado()));
        myBrowser = new MyBrowser();
        map.getChildren().add(myBrowser);
        cam1.fitWidthProperty().bind(camPane1.widthProperty());
        cam2.fitWidthProperty().bind(camPane2.widthProperty());
        cam3.fitWidthProperty().bind(camPane3.widthProperty());
        cam4.fitWidthProperty().bind(camPane4.widthProperty());
        cam1.fitHeightProperty().bind(camPane1.heightProperty());
        cam2.fitHeightProperty().bind(camPane2.heightProperty());
        cam3.fitHeightProperty().bind(camPane3.heightProperty());
        cam4.fitHeightProperty().bind(camPane4.heightProperty());
        circleBaixoGarra.setFill(new ImagePattern(new Image("/img/joystick.png")));
        circleBaixoMov.setFill(new ImagePattern(new Image("/img/joystick.png")));
        joySizeGarras = circleBaixoGarra.getRadius()/2;
        joySizeMov = circleBaixoMov.getRadius()/2;
    }
    
    @FXML
    /**
     * This method switches the atual screen to the help screen
     */
    private void sensorButtonClicked(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Sensores.fxml"));
        sensorButton.getScene().setRoot(root);
    }
    
    @FXML
    /**
     * This method switches the atual screen to the help screen
     */
    private void garrasButtonClicked(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Garras.fxml"));
        garrasButton.getScene().setRoot(root);
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

    @FXML
    private void controlaGarra(MouseEvent event) {
        double offsetX = event.getSceneX() - orgSceneX;
        double offsetY = event.getSceneY() - orgSceneY;
        double newTranslateX = orgTranslateX + offsetX;
        double newTranslateY = orgTranslateY + offsetY;
        
        curJoyAngle = (float) Math.atan2(newTranslateY, newTranslateX);
        curJoySize = (float) Point.distance(event.getSceneX(), event.getSceneY(),
                orgSceneX, orgSceneY);
        
        if (curJoySize < joySizeGarras) {
            ((Circle)(event.getSource())).setTranslateX(newTranslateX);
            ((Circle)(event.getSource())).setTranslateY(newTranslateY);   
        }
        
        posicaoX = (int) (joyOutputRange * (Math.cos(curJoyAngle)
                * curJoySize) / joySizeGarras);
        posicaoY = (int) (joyOutputRange * (-(Math.sin(curJoyAngle)
                * curJoySize) / joySizeGarras));
        
        System.out.println("X:" + posicaoX + " Y: " + posicaoY);
        
    }
    
    @FXML
    private void tocaControlGarra(MouseEvent event) {
        orgSceneX = event.getSceneX();
        orgSceneY = event.getSceneY();
        orgTranslateX = ((Circle)(event.getSource())).getTranslateX();
        orgTranslateY = ((Circle)(event.getSource())).getTranslateY();
    }

    @FXML
    private void libertaControlGarra(MouseEvent event) {
        ((Circle)(event.getSource())).setTranslateX(orgTranslateX);
        ((Circle)(event.getSource())).setTranslateY(orgTranslateY);
    }
    
     @FXML
    private void controlaMovimento(MouseEvent event) {
        double offsetX = event.getSceneX() - orgSceneX;
        double offsetY = event.getSceneY() - orgSceneY;
        double newTranslateX = orgTranslateX + offsetX;
        double newTranslateY = orgTranslateY + offsetY;
        
        curJoyAngle = (float) Math.atan2(newTranslateY, newTranslateX);
        curJoySize = (float) Point.distance(event.getSceneX(), event.getSceneY(),
                orgSceneX, orgSceneY);
        
        if (curJoySize < joySizeMov) {
            ((Circle)(event.getSource())).setTranslateX(newTranslateX);
            ((Circle)(event.getSource())).setTranslateY(newTranslateY);   
        }
        
        posicaoX = (int) (joyOutputRange * (Math.cos(curJoyAngle)
                * curJoySize) / joySizeMov);
        posicaoY = (int) (joyOutputRange * (-(Math.sin(curJoyAngle)
                * curJoySize) / joySizeMov));
        
        System.out.println("X:" + posicaoX + " Y: " + posicaoY);
        
    }
    
    @FXML
    private void tocaControlMovimento(MouseEvent event) {
        orgSceneX = event.getSceneX();
        orgSceneY = event.getSceneY();
        orgTranslateX = ((Circle)(event.getSource())).getTranslateX();
        orgTranslateY = ((Circle)(event.getSource())).getTranslateY();
    }

    @FXML
    private void libertaControlMovimento(MouseEvent event) {
        ((Circle)(event.getSource())).setTranslateX(orgTranslateX);
        ((Circle)(event.getSource())).setTranslateY(orgTranslateY);
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
