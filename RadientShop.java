/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package radientshop;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Screen;
import javafx.stage.Stage;

/**
 *
 * @author acer
 */
public class RadientShop extends Application {
    private static Stage mainStage;
    static Stage getStage() {
        return mainStage;
    }
    
    @Override
    public void start(Stage stage) throws Exception {
        
         Screen screen = Screen.getPrimary(); 
        javafx.geometry.Rectangle2D bounds = screen.getVisualBounds();
stage.setWidth(bounds.getWidth());
stage.setHeight(bounds.getHeight());
        Parent root = FXMLLoader.load(getClass().getResource("Catalog.fxml"));
        
        mainStage = stage;
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
