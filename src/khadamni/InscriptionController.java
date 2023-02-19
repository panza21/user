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
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import service.RoleService;
import service.UserService;

/**
 * FXML Controller class
 *
 * @author benza
 */
public class InscriptionController implements Initializable {

    @FXML
    private TextField resnom;
    @FXML
    private TextField resprenom;
    @FXML
    private TextField resnum_tel;
    @FXML
    private TextField resadresse;
   
    @FXML
    private TextField resadresse_entreprise;
    @FXML
    private TextField resnomentreprise;
    @FXML
    private TextField resemail;
    @FXML
    private TextField resmdp;
    @FXML
    private TextField resage;
    @FXML
    private Button inscrire1;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

  
  

    @FXML
    private void sauvgarder1(ActionEvent event) throws IOException {
    role r1 = new role (3,"recruteur");
        String nom = resnom.getText();
        String prenom = resprenom.getText();
        int num_tel = Integer.parseInt(resnum_tel.getText());
        String adresse = resadresse.getText();
        String centre_intere = "";
        String adresse_entreprise = resadresse_entreprise.getText();
        String nom_entreprise = resnomentreprise.getText();
         
        String email = resemail.getText();
        String mdp = resmdp.getText();
        int age = Integer.parseInt(resage.getText());
        int note = 0;
   
      

        // Créer un nouvel utilisateur avec les données du formulaire et un rôle par défaut
        user u = new user( nom,prenom,num_tel,adresse,centre_intere,adresse_entreprise,nom_entreprise,r1.getId_role(),email,mdp,age,note);


        // Utiliser le service UserService pour ajouter l'utilisateur à la base de données
        UserService userService = new UserService();
        userService.insert1(u);

        // Afficher un message de confirmation
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Confirmation");
        alert.setHeaderText(null);
        alert.setContentText("Utilisateur ajouté avec succès !");
        alert.showAndWait();

        // Réinitialiser le formulaire
        resnom.setText("");
        resprenom.setText("");
        resnum_tel.setText("");
        resadresse.setText("");
        
        resadresse_entreprise.setText("");
        resnomentreprise.setText("");
        resemail.setText("");
        resmdp.setText("");
        resage.setText("");
    Parent root = FXMLLoader.load(getClass().getResource("seconnecter.fxml"));
    Scene scene = new Scene(root);
    Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
    stage.setScene(scene);
    stage.show();
    }
    
}
