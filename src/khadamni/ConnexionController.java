/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package khadamni;

import entity.user;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;

/**
 * FXML Controller class
 *
 * @author benza
 */
public class ConnexionController implements Initializable {
        private user util= null;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
// Charger la vue de connexion.fxml
System.out.println(util);
FXMLLoader loader = new FXMLLoader(getClass().getResource("connexion.fxml"));


        try {
            Parent root = loader.load();
        } catch (IOException ex) {
            Logger.getLogger(ConnexionController.class.getName()).log(Level.SEVERE, null, ex);
        }

// Récupérer le contrôleur de la vue

// Envoyer l'utilisateur au contrôleur
    }  


public void setUserData(user u2) {
    System.out.println("test");
    this.util = u2;
    System.out.println(u2.getEmail());
}
    
}
