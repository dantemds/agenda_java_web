package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class DAO {
	/** Modulo de conexão */

	/* parametros de conexão */
	private String driver = "com.mysql.cj.jdbc.Driver";
	private String url = "jdbc:mysql://127.0.0.1:3306/dbagenda?useTimezone=true&serverTimezone=UTC";
	private String user = "root";
	private String password = "Odonto55";

	/* metodo de conexão */
	private Connection conectar() {
		Connection con = null;
		try {
			Class.forName(driver);
			con = (Connection) DriverManager.getConnection(url, user, password);
			return con;
		} catch (Exception e) {
			System.out.println(e);
			return null;

		}

	}
	/*
	 * Teste de conexão
	 * 
	 * 
	 * 
	 * public void testeconexao() { try { Connection con = conectar();
	 * System.out.println(con); con.close(); } catch (Exception e) {
	 * System.out.println(e);
	 * 
	 * } }
	 *
	 *
	 *
	 * 
	 */

	/* CRUD CREATE */
	public void inserirContato(JavaBeans contato) {
		String create = "insert into contatos (nome, telefone, email) values (?,?,?)";
		try {
			// abrir conexão
			Connection con = conectar();

			// preparar a query para execução no BD
			PreparedStatement pst = con.prepareStatement(create);

			// substituir ???
			pst.setString(1, contato.getNome());
			pst.setString(2, contato.getTelefone());
			pst.setString(3, contato.getEmail());

			// executar query
			pst.executeUpdate();

			// encerrar conexão
			con.close();

		} catch (Exception e) {
			System.out.println(e);

		}
	}

	/* CRUD READ */
	// criando obj pra acessar javabeans
	ArrayList<JavaBeans> contatos = new ArrayList<>();

	public ArrayList<JavaBeans> listarContatos() {

		String read = "select * from contatos order by nome";
		try {
			Connection con = conectar();

			PreparedStatement pst = con.prepareStatement(read);
			// armazena o retorno temporariamente (rs)
			ResultSet rs = pst.executeQuery();

			// laço será executado enquanto houver contatos
			while (rs.next()) {
				// variaveis de apoio que receberão
				String id = rs.getString(1);
				String nome = rs.getString(2);
				String telefone = rs.getString(3);
				String email = rs.getString(4);

				// populando o arraylist
				contatos.add(new JavaBeans(id, nome, telefone, email));

			}
			con.close();
			return contatos;
		} catch (Exception e) {
			System.out.println(e);
			return null;

		}
	}

}
