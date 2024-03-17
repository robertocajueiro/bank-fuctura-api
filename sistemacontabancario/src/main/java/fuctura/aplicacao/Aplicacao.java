package fuctura.aplicacao;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Aplicacao {

	public static void main(String[] args) throws SQLException {
		
		var url = "jdbc:postgresql://localhost/postgres";
		var username = "postgres";
		var password = "toor";

		var conexao = DriverManager.getConnection(url, username, password);
		
		System.out.println("Conectado com Sucesso!");
		
		String sql = "insert into usuario(nome, email, cpf, idade) "
				+ "values (?, ?, ?, ?);";
		
		PreparedStatement stmt = conexao.prepareStatement(sql);
		
		stmt.setString(1, "Carlos");
		stmt.setString(2, "carlos@localhost");
		stmt.setString(3, "123456789");
		stmt.setInt(4, 34);
		
		stmt.execute();
        stmt.close();
	}

}
