package fuctura.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {
	
	   public Connection getConnection(){
		   
		   String url = "jdbc:postgresql://localhost/fucturadb";
		   String usr = "postgres";
		   String psw = "toor";
	        
	        try {
	            
	            return DriverManager.getConnection(url, usr, psw);
	            
	        } catch (Exception erro) {
	            throw new RuntimeException(erro);
	        }
	   }

}
