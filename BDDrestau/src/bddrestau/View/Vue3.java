package bddrestau.View;
import bddrestau.Preparation;
import bddrestau.Preparation;
import java.awt.Font;
import java.sql.ResultSet;
import java.sql.SQLException;
public class Vue3 implements Preparation {
    public void showView(ResultSet result) throws SQLException  {
            try {
                String titre1 = "\033[1mListe des candidats par spécialité\033[1m";
                System.out.printf("\n\n");
                System.out.println(YELLOW_BRIGHT + ANSI_BLACK_BACKGROUND + titre1 + ANSI_RESET);
                while (result.next()) {
                    //Traitement requête
                    String mois_annee = result.getString("Numéro Mois");
                    String nbre_menu = result.getString("Nombre Menu");
                    String tarif = result.getString("Montant Total");
                    System.out.println(ANSI_RED + mois_annee + "\t\t\t" + nbre_menu + "\t\t\t");
                }
            }
            catch(SQLException se) {
                se.getMessage();
            }
        }
    }
