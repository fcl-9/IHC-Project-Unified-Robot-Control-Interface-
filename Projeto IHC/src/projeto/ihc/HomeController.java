/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projeto.ihc;

import java.awt.Point;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ResourceBundle;
import java.util.TimeZone;
import javafx.animation.FadeTransition;
import javafx.beans.binding.Bindings;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Slider;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.ToggleGroup;
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
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.scene.text.TextFlow;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import javafx.util.Duration;


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
    private Text tempoMissao;
    
    private ApresentaTempo apresentaTempo;
    @FXML
    private RadioButton robotCommunication;
    @FXML
    private RadioButton teamCommunication;
    @FXML
    private RadioButton turnOffCommunication;
    @FXML
    private RadioButton powerOnRobo;
    @FXML
    private RadioButton powerOffRobo;
    @FXML
    private RadioButton lightOn;
    @FXML
    private RadioButton lightOff;
@FXML
    private TabPane tabPane;
    @FXML
    private Button mapButton;
    @FXML
    private Text idEcra;
    @FXML
    private Tab mapTab;
    @FXML
    private Tab funcTab;
    @FXML
    private Text recInfo;
    @FXML
    private Button recButton;    
    private boolean gravar;
    private String robot;
    @FXML
    private Text profAlt;
    private Button plusProf;
    private Button minusProf;
    @FXML
    private TextFlow notificacoesPan;
    @FXML
    private Slider velControl;
    @FXML
    private Text indicaVelocidade;
    @FXML
    private Slider profAltSlide;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        robot = "";
        gravar = false;
        tabPane.getSelectionModel().select(2);
        apresentaTempo = new ApresentaTempo(tempoMissao);
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
        ToggleGroup groupComunicacao = new ToggleGroup();
        ToggleGroup groupOnOff = new ToggleGroup();
        ToggleGroup groupLuzes = new ToggleGroup();
        robotCommunication.setToggleGroup(groupComunicacao);
        teamCommunication.setToggleGroup(groupComunicacao);
        turnOffCommunication.setToggleGroup(groupComunicacao);
        powerOnRobo.setToggleGroup(groupOnOff);
        powerOffRobo.setToggleGroup(groupOnOff);
        lightOn.setToggleGroup(groupLuzes);
        lightOff.setToggleGroup(groupLuzes);
        turnOffCommunication.setSelected(true);
        lightOff.setSelected(true);
        powerOnRobo.setSelected(true);
        recInfo.setOpacity(0);
        mapButton.setOpacity(0);
        mapButton.setDisable(true);
        circleBaixoGarra.setFill(new ImagePattern(new Image("/img/joystick.png")));
        circleBaixoMov.setFill(new ImagePattern(new Image("/img/joystick.png")));
        joySizeGarras = circleBaixoGarra.getRadius()/2;
        joySizeMov = circleBaixoMov.getRadius()/2;
        notificacoesPan.setTextAlignment(TextAlignment.CENTER);
        indicaVelocidade.textProperty().bind(Bindings.format("%.2f Km/h", velControl.valueProperty()));
    }
    
    @FXML
    /**
     * This method switches the atual screen to the help screen
     */
    private void sensorButtonClicked(MouseEvent event) throws IOException {
        apresentaTempo.setRunning(false);
        FXMLLoader  fxmlLoader = new FXMLLoader(getClass().getResource("Sensores.fxml"));
        Parent root = (Parent) fxmlLoader.load();
        helpButton.getScene().setRoot(root);
        SensoresController sens = fxmlLoader.<SensoresController>getController();
        sens.setRobot(robot);
        
    }
    
    @FXML
    /**
     * This method switches the atual screen to the help screen
     */
    private void garrasButtonClicked(MouseEvent event) throws IOException {
        apresentaTempo.setRunning(false);
        FXMLLoader  fxmlLoader = new FXMLLoader(getClass().getResource("Garras.fxml"));
        Parent root = (Parent) fxmlLoader.load();
        helpButton.getScene().setRoot(root);
        GarrasController garras = fxmlLoader.<GarrasController>getController();
        garras.setRobot(robot);
    }
    
    @FXML
    /**
     * This method switches the atual screen to the help screen
     */
    private void helpButtonClicked(MouseEvent event) throws IOException {
        apresentaTempo.setRunning(false);
        FXMLLoader  fxmlLoader = new FXMLLoader(getClass().getResource("AjudaPrincipal.fxml"));
        Parent root = (Parent) fxmlLoader.load();
        helpButton.getScene().setRoot(root);
        AjudaController ajuda = fxmlLoader.<AjudaController>getController();
        ajuda.setRobot(robot);
    }

    @FXML
    /**
     * This method closes the application
     */
    private void powerButtonClicked(MouseEvent event) {
        apresentaTempo.setRunning(false);
        Stage stage = (Stage) powerButton.getScene().getWindow();
        stage.close();
    }

    @FXML
    /**
     * This method switches the atual screen to the settings screen
     */
    private void settingsButtonClicked(MouseEvent event) throws IOException {
        apresentaTempo.setRunning(false);
        FXMLLoader  fxmlLoader = new FXMLLoader(getClass().getResource("Definicoes.fxml"));
        Parent root = (Parent) fxmlLoader.load();
        settingsButton.getScene().setRoot(root);
        DefinicoesController def = fxmlLoader.<DefinicoesController>getController();
        def.setRobot(robot);
    }

    @FXML
    /**
     * This method switches the atual screen to the previous one
     */
    private void backButtonClicked(MouseEvent event) throws IOException {
        apresentaTempo.setRunning(false);
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

    @FXML
    private void alternaCamara2(MouseEvent event) {
        Image imagemCam2 = ((ImageView) event.getSource()).getImage();
        Image camAtual = cam1.getImage();
        cam1.setImage(imagemCam2);
        cam2.setImage(camAtual);
    }

    @FXML
    private void alternaCamara3(MouseEvent event) {
        Image imagemCam3 = ((ImageView) event.getSource()).getImage();
        Image camAtual = cam1.getImage();
        cam1.setImage(imagemCam3);
        cam3.setImage(camAtual);
    }

    @FXML
    private void alternaCamara4(MouseEvent event) {
        Image imagemCam4 = ((ImageView) event.getSource()).getImage();
        Image camAtual = cam1.getImage();
        cam1.setImage(imagemCam4);
        cam4.setImage(camAtual);
    }

    @FXML
    private void goBackToBase(MouseEvent event) {
        tabPane.getSelectionModel().select(1);
        mapButton.setOpacity(100);
        mapButton.setDisable(false);
        idEcra.setText("Retorno à Base");
        mapButton.setText("Retornar à Base");
    }

    @FXML
    private void goPilotoAutomatico(MouseEvent event) {
        tabPane.getSelectionModel().select(1);
        mapButton.setOpacity(100);
        mapButton.setDisable(false);
        idEcra.setText("Piloto Automático");
        mapButton.setText("Ativar Piloto Automático");
    }

    @FXML
    private void camTabClicked(Event event) {
        idEcra.setText("Home");
    }

    @FXML
    private void mapTabClicked(Event event) {
        idEcra.setText("Mapa");
        mapButton.setOpacity(0);
        mapButton.setDisable(true);
    }

    @FXML
    private void funcTabClicked(Event event) {
        idEcra.setText("Funções");
    }

    @FXML
    private void recButtonClicked(MouseEvent event) {
        if (!gravar) {
            recInfo.setOpacity(100);
            gravar = true;
        } else {
            recInfo.setOpacity(0);
            gravar = false;
        }
        
    }
    
    public void setRobot (String name) {
        robot = name;
        if (robot.equals("Waterbot")) {
            cam1.setImage(new Image("/img/cam 1 water.jpg"));
            cam2.setImage(new Image("/img/cam 2 water.jpg"));
            cam3.setImage(new Image("/img/cam 3 water.jpg"));
            cam4.setImage(new Image("/img/cam 4 water.jpg"));
            profAltSlide.setOpacity(100);
            profAlt.setOpacity(100);
            profAlt.setText("Profundidade");
            
        }
        else if (robot.equals("Airbot")){
            profAltSlide.setOpacity(100);
            profAlt.setText("Altitude");
        }
        else {
            profAltSlide.setOpacity(0);
            profAlt.setOpacity(0);
        }
    }
    
    private FadeTransition createFader(Node node) {
        FadeTransition fade = new FadeTransition(Duration.seconds(5), node);
        fade.setFromValue(1);
        fade.setToValue(0);

        return fade;
    }
    
    /**
     * This method writes the given notification on the screen
     */
    public void escreveNotificacao(Text notificacao) {
        notificacao.setFont(Font.font("Balsamiq Sans", 18));
        FadeTransition fader = createFader(notificacao);
        notificacoesPan.getChildren().add(notificacao);
        fader.play();
        fader.setOnFinished(new EventHandler<ActionEvent>() {
		public void handle(ActionEvent event) {
			notificacoesPan.getChildren().remove(notificacao);
		}
	});
    }

    @FXML
    private void ligaRobo(MouseEvent event) {
        cam1.setOpacity(100);
        cam2.setOpacity(100);
        cam3.setOpacity(100);
        cam4.setOpacity(100);
        Text notificacao = new Text ("O Robô foi ligado.\n");
        escreveNotificacao(notificacao);
    }

    @FXML
    private void desligaRobo(MouseEvent event) {
        cam1.setOpacity(0);
        cam2.setOpacity(0);
        cam3.setOpacity(0);
        cam4.setOpacity(0);
        Text notificacao = new Text ("O Robô foi desligado.\n");
        escreveNotificacao(notificacao);
    }

    @FXML
    private void ligaLuzes(MouseEvent event) {
        Text notificacao = new Text ("As luzes do robô foram ligadas.\n");
        escreveNotificacao(notificacao);
    }

    @FXML
    private void desligaLuzes(MouseEvent event) {
        Text notificacao = new Text ("As luzes do robô foram desligadas.\n");
        escreveNotificacao(notificacao);
    }

    @FXML
    private void comunicaEquipa(MouseEvent event) {
        Text notificacao = new Text ("A comunicação com a equipa foi ativada.\n");
        escreveNotificacao(notificacao);
    }

    @FXML
    private void desligaComunicacao(MouseEvent event) {
        Text notificacao = new Text ("A comunicação foi desativada.\n");
        escreveNotificacao(notificacao);
    }

    @FXML
    private void comunicaRobo(MouseEvent event) {
        Text notificacao = new Text ("A comunicação via Robô foi ativada.\n");
        escreveNotificacao(notificacao);
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
