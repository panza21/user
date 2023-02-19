/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author benza
 */
public class EntityManagerFactoryProvider {
    private static final EntityManagerFactory emFactory;
    
    static {
        try {
            emFactory = Persistence.createEntityManagerFactory("nom-de-votre-persistence-unit");
        } catch (Throwable ex) {
            System.err.println("Initial EntityManagerFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }
    
    public static EntityManagerFactory getEntityManagerFactory() {
        return emFactory;
    }
}
