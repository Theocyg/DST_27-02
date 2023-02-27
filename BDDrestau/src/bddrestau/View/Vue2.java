package bddrestau.View;

import bddrestau.Preparation;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Vue2 implements Preparation {
    public void showView(ResultSet result) throws SQLException {
        try {
            String titre1 = "\033[1mListe des candidats par spécialité\033[1m";
            System.out.printf("\n\n");
            System.out.println(YELLOW_BRIGHT + ANSI_BLACK_BACKGROUND + titre1 + ANSI_RESET);
            while (result.next()) {
                //Traitement requête
                String idClient = result.getString("IdClient");
                String idMenu = result.getString("idMenu");
                String mois_annee = result.getString("Mois et Annee");
                String nbre_menu = result.getString("Nombre Menu");
                String sauce = result.getString("Sauces");
                String livraison = result.getString("livraison");
                String paiement = result.getString("Paiement");
                System.out.println(ANSI_RED + idClient + "\t\t\t" + idMenu + "\t\t\t" + mois_annee + "\t\t\t" +nbre_menu + "\t\t\t" +sauce + "\t\t\t" +livraison + "\t\t\t" +paiement + "\t\t\t");
            }
        }
        catch(SQLException se) {
            se.getMessage();
        }
    }
}
