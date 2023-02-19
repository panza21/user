///*
package khadamni;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Khadamni extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("seconnecter.fxml"));
        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
    
}
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package khadamni;
//
//import entity.role;
//import entity.user;
//import service.RoleService;
//import service.UserService;
//import utils.DataSource;
//
///**
// *
// * @author benza
// */
//public class Khadamni {
//
//    
//    public static void main(String[] args) {
//      DataSource ds1 = DataSource.getInstance();
//      
//        RoleService rol = new RoleService();
//        role r1 = new role (3,"pizza");
//        
//        rol.readAll().forEach(System.out::println);
//        role r2 = rol.readById(2);
//        System.out.println(r2);
//      role r = new role();
//      r.setId_role(2);
//      r.setType("birra");
//      rol.update(r);
//        UserService usr = new UserService();
//        user u1 = new user (3,"aziz","benzarti",123,"tunis", "centre", "adresse", "nom", r1,"aefo", "djobv", 25);
//      usr.insert(u1);
//usr.delete(u1);
//    }
//    
//}
