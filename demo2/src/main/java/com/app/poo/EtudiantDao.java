package com.app.poo;



import com.example.demo2.Etudiant;
import pack.com.poo.ConnexionDb;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EtudiantDao implements GenericDao<Etudiant> {
    PreparedStatement pstmt = null;
    ResultSet resultSet = null;


    @Override
    public Etudiant find(int Id) throws SQLException {
        Etudiant etudiant = null;
        String query = "select * from etudiant where id=?";
        try {
            pstmt = ConnexionDb.getConnection().prepareStatement(query);
            pstmt.setInt(1, Id);
            resultSet = pstmt.executeQuery();
            while (resultSet.next()) {
                return new Etudiant(
                        resultSet.getInt("Id"),
                        resultSet.getString("Nom"),
                        resultSet.getString("Prenom"),
                        resultSet.getInt("Age"),
                        resultSet.getString("Sexe"),
                        resultSet.getString("DateNaiss"),
                        resultSet.getString("MotDePass"),
                        resultSet.getString("Adresse"),
                        resultSet.getString("Email"),
                        resultSet.getString("Telephone"),
                        resultSet.getBytes("image"));


            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (resultSet != null) {
                resultSet.close();
            }
            if (pstmt != null) {
                pstmt.close();
            }
        }
        return etudiant;
    }

    @Override
    public List<Etudiant> findAll() throws SQLException {
        String query = "Select * from etudiant";
        List<Etudiant> etudiantList = new ArrayList<>();
        try {
            pstmt = ConnexionDb.getConnection().prepareStatement(query);
            //executer la requete
            resultSet = pstmt.executeQuery();

            //parcourrir le curseur
            while (resultSet.next()) {
                etudiantList.add(new Etudiant(
                                resultSet.getInt("Id"),
                                resultSet.getString("Nom"),
                                resultSet.getString("Prenom"),
                                resultSet.getInt("Age"),
                                resultSet.getString("Sexe"),
                                resultSet.getString("DateNaiss"),
                                resultSet.getString("MotDePass"),
                                resultSet.getString("Adresse"),
                                resultSet.getString("Email"),
                                resultSet.getString("Telephone"),
                                resultSet.getBytes("image")
                        )
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (resultSet != null) {
                resultSet.close();
            }
            if (pstmt != null) {
                pstmt.close();
            }
        }
        return etudiantList;
    }

    @Override
    public void save(Etudiant etudiant) throws SQLException {
        String query = "insert into Etudiant(Id,Nom,Prenom,Age,Sexe,DateNaiss,MotDePass,Adresse,Email,Telephone,Image) values(?,?,?,?,?,?,?,?,?,?,?)";
        try {
            pstmt = ConnexionDb.getConnection().prepareStatement(query);
            pstmt.setInt(1, etudiant.getId());
            pstmt.setString(2, etudiant.getNom());
            pstmt.setString(3, etudiant.getPrenom());
            pstmt.setInt(4, etudiant.getAge());
            pstmt.setString(5, etudiant.getSexe());
            pstmt.setString(6, etudiant.getDateNaiss());
            pstmt.setString(7, etudiant.getMotDePasse());
            pstmt.setString(8, etudiant.getAdresse());
            pstmt.setString(9, etudiant.getEmail());
            pstmt.setString(10, etudiant.getTelephone());
            pstmt.setBytes(11, etudiant.getImage());

            //excution de la requete
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (pstmt != null) {
                pstmt.close();
            }
        }


    }

    @Override
    public void update(Etudiant etudiant) throws SQLException {
        String query = "update etudiant set Nom=?,Prenom=?,Age=?,Sexe=?,DateNaiss=?,MotDePass=?,Adresse=?,Email=?,Telephone=?,Image=? where id=?";
        try {
            pstmt = ConnexionDb.getConnection().prepareStatement(query);

            //Parcourrir le curseur
            pstmt.setString(1, etudiant.getNom());
            pstmt.setString(2, etudiant.getPrenom());
            pstmt.setInt(3, etudiant.getAge());
            pstmt.setString(4, etudiant.getSexe());
            pstmt.setString(5, etudiant.getDateNaiss());
            pstmt.setString(6, etudiant.getMotDePasse());
            pstmt.setString(7, etudiant.getAdresse());
            pstmt.setString(8, etudiant.getEmail());
            pstmt.setString(9, etudiant.getTelephone());
            pstmt.setBytes(10,etudiant.getImage());
            pstmt.setInt(11, etudiant.getId());

            //excution de la requette
            pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (pstmt != null) {
                pstmt.close();
            }
        }
    }

    @Override
    public void delete(int Id) throws SQLException {
        String query = "delete  from etudiant where id=?";
        try {
            pstmt = ConnexionDb.getConnection().prepareStatement(query);
            pstmt.setInt(1, Id);
            //execution de la requette
            pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (pstmt != null) {
            pstmt.close();
        }
    }

    public List<Etudiant> recupererTousLesEtudiants() throws SQLException {
        List<Etudiant> etudiants = new ArrayList<>();
        String query = "SELECT * FROM etudiants";
        try {
            pstmt = ConnexionDb.getConnection().prepareStatement(query);
            //executer la requete
            resultSet = pstmt.executeQuery();
            while (resultSet.next()) {
                etudiants.add(new Etudiant(
                                resultSet.getInt("Id"),
                                resultSet.getString("Nom"),
                                resultSet.getString("Prenom"),
                                resultSet.getInt("Age"),
                                resultSet.getString("Sexe"),
                                resultSet.getString("DateNaiss"),
                                resultSet.getString("MotDePass"),
                                resultSet.getString("Adresse"),
                                resultSet.getString("Email"),
                                resultSet.getString("Telephone"),
                                resultSet.getBytes("image")

                        )
                );

            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (resultSet != null) {
                resultSet.close();
            }
            if (pstmt != null) {
                pstmt.close();
            }
        }

        return etudiants;

    }

    public void deleteAll() throws SQLException {
        String query = "DELETE FROM etudiant";
        pstmt=ConnexionDb.getConnection().prepareStatement(query);
        pstmt.executeUpdate();
    }
}
