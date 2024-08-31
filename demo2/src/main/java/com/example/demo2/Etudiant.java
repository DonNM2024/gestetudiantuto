package com.example.demo2;


public class Etudiant {
    private int Id;
    private String Nom;
    private String Prenom;
    private int Age;
    private String Sexe;
    private String DateNaiss;
    private String MotDePasse;
    private String Adresse;
    private String Email;
    private String Telephone;
    private byte[] Image;

    public Etudiant(int id, String nom, String prenom, int age, String sexe, String dateNaiss, String motDePasse, String adresse, String email, String telephone, byte[] image) {
        Id = id;
        Nom = nom;
        Prenom = prenom;
        Age = age;
        Sexe = sexe;
        DateNaiss = dateNaiss;
        MotDePasse = motDePasse;
        Adresse = adresse;
        Email = email;
        Telephone = telephone;
        Image = image;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getNom() {
        return Nom;
    }

    public void setNom(String nom) {
        Nom = nom;
    }

    public String getPrenom() {
        return Prenom;
    }

    public void setPrenom(String prenom) {
        Prenom = prenom;
    }

    public int getAge() {
        return Age;
    }

    public void setAge(int age) {
        Age = age;
    }

    public String getSexe() {
        return Sexe;
    }

    public void setSexe(String sexe) {
        Sexe = sexe;
    }

    public String getDateNaiss() {
        return DateNaiss;
    }

    public void setDateNaiss(String dateNaiss) {
        DateNaiss = dateNaiss;
    }

    public String getMotDePasse() {
        return MotDePasse;
    }

    public void setMotDePasse(String motDePasse) {
        MotDePasse = motDePasse;
    }

    public String getAdresse() {
        return Adresse;
    }

    public void setAdresse(String adresse) {
        Adresse = adresse;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getTelephone() {
        return Telephone;
    }

    public void setTelephone(String telephone) {
        Telephone = telephone;
    }

    public byte[] getImage() {
        return Image;
    }

    public void setImage(byte[] image) {
        Image = image;
    }
    //La Methode toString
//    public String toString(){
//        return "Etudiant[ Id="+Id+",Nom="+Nom+",Prenom="+Prenom+",DatNaiss="+DateNaiss+",Adresse="+Adresse+",Telephone="+Telephone+",Email="+Email+",MotDePass="+MotDePasse+",Age="+Age+",Sexe="+Sexe+"]";
//    }
}

