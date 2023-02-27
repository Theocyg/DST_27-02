package bddrestau.Model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class Repository {
    Statement stmt=null;
    ResultSet result;

    public Repository() { }

    public ResultSet requete(Connection conn, String req) {
        try {
            this.stmt = (Statement) conn.createStatement();
            this.result = stmt.executeQuery(req) ;
        }
        catch(Exception e){
            System.out.println("Erreur : "+e.getMessage());
        }
        return this.result;

    }

}

