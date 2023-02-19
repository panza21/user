/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package khadamni;

import entity.user;
import java.io.IOException;
import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import utils.DataSource;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import khadamni.ConnexionController;
import service.UserService;
import utils.DataSource;

/**
 * FXML Controller class
 *
 * @author benza
 */
public class SeconnecterController implements Initializable {

    @FXML
    private Button inscrire_recruteur;
    @FXML
    private Button inscrire_user;
    @FXML
    private Button connect;
    @FXML
    private TextField donneradresse;
    @FXML
    private PasswordField password;
    private Connection connection;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void recruteur(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("inscription.fxml"));
    Scene scene = new Scene(root);
    Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
    stage.setScene(scene);
    stage.show();
    }

    @FXML
    private void user(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("connecteruser.fxml"));
    Scene scene = new Scene(root);
    Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
    stage.setScene(scene);
    stage.show();
    }

    @FXML
    private void seconnecter(ActionEvent event)throws SQLException, IOException {
        
      connection = DataSource.getInstance().getCnx();
    String email = donneradresse.getText();
    String mdp = password.getText();
    // Récupérer l'adresse email de l'utilisateur


// Rechercher l'utilisateur par email
UserService userService = new UserService();
user utilisateur = userService.getUserByEmail(email);

    if (email.isEmpty() || mdp.isEmpty()) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Attention");
        alert.setHeaderText(null);
        alert.setContentText("Veuillez saisir l'email et le mot de passe.");
        alert.showAndWait();
        return;
    } 

    try {
        String requete = "SELECT * FROM user WHERE email = ? AND mdp = ?";
        PreparedStatement statement = connection.prepareStatement(requete);
        statement.setString(1, email);
        statement.setString(2, mdp);
        ResultSet resultSet = statement.executeQuery();


        if (resultSet.next()) {
            // Utilisateur trouvé
            int idRole = resultSet.getInt("id_role");
            if (idRole == 1) {
                Parent root = FXMLLoader.load(getClass().getResource("admin.fxml"));
                Scene scene = new Scene(root);
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.setScene(scene);
                stage.show();
            } else {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Succès");
                alert.setHeaderText(null);
                alert.setContentText("Vous êtes maintenant connecté!");
                alert.showAndWait();
                UserService sc = new UserService();
                user utilisateur1 = sc.getUserByEmail(email);
                System.out.println(utilisateur1.getId_user());
                FXMLLoader loader = new FXMLLoader(getClass().getResource("connexion.fxml"));
                        Parent root = loader.load();

                ConnexionController c = loader.getController();
                c.setUserData(utilisateur1);
            
                Scene scene = new Scene(root);
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.setScene(scene);
                stage.show();
            }
        } else {
            // Utilisateur non trouvé
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erreur");
            alert.setHeaderText(null);
            alert.setContentText("Email ou mot de passe incorrect.");
            alert.showAndWait();
        }
        resultSet.close();
        statement.close();
      
    } catch (SQLException e) {
        e.printStackTrace();
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Erreur");
        alert.setHeaderText(null);
        alert.setContentText("Impossible de se connecter à la base de données.");
        alert.showAndWait();
    }  
    
    
    }

    }
    

