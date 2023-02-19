/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;
import entity.role;
import entity.user;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javax.management.relation.Role;
import utils.DataSource;
/**
 *
 * @author turki
 */
public class UserService implements IService<user>{
    
    private Connection conn;
    private String requete;

    public UserService() {
        conn=DataSource.getInstance().getCnx();
    }

    

    @Override
    public void insert(user t) {
    String requete = "INSERT INTO user (nom, prenom, num_tel, adresse, centre_intere, adresse_entreprise, nom_entreprise, id_role, email, mdp, age,note) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?)";
    String emailRegex = "\\w+\\.?\\w+@[a-zA-Z_]+?\\.[a-zA-Z]{2,3}";
    if (!t.getEmail().matches(emailRegex)) {
        Alert alert = new Alert(AlertType.WARNING);
        alert.setTitle("Attention");
        alert.setHeaderText(null);
        alert.setContentText("L'adresse email est invalide. Veuillez saisir une adresse email valide (ex: nom_utilisateur@domaine.com).");
        alert.showAndWait();
        return;
    }
      if (String.valueOf(t.getNum_tel()).length() != 8) {
    Alert alert = new Alert(AlertType.WARNING);
    alert.setTitle("Attention");
    alert.setHeaderText(null);
    alert.setContentText("Le numéro de téléphone doit comporter exactement 8 chiffres.");
    alert.showAndWait();
    return;
}
    try { 
        // Récupérer l'objet role correspondant au rôle "admin"
        
        RoleService roleService = new RoleService();
        

      

        // Insérer l'utilisateur dans la base de données
        PreparedStatement usr = conn.prepareStatement(requete, Statement.RETURN_GENERATED_KEYS);
        
        usr.setString(1, t.getNom());
        usr.setString(2, t.getPrenom());
        usr.setInt(3, t.getNum_tel());
        usr.setString(4, t.getAdresse());
        usr.setString(5, t.getCentre_intere());
        usr.setString(6, t.getAdresse_entreprise());
        usr.setString(7, t.getNom_entreprise());
        usr.setInt(8, 2);

        usr.setString(9, t.getEmail());
        usr.setString(10, t.getMdp());
        usr.setInt(11, t.getAge());
        usr.setInt(12, 0);
        usr.executeUpdate();
        

        // Récupérer l'ID généré pour l'utilisateur inséré
        ResultSet rs = usr.getGeneratedKeys();
        if (rs.next()) {
            int userId = rs.getInt(1);
            t.setId_user(userId);
        }
    } catch (SQLException ex) {
        Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
    }
}
    public void insert1(user t) {
    String requete = "INSERT INTO user (nom, prenom, num_tel, adresse, centre_intere, adresse_entreprise, nom_entreprise, id_role, email, mdp, age,note) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?)";
    String emailRegex = "\\w+\\.?\\w+@[a-zA-Z_]+?\\.[a-zA-Z]{2,3}";
     
    if (!t.getEmail().matches(emailRegex)) {
        Alert alert = new Alert(AlertType.WARNING);
        alert.setTitle("Attention");
        alert.setHeaderText(null);
        alert.setContentText("L'adresse email est invalide. Veuillez saisir une adresse email valide (ex: nom_utilisateur@domaine.com).");
        alert.showAndWait();
        return;
    }
    if (String.valueOf(t.getNum_tel()).length() != 8) {
    Alert alert = new Alert(AlertType.WARNING);
    alert.setTitle("Attention");
    alert.setHeaderText(null);
    alert.setContentText("Le numéro de téléphone doit comporter exactement 8 chiffres.");
    alert.showAndWait();
    return;
}
        
    try {    
        // Récupérer l'objet role correspondant au rôle "admin"
        
        RoleService roleService = new RoleService();
        

      

        // Insérer l'utilisateur dans la base de données
        PreparedStatement usr = conn.prepareStatement(requete, Statement.RETURN_GENERATED_KEYS);
        
        usr.setString(1, t.getNom());
        usr.setString(2, t.getPrenom());
        usr.setInt(3, t.getNum_tel());
        usr.setString(4, t.getAdresse());
        usr.setString(5, t.getCentre_intere());
        usr.setString(6, t.getAdresse_entreprise());
        usr.setString(7, t.getNom_entreprise());
        usr.setInt(8, 3);

        usr.setString(9, t.getEmail());
        usr.setString(10, t.getMdp());
        usr.setInt(11, t.getAge());
        usr.setInt(12, 0);
        usr.executeUpdate();

        // Récupérer l'ID généré pour l'utilisateur inséré
        ResultSet rs = usr.getGeneratedKeys();
        if (rs.next()) {
            int userId = rs.getInt(1);
            t.setId_user(userId);
        }
    } catch (SQLException ex) {
        Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
    }
}


    
   public void delete(int id) {
   
    String requete = "DELETE FROM user WHERE id_user = ?";
    try {
        PreparedStatement ps = conn.prepareStatement(requete);
        ps.setInt(1, id);
        ps.executeUpdate();
    } catch (SQLException ex) {
        Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
    }
}
public user getUserByEmail(String email) throws SQLException {
    Connection connection = DataSource.getInstance().getCnx();
    user u1 = null;

    try {
        String requete = "SELECT * FROM user WHERE email = ?";
        PreparedStatement statement = connection.prepareStatement(requete);
        statement.setString(1, email);
        ResultSet resultSet = statement.executeQuery();

        if (resultSet.next()) {
            int id = resultSet.getInt("id_user");
            String nom = resultSet.getString("nom");
            String prenom = resultSet.getString("prenom");
         int num_tel = resultSet.getInt("num_tel");
            String adresse = resultSet.getString("adresse");
           String centre_intere = resultSet.getString("centre_intere");
            String adresse_entreprise = resultSet.getString("adresse_entreprise");
            String nom_entreprise = resultSet.getString("nom_entreprise");
            int id_role = resultSet.getInt("id_role");
            
            String mdp = resultSet.getString("mdp");
            int age = resultSet.getInt("age");
            int note = resultSet.getInt("note");
            

            u1 = new user(id, nom, prenom, num_tel, adresse, centre_intere,adresse_entreprise,nom_entreprise,id_role,email,mdp,age,note);
        }
    
        resultSet.close();
        statement.close();

    } catch (SQLException e) {
        e.printStackTrace();
        throw e;
    }

    return u1;
}
  int id_role; 
    public void update(user t,int id_role) {
        try {
          PreparedStatement ps = conn.prepareStatement("UPDATE user SET id_role= ? WHERE id_user = ?");
ps.setInt(2,t.getId_user());
//            ps.setString(2, t.getPrenom());
//            ps.setInt(3, t.getNum_tel());
//            ps.setString(4, t.getAdresse());
//            ps.setString(5, t.getCentre_intere());
//            ps.setString(6, t.getAdresse_entreprise());
//            ps.setString(7, t.getNom_entreprise()); 
            ps.setInt(1, id_role);
//            ps.setString(9, t.getEmail());
//            ps.setString(10,t.getMdp()); 
//            ps.setInt(11, t.getAge()); 
//            ps.setInt(12, t.getNote());
            
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
        }
            
        
    }

    @Override
    public List<user> readAll() {
         String requete = "SELECT user.*, role.id_role, role.type_role FROM user INNER JOIN role ON user.id_role = role.id_role";
    List<user> list = new ArrayList<>();
    try {
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(requete);
        while (rs.next()) {
           
            user t;
            t = new user(rs.getInt("id_user"), rs.getString("nom"),rs.getString("prenom"),rs.getInt("num_tel"),rs.getString("adresse"),rs.getString("centre_intere"),rs.getString("adresse_entreprise"),rs.getString("nom_entreprise"),rs.getInt("id_role"),rs.getString("email"),rs.getString("mdp"),rs.getInt("age"),rs.getInt("note"));
            list.add(t);
        }
    } catch (SQLException ex) {
        Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
    }
    return list;
}
   
   

    

    @Override
    public user readById(int id_user) {
     
    requete = "SELECT user.*, role.id_role, role.type_role FROM user INNER JOIN role ON user.id_role = user.id_role where id_user=" + id_user;

    user t = null;
    try {
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(requete);
        while (rs.next()) {
            role r = new role();
            r.setId_role(rs.getInt("id_role"));
            r.setType(rs.getString("type_role"));
           
            t = new user(rs.getInt("id_user"), rs.getString("nom"),rs.getString("prenom"),rs.getInt("num_tel"),rs.getString("adresse"),rs.getString("centre_intere"),rs.getString("adresse_entreprise"),rs.getString("nom_entreprise"),rs.getInt("id_role"),rs.getString("email"),rs.getString("mdp"),rs.getInt("age"),rs.getInt("note"));
        }
    } catch (SQLException ex) {
        Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
    }

    return t;
    }

    @Override
    public void delete(user t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(user t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


    
   




    }