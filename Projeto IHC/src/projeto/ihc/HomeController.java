/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projeto.ihc;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
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
    
    MyBrowser myBrowser;
    
    private void handleButtonAction(ActionEvent event) {
        System.out.println("You clicked me!");
        label.setText("Hello World!");
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        myBrowser = new MyBrowser();
        map.getChildren().add(myBrowser);
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
