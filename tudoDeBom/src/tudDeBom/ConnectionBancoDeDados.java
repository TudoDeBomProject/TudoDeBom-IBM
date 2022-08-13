package tudDeBom;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class ConnectionBancoDeDados {

	private Connection connection = null;
	private Statement statement = null;
//	private ResultSet resulSet = null;

	public void conectar() {
		// Criação da variavel para conctar ao database
		String servidor = "jdbc:mysql://localhost/tudodebom2";
		String usuario = "root";
		String senha = "root";
		String driver = "com.mysql.cj.jdbc.Driver";

		// Permite verificar o tratamento da exceção caso ok banco de dados
		try {
			Class.forName(driver);
			this.connection = DriverManager.getConnection(servidor, usuario, senha);
			statement = this.connection.createStatement();

		} catch (Exception e) {
			System.out.println("Erro: " + e.getMessage());
		}
	}

	public boolean estadoConectado() {
		if (this.connection != null) {
			return true;
		} else {
			return false;
		}

	}

	public void atualizarCliente(String nome, int id) {
		try {

			String query = "UPDATE cliente SET nome = '" + nome + "' WHERE id = '" + id + "';";
			System.out.println(query);
			this.statement.execute(query);
		} catch (Exception e) {
			System.out.println("Erro: " + e.getMessage());
		}
	}

	public void deletarCliente(int id) {
		try {
			String query = "DELETE FROM cliente WHERE id = '" + id + "' ;";
			System.out.println(query);
			this.statement.execute(query);
		} catch (Exception e) {
			System.out.println("Erro ao deletar o id = " + id + e.getMessage());
		}
	}

	public void adicionarCliente(String nome, String cpf) {
		try {
			// linha de execução da sintaxe de insert em SQL
			String query = "INSERT INTO cliente (nome, cpf) values ('" + nome + "', '" + cpf + "');";
			System.out.println(query);
			this.statement.execute(query);
		} catch (Exception e) {
			System.out.println("Erro adicionar cliente: " + e.getMessage());
		}
	}

	public void adicionarProduto(int id, String nome, int estoque, double preco, boolean disponibilidade,
			boolean descontoFlag, boolean remedioFlag) {
		try {
			String query = "INSERT INTO produto (categoria_id, nome, estoque, preco, disponibilidade, desconto_flag, remedio_flag) values ('"
					+ id + "', '" + nome + "', '" + estoque + "', '" + preco + "', '" + disponibilidade + "', '"
					+ descontoFlag + "', '" + remedioFlag + "');";
			System.out.println(query);
			this.statement.execute(query);
		} catch (Exception e) {
			System.out.println("Erro adicionar produto: " + e.getMessage());

		}
	}
	
	public void adicionarCategoria(String nome) {
		try {
			// linha de execução da sintaxe de insert em SQL
			String query = "INSERT INTO categoria (tipo_categoria) values ('" + nome + "');";
			System.out.println(query);
			this.statement.execute(query);
		} catch (Exception e) {
			System.out.println("Erro adicionar categoria: " + e.getMessage());
		}
	}
	
	public void atualizarCategoria(String nome, int id) {
		try {

			String query = "UPDATE categoria SET tipo_categoria = '" + nome + "' WHERE id = '" + id + "';";
			System.out.println(query);
			this.statement.execute(query);
		} catch (Exception e) {
			System.out.println("Erro ao atualizar categoria: " + e.getMessage());
		}
	}
	
	public void deletarCategoria(int id) {
		try {
			String query = "DELETE FROM cliente WHERE id = '" + id + "' ;";
			System.out.println(query);
			this.statement.execute(query);
		} catch (Exception e) {
			System.out.println("Erro ao deletar o id = " + id + e.getMessage());
		}
	}

}
