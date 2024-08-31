package pack.com.poo;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

    public class ConnexionDb {
        private static final String URL = "jdbc:mysql://localhost:3306/gestetudiant ";
        private static final String USER = "root";
        private static final String PASSWORD = "";

        public static Connection getConnection() {
            Connection connection = null;
            try {
                // Charge le driver JDBC pour MySQL
                Class.forName("com.mysql.cj.jdbc.Driver");
                // Établit la connexion avec la base de données
                connection = DriverManager.getConnection(URL, USER, PASSWORD);
                System.out.println("Connexion réussie à la base de données");
            } catch (ClassNotFoundException e) {
                System.out.println("Le driver JDBC est introuvable");
                e.printStackTrace();
            } catch (SQLException e) {
                System.out.println("Erreur lors de la connexion à la base de données");
                e.printStackTrace();
            }
            return connection;
        }
    }




