package bddrestau.View;
import bddrestau.Preparation;
import bddrestau.Preparation;
import java.awt.Font;
import java.sql.ResultSet;
import java.sql.SQLException;
public class Vue1 implements Preparation {
    public void showView(ResultSet result) throws SQLException  {

        try {
            String titre1 = "\033[1mListe des candidats\033[1m";
            System.out.println(YELLOW_BRIGHT + ANSI_BLACK_BACKGROUND + titre1 + ANSI_RESET);

            while (result.next()) {
                //Traitement requête
                String menu = result.getString("menu");
                String aliments= result.getString("aliments");
                System.out.println(ANSI_BLUE + menu+"\t\t\t"+aliments+"\t\t\t") ;
            }
        }
        catch(SQLException se) {
            se.getMessage();
        }
    }
}
