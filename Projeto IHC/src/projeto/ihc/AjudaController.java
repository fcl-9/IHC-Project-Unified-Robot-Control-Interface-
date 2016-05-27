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
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author AnaIsabel
 */
public class AjudaController implements Initializable {

    @FXML
    private AnchorPane background;
    @FXML
    private Button sair;
    @FXML
    private Button irDefinicoes;
    @FXML
    private Button retorna;
    @FXML
    private Button camaras;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    /**
     * Este método fecha a interface
     */
    private void sairInterface(MouseEvent event) 
    {
        //stage é a janela, no botao vamos buscar a cena e a janela, para depois puder fechar
        Stage stage = (Stage) sair.getScene().getWindow();
        stage.close();
    }

    @FXML
    /**
     * Este método muda para o ecrã das definições
     */
    private void IrParaDefinicoes(MouseEvent event) throws IOException 
    {
        //carrega tudo o que existe no ficheiro xml para puder ser utilizador na transição
        Parent root = FXMLLoader.load(getClass().getResource("Definicoes.fxml"));
        //mudança de ecrã, vai á cena e muda de ecra, vai para o ecra definicoes
         irDefinicoes.getScene().setRoot(root);
    }

    @FXML
     /**
     * Este método muda para o ecrã home
     */
    private void voltarAtras(MouseEvent event) throws IOException 
            
    {    //carrega tudo o que existe no ficheiro xml para puder ser utilizador na transição
        Parent root = FXMLLoader.load(getClass().getResource("Home.fxml"));
        //muda de ecrã, é á cena e muda de ecrã, retorna oara o home
        retorna.getScene().setRoot(root);
    }

    @FXML
    private void IrParaAjudaCamaras(MouseEvent event) throws IOException 
    {
        //carrega tudo o que existe no ficheiro xml para puder ser utilizador na transição
        Parent root = FXMLLoader.load(getClass().getResource("AjudaCamaras.fxml"));
        //mudança de ecrã, vai á cena e muda de ecra, vai para o ecra onde tem as camaras
         camaras.getScene().setRoot(root);
    }
}
