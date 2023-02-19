/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package khadamni;

import entity.user;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import service.UserService;

/**
 * FXML Controller class
 *
 * @author benza
 */
public class Quiz_webController implements Initializable {

    @FXML
    private Button envoyer;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
}
  //  @FXML
//private void terminer_quiz(ActionEvent event) throws SQLException {
//    // Utiliser le service UserService pour trouver l'utilisateur avec l'ID le plus élevé
//    UserService userService = new UserService();
//    user u = userService.findUserWithMaxId();
//
//    // Mettre à jour l'attribut note de l'utilisateur avec la valeur de l'entier ajouté
//    int noteToAdd = 10;
//    u.setNote (u.getNote() + noteToAdd);
//
//    // Utiliser le service UserService pour mettre à jour l'utilisateur dans la base de données
//    userService.update(u);
//
//    // Afficher un message de confirmation
//    Alert alert = new Alert(Alert.AlertType.INFORMATION);
//    alert.setTitle("Confirmation");
//    alert.setHeaderText(null);
//    alert.setContentText("Quiz terminé avec succès !");
//    alert.showAndWait();
//}
//    
//}
