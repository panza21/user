package entity;
import java.awt.Image;
import javafx.scene.control.ComboBox;

/**
 *
 * @author benza
 */
public class user {
    private int id_user ;  
    private String nom ;
    private String prenom ;
    private int num_tel ;
    private String adresse ;
    private String centre_intere ;
    private String adresse_entreprise ;
    private String nom_entreprise ;
    private int id_role ;
    private String email ;
    private String mdp ;
    private Image image;
    private Image cv;
    private int age;
    private int note;
  

    public user(String nom, String prenom, int num_tel, String adresse, String centre_intere, String adresse_entreprise, String nom_entreprise, int id_role, String email, String mdp, int age, int note) {
        this.nom = nom;
        this.prenom = prenom;
        this.num_tel = num_tel;
        this.adresse = adresse;
        this.centre_intere = centre_intere;
        this.adresse_entreprise = adresse_entreprise;
        this.nom_entreprise = nom_entreprise;
        this.id_role = id_role;
        this.email = email;
        this.mdp = mdp;
        this.age = age;
        this.note = note;
    }

    public user(int id_user, String nom, String prenom, int num_tel, String adresse, String centre_intere, String adresse_entreprise, String nom_entreprise, int id_role, String email, String mdp, int age, int note) {
        this.id_user = id_user;
        this.nom = nom;
        this.prenom = prenom;
        this.num_tel = num_tel;
        this.adresse = adresse;
        this.centre_intere = centre_intere;
        this.adresse_entreprise = adresse_entreprise;
        this.nom_entreprise = nom_entreprise;
        this.id_role = id_role;
        this.email = email;
        this.mdp = mdp;
        this.age = age;
        this.note = note;
    }

   

   

    

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public int getNum_tel() {
        return num_tel;
    }

    public void setNum_tel(int num_tel) {
        this.num_tel = num_tel;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getCentre_intere() {
        return centre_intere;
    }

    public void setCentre_intere(String centre_intere) {
        this.centre_intere = centre_intere;
    }

    public String getAdresse_entreprise() {
        return adresse_entreprise;
    }

    public void setAdresse_entreprise(String adresse_entreprise) {
        this.adresse_entreprise = adresse_entreprise;
    }

    public String getNom_entreprise() {
        return nom_entreprise;
    }

    public void setNom_entreprise(String nom_entreprise) {
        this.nom_entreprise = nom_entreprise;
    }

    public int getId_role() {
        return id_role;
    }

    public void setId_role(int id_role) {
        this.id_role = id_role;
    }

  

   

   

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMdp() {
        return mdp;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public Image getCv() {
        return cv;
    }

    public void setCv(Image cv) {
        this.cv = cv;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getNote() {
        return note;
    }

    public void setNote(int note) {
        this.note = note;
    }
}