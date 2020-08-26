/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package home;

import helpers.Links;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author hocin
 */
public class HomeViewController implements Initializable {

    @FXML
    private Circle circle;
    @FXML
    private Text text;
    @FXML
    private AnchorPane anchorPane;
    int x , y ;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        text.setText("Home Content");
        loadView(Links.HOMECONTENT);
         Image image = new Image("/images/my_image.jpg");
        circle.setFill(new ImagePattern(image));
       

    }

    @FXML
    private void gethome(MouseEvent event) {
        text.setText("Home Content");
        loadView(Links.HOMECONTENT);
    }

    @FXML
    private void getProducts(MouseEvent event) {
        text.setText("Products View");
        loadView(Links.PRODUCTSVIEW);

    }

    @FXML
    private void getCients(MouseEvent event) {
        text.setText("Clients View");
        loadView(Links.CLENTSVIEW);

    }

    @FXML
    private void getSuppliers(MouseEvent event) {
        text.setText("Suppliers View");
        loadView(Links.SUPPLIERSVIEW);
    }

    @FXML
    private void getPurchases(MouseEvent event) {
        text.setText("Purchases View");
        loadView(Links.PURCHASESVIEW);
    }

    @FXML
    private void getSales(MouseEvent event) {
        text.setText("Sales View");
        loadView(Links.SALESVIEW);
    }

    public void loadView(String viewName) {
        try {
            AnchorPane pane = FXMLLoader.load(getClass().getResource(viewName));
            anchorPane.getChildren().setAll(pane);
        } catch (IOException ex) {
            Logger.getLogger(HomeViewController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
      @FXML
    private void min(MouseEvent event) {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setIconified(true);
    }

    @FXML
    private void max(MouseEvent event) {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setFullScreen(true);
    }

    @FXML
    private void close(MouseEvent event) {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.close();
    }
  
      @FXML
    private void MouseDragged(MouseEvent event) {

        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        stage.setX(event.getScreenX() - x);
        stage.setY(event.getScreenY() - y);
    }

    @FXML
    private void MousePressed(MouseEvent event) {

        x = (int) event.getSceneX();
        y = (int) event.getSceneY();

    }

}
