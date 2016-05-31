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
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
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
    private PasswordField passText;
    @FXML
    private GridPane gridUpperBar;
    private GridPane gridButton;
    @FXML
    private GridPane gridMainWindow;
    private AnchorPane helpUpperBlackLayout;
    private AnchorPane buttonBlackScreen;
    private AnchorPane transparentAnchor;
    @FXML
    private GridPane gridButtons;
    private Button leaveHelp;
    
    private Text help_PowerButton;
    private Text help_ExitHelp;
    private Text help_id;
    private Text help_password;
    private Text help_login;
    
    
    
    private void handleButtonAction(ActionEvent event) {
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    

    @FXML
    private void onLoginClicked(MouseEvent event) throws IOException {
        
        if(idText.getText().trim().isEmpty() && passText.getText().trim().isEmpty())
        {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Erro");
            alert.setHeaderText("Os campos de inserção de dados devem estar preenchidos.");
            alert.setContentText("Para efetuar login deve preencher os campos ID com o nome de "
                    + "utilizador e, Palavra passe com a sua palavra passe!");

            alert.showAndWait();
        }
        else if(idText.getText().trim().isEmpty())
        {
           Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Erro");
            alert.setHeaderText("Erro um dos campos de inserção de dados não foi preenchido.");
            alert.setContentText("Para efetuar login deve preencher o campo ID com o seu nome de utilizador");
            alert.showAndWait(); 
        }
        else if (passText.getText().trim().isEmpty())
        {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Erro");
            alert.setHeaderText("Erro um dos campos de inserção de dados não foi preenchido.");
            alert.setContentText("Para efetuar login deve preencher ambos o campo Palavra Passe com a sua palavra passe.");
            alert.showAndWait();
        }
        else
        {
        ContaTempo contaTempo = new ContaTempo();
        contaTempo.start();
        Parent root = FXMLLoader.load(getClass().getResource("Selecao.fxml"));
        loginButton.getScene().setRoot(root);
        }
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
        gridUpperBar.add(helpUpperBlackLayout,0,0,2,1);
        helpUpperBlackLayout.setStyle("-fx-background-color: black;");
        helpUpperBlackLayout.setOpacity(0.6);
        
        buttonBlackScreen = new AnchorPane();
        gridButtons.add(buttonBlackScreen, 0, 0,3,1);
        buttonBlackScreen.setStyle("-fx-background-color: black;");
        buttonBlackScreen.setOpacity(0.6);
        powerButton.toFront();
        
        //Disable buttons funcionalities
        transparentAnchor = new AnchorPane();
        mainGrid.add(transparentAnchor, 0, 0,3,4);
        
        leaveHelp = new Button();
        leaveHelp.setStyle(
"-fx-background-radius: 5em;" +	
"                -fx-min-width: 40px; " +
"                -fx-min-height: 40px;" +
"                -fx-max-width: 40px; " +
"                -fx-max-height: 40px;" +
"                -fx-background-repeat: no-repeat;" + 
"                -fx-background-size: 40px 40px;"+
"                -fx-background-image: url('/img/exitButton.png')"      
        );
        leaveHelp.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                leaveHelpButtonFunction();
            }
        });
        
        AnchorPane.setLeftAnchor(leaveHelp,1220.0);
        AnchorPane.setTopAnchor(leaveHelp,100.0);
        transparentAnchor.getChildren().add(leaveHelp);
        
    help_PowerButton = new Text(1100,80,"Toque aqui para sair da aplicação");
    help_PowerButton.setFill(Color.WHITE);
    help_ExitHelp = new Text(1110,160,"Toque aqui para sair da ajuda");
    help_ExitHelp.setFill(Color.WHITE);
    help_id = new Text(950,505,"1) Introduza o seu nome de utilizador");
    help_id.setFill(Color.WHITE);
    help_password = new Text(950,590,"2) Introduza a sua palavra passe");
    help_password.setFill(Color.WHITE);
    help_login = new Text(775,655,"3) Toque em login para iniciar sessão");
    help_login.setFill(Color.WHITE);  
        
    transparentAnchor.getChildren().add(help_PowerButton);
    transparentAnchor.getChildren().add(help_ExitHelp);
    transparentAnchor.getChildren().add(help_id);
    transparentAnchor.getChildren().add(help_password);
    transparentAnchor.getChildren().add(help_login);
        
    }
    
    private void leaveHelpButtonFunction(){
     helpBlackLayout.setStyle("-fx-background-color: transparent;");
     helpBlackLayout.setOpacity(1);
     helpUpperBlackLayout.setStyle("-fx-background-color: transparent;");
     helpUpperBlackLayout.setOpacity(1);
     buttonBlackScreen.setStyle("-fx-background-color: transparent;");
     buttonBlackScreen.setOpacity(1);
     transparentAnchor.getChildren().remove(leaveHelp);
     mainGrid.getChildren().remove(transparentAnchor);
     powerButton.toFront();
     helpLoginButton.toFront();
    }
    
}
