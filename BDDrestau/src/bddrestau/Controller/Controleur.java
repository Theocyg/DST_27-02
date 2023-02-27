package bddrestau.Controller;

import bddrestau.Model.Repository;
import bddrestau.View.Vue2;
import bddrestau.Model.Connexion;
import bddrestau.Model.Repository;
import bddrestau.View.*;
import java.awt.Font;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class Controleur {
    public void traiterRequete(Connection conn) throws SQLException {

        ResultSet rst1 = null, rst2 = null, rst3 = null;


        try {
            //Appel de la méthode getConnexio() via la classe Connexion

            //Création d'objets de la classe Vue

            //PREMIERE REQUETE
            Vue1 vue1 = new Vue1(); //Pour la première requête
            String req1 = "SELECT m.nom AS menu, GROUP_CONCAT(a.nom SEPARATOR ', ') AS aliments\n" +
                    "FROM menu m\n" +
                    "JOIN menu_aliment ma ON m.id = ma.idMenu\n" +
                    "JOIN aliment a ON ma.idAlim = a.id\n" +
                    "GROUP BY m.nom;\n";
            Repository rep1 = new Repository();
            rst1 = rep1.requete(conn, req1);
            vue1.showView(rst1);

            //DEUXIEME REQUETE
            Vue2 vue2 = new Vue2(); //Pour la deuxième requête
            String req2 = "SELECT client.nom_pren, client_menu.idMenu, client_menu.mois_annee, client_menu.nbre_menu, client_menu.sauce, client_menu.livraison, client_menu.paiement\n" +
                    "FROM client\n" +
                    "INNER JOIN client_menu ON client.id = client_menu.idClient\n" +
                    "WHERE client.id = idClient AND client_menu.mois_annee BETWEEN '1022' AND '1222';\n";
            Repository rep2 = new Repository();
            rst2 = rep2.requete(conn, req2);
            vue2.showView(rst2);

            Vue3 vue3 = new Vue3();
            String req3 = "SELECT SUBSTR(mois_annee,1,2) AS Numéro_mois, SUM(nbre_menu * tarif) AS Montant_total\n" +
                    "FROM client_menu\n" +
                    "JOIN menu ON client_menu.idMenu = menu.id\n" +
                    "GROUP BY SUBSTR(mois_annee,1,2)\n" +
                    "ORDER BY SUBSTR(mois_annee,1,2);\n";
            Repository rep3 = new Repository();
            rst3 = rep3.requete(conn, req3);
            vue3.showView(rst3);
        } catch (Exception se) {
            System.out.println(se.getMessage());
        }
    }
}
