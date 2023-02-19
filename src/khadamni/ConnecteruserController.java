/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package khadamni;

import entity.role;
import entity.user;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import service.UserService;

/**
 * FXML Controller class
 *
 * @author benza
 */
public class ConnecteruserController implements Initializable {

    
    @FXML
    private TextField tfsnom;
    @FXML
    private TextField tfprenom;
    @FXML
    private TextField tfnum_tel;
    @FXML
    private TextField tfadresse;
    
    @FXML
    private TextField tfemail;
    @FXML
    private TextField tfmdp;
    @FXML
    private TextField tfage;
    @FXML
    private Button inscrire;
    @FXML
    private ComboBox comb;
    


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       comb.getItems().add("web");
   comb.getItems().add("mobile");
   comb.getItems().add("data");
  comb.setPromptText("choisir");

    }    

    @FXML
    private void sauvgarder(ActionEvent event) throws IOException {
     role r1 = new role (2,"user");
        String nom = tfsnom.getText();
        String prenom = tfprenom.getText();
        int num_tel = Integer.parseInt(tfnum_tel.getText());
        String adresse = tfadresse.getText();
        String centre_intere = comb.getValue().toString();
         String adresse_entreprise = "";
        String nom_entreprise = "";
        String email = tfemail.getText();
        String mdp = tfmdp.getText();
        int age = Integer.parseInt(tfage.getText());
        int note = 0;
   
      

        // Créer un nouvel utilisateur avec les données du formulaire et un rôle par défaut
        user u = new user( nom,prenom,num_tel,adresse,centre_intere,adresse_entreprise,nom_entreprise,r1.getId_role(),email,mdp,age,note);


        // Utiliser le service UserService pour ajouter l'utilisateur à la base de données
        UserService userService = new UserService();
        userService.insert(u);

        // Afficher un message de confirmation
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Confirmation");
        alert.setHeaderText(null);
        alert.setContentText("Utilisateur ajouté avec succès !");
        alert.showAndWait();

        // Réinitialiser le formulaire
        tfsnom.setText("");
        tfprenom.setText("");
        tfnum_tel.setText("");
        tfadresse.setText("");
         comb.setPromptText("choisir");
        
        tfemail.setText("");
        tfmdp.setText("");
        tfage.setText("");
         if (centre_intere.equals("web")) {
    Parent root = FXMLLoader.load(getClass().getResource("quiz_web.fxml"));
    Scene scene = new Scene(root);
    Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
    stage.setScene(scene);
    stage.show();
} else if (centre_intere.equals("mobile")) {
    Parent root = FXMLLoader.load(getClass().getResource("quiz_mobile.fxml"));
    Scene scene = new Scene(root);
    Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
    stage.setScene(scene);
    stage.show();
} else if (centre_intere.equals("data")) {
    Parent root = FXMLLoader.load(getClass().getResource("quiz_data.fxml"));
    Scene scene = new Scene(root);
    Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
    stage.setScene(scene);
    stage.show();
}
    }

    
    


    



    
}
