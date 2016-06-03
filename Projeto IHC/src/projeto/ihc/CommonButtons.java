package projeto.ihc;

import java.io.IOException;
import java.util.Optional;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * This class has some methods that are common between all the screens like in the buttons
 * 
 * @author vmcba
 */
public class CommonButtons {
    public void closeApp (Button btn) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.initStyle(StageStyle.UNDECORATED);
        alert.initOwner(btn.getScene().getWindow());
        alert.setTitle("Sair da Aplicação");
        alert.setHeaderText("Está prestes a fechar a aplicação.");
        alert.setContentText("Deseja Continuar?");
        
        Button okButton = (Button) alert.getDialogPane().lookupButton( ButtonType.OK );
        okButton.setText("Sim");
        Button noButton = (Button) alert.getDialogPane().lookupButton( ButtonType.CANCEL );
        noButton.setText("Não");  

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK){
            // ... user chose OK
            alert.close();
            Stage stage = (Stage) btn.getScene().getWindow();
            stage.close();
        } else {
            // ... user chose CANCEL or closed the dialog
            alert.close();
        }
    }
    
    public void askHelp(Button btn, AnchorPane background, String robot) throws IOException{
        FXMLLoader  fxmlLoader = new FXMLLoader(getClass().getResource("AjudaPrincipal.fxml"));
        Parent root = (Parent) fxmlLoader.load();
        btn.getScene().setRoot(root);
        background.getChildren().clear();
        AjudaController ajuda = fxmlLoader.<AjudaController>getController();
        ajuda.setRobot(robot);
    }
    
    public void goToSettings (Button btn, AnchorPane background, String robot) throws IOException {
        FXMLLoader  fxmlLoader = new FXMLLoader(getClass().getResource("Definicoes.fxml"));
        Parent root = (Parent) fxmlLoader.load();
        btn.getScene().setRoot(root);
        background.getChildren().clear();
        DefinicoesController def = fxmlLoader.<DefinicoesController>getController();
        def.setRobot(robot);
    }
}
