package bddrestau;
import bddrestau.Controller.Controleur;
import bddrestau.Model.Connexion;

import java.sql.*;
import java.util.*;
import java.awt.*;

public class BDDrestau {

    public static void main(String[] args) throws SQLException {
        //Initialisation des paramètres de connexion
        Properties props = new Properties();
        String url = "jdbc:mysql://localhost:3306/restauration";
        props.setProperty("user","root");
        props.setProperty("password","root");

        //Création d'un objet controller
        Controleur ctl1 = new Controleur();

        //Appel du modèle
        Connection conn = Connexion.getConnexion(url, props);

        //Appel du controller
        ctl1.traiterRequete(conn);
    }
}