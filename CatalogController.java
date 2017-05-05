/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package radientshop;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import java.io.IOException;
import java.net.URL;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;

/**
 *
 * @author acer
 */
public class CatalogController implements Initializable {
    @FXML
    private ListView<String> ListView;
    @FXML
    private TableView<?> TableView;
   
    ObservableList<String> categoryList;
    @FXML
    private AnchorPane AnchorPane;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        categoryList = FXCollections.observableArrayList();
        ListView.setItems(categoryList);
        try {
            Connection connection = (Connection) DriverManager.getConnection(
                    "jdbc:mysql://127.0.0.1/hardwares",
                    "root",
                    "java");
            Statement statement = (Statement) connection.createStatement();
            String query;
            
            query = "select * from ProductCategory;";
            ResultSet resultSet = statement.executeQuery(query);
            
            while (resultSet.next()) {
                String category = resultSet.getString("category");
                categoryList.add(category);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CatalogController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    

    @FXML
    private void handleLoginAction(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));
        Scene scene = new Scene(root);
        RadientShop.getStage().setScene(scene);
        RadientShop.getStage().show();
    }
    
}
