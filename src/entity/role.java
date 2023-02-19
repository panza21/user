/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;


public class role {
    private int id_role ;
    private String type ;

    public role() {
    }

    public role(String type) {
        this.type = type;
    }

    public role(int id_role) {
        this.id_role = id_role;
    }

    public role(int id_role, String type) {
        this.id_role = id_role;
        this.type = type;
    }

    public int getId_role() {
        return id_role;
    }

    public void setId_role(int id_role) {
        this.id_role = id_role;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "role{" + "id_role=" + id_role + ", type=" + type + '}';
    }
    
    
}