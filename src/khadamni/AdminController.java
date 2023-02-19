/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package khadamni;

import entity.user;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.Optional;
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
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import service.UserService;


/**
 * FXML Controller class
 *
 * @author benza
 */
public class AdminController implements Initializable {
    

    @FXML
    private TableView<user> afficher;
    @FXML
    private TableColumn idColumn;
    @FXML
    private TableColumn nomColumn;
    @FXML
    private TableColumn prenomColumn;
    @FXML
    private TableColumn numTelColumn;
    @FXML
    private TableColumn adresseColumn;
    @FXML
    private TableColumn centreInteretColumn;
    @FXML
    private TableColumn adresseEntrepriseColumn;
    @FXML
    private TableColumn nomEntrepriseColumn;
    @FXML
    private TableColumn roleColumn;
    @FXML
    private TableColumn emailColumn;
    @FXML
    private TableColumn mdpColumn;
    @FXML
    private TableColumn imagecolumn;
    @FXML
    private TableColumn cvcolumn;
    @FXML
    private TableColumn ageColumn;
    @FXML
    private TableColumn notecolumn;
    private UserService userService = new UserService();
    @FXML
    private Button supp;
    @FXML
    private ComboBox changer_id;
    
   
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        changer_id.getItems().add("admin");
   changer_id.getItems().add("utilisateur");
   changer_id.getItems().add("recrueur");
  changer_id.setPromptText("changer type utilisateur");
        
        idColumn.setCellValueFactory(new PropertyValueFactory<>("id_user"));
        nomColumn.setCellValueFactory(new PropertyValueFactory<>("nom"));
        prenomColumn.setCellValueFactory(new PropertyValueFactory<>("prenom"));
        numTelColumn.setCellValueFactory(new PropertyValueFactory<>("num_tel"));
        adresseColumn.setCellValueFactory(new PropertyValueFactory<>("adresse"));
        centreInteretColumn.setCellValueFactory(new PropertyValueFactory<>("centre_intere"));
        adresseEntrepriseColumn.setCellValueFactory(new PropertyValueFactory<>("adresse_entreprise"));
        nomEntrepriseColumn.setCellValueFactory(new PropertyValueFactory<>("nom_entreprise"));
        roleColumn.setCellValueFactory(new PropertyValueFactory<>("id_role"));
        emailColumn.setCellValueFactory(new PropertyValueFactory<>("email"));
        mdpColumn.setCellValueFactory(new PropertyValueFactory<>("mdp"));
        ageColumn.setCellValueFactory(new PropertyValueFactory<>("age"));
        notecolumn.setCellValueFactory(new PropertyValueFactory<>("note"));
      
         
  

             
      
         
       
        
        // récupère les données des utilisateurs depuis la base de données
        List<user> userList = userService.readAll();
        
        // affiche les données dans le tableau
        afficher.getItems().setAll(userList);
    }

    @FXML
    private void supprimeruser(ActionEvent event) {
         user selectedUser = afficher.getSelectionModel().getSelectedItem();
       
        if (selectedUser == null) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("No user selected");
            alert.setHeaderText(null);
            alert.setContentText("Please select a user in the table.");
            alert.showAndWait();
            return;
        }

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirm deletion");
        alert.setHeaderText(null);
        alert.setContentText("Are you sure you want to delete the selected user?");

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK) {
           
            userService.delete(selectedUser.getId_user());
             List<user> userList = userService.readAll();
        
        // affiche les données dans le tableau
        afficher.getItems().setAll(userList);
        }}

   

    @FXML
    private void modifier(ActionEvent event) {
    user selectedUser = afficher.getSelectionModel().getSelectedItem();
    
    // 2. Afficher un message d'erreur si aucun utilisateur n'est sélectionné
    if (selectedUser == null) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("No user selected");
        alert.setHeaderText(null);
        alert.setContentText("Please select a user in the table.");
        alert.showAndWait();
        return;
    }
    
    // 3. Demander confirmation à l'utilisateur
    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
    alert.setTitle("Confirm modification");
    alert.setHeaderText(null);
    alert.setContentText("Are you sure you want to modify the selected user?");
    Optional<ButtonType> result = alert.showAndWait();
    if (result.get() != ButtonType.OK) {
        return;
    }
    
    // 4. Récupérer la nouvelle valeur de id_role depuis le ComboBox
    String newRoleId = (String) changer_id.getValue();
    int newRoleIdInt = 0;
    if (newRoleId.equals("admin")) {
        newRoleIdInt = 1;
    } else if (newRoleId.equals("utilisateur")) {
        newRoleIdInt = 2;
    } else if (newRoleId.equals("recruteur")) {
        newRoleIdInt = 3;
    }
    
    // 5. Mettre à jour la propriété id_role de l'utilisateur sélectionné
    selectedUser.setId_role(newRoleIdInt);
    
    // 6. Mettre à jour l'utilisateur dans la base de données
    userService.update(selectedUser,newRoleIdInt);
    
    // 7. Actualiser la liste des utilisateurs affichée dans le tableau
    List<user> userList = userService.readAll();
    afficher.getItems().setAll(userList);    }
    }    
    

