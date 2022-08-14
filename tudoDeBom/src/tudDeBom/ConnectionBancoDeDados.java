package tudDeBom;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ConnectionBancoDeDados {

	private Connection connection = null;
	private Statement statement = null;
	private ResultSet resulSet = null;

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
					+ id + "', '" + nome + "', '" + estoque + "', '" + preco + "', " + disponibilidade + ", "
					+ descontoFlag + ", " + remedioFlag + ");";

			System.out.println(query);
			this.statement.execute(query);
		} catch (Exception e) {
			System.out.println("Erro adicionar produto: " + e.getMessage());

		}
	}

	public void atualizarProduto(int categoriaId, String nome, int estoque, double preco, boolean disponibilidade,
			boolean descontoFlag, boolean remedioFlag, int id) {
		try {
			String query = "UPDATE produto SET categoria_id = '" + id + "', nome = '" + nome + "', estoque = '"
					+ estoque + "', preco = '" + preco + "', disponibilidade = " + disponibilidade
					+ ", desconto_flag = " + descontoFlag + ", remedio_flag = " + remedioFlag + "  WHERE id ='" + id
					+ "';";
			System.out.println(query);
			this.statement.execute(query);
		} catch (Exception e) {
			System.out.println("Erro ao atualizar produto: " + e.getMessage());
		}
	}

	public void deletarProduto(int id) {
		try {
			String query = "DELETE FROM produto WHERE id = '" + id + "' ;";
			System.out.println(query);
			this.statement.execute(query);
		} catch (Exception e) {
			System.out.println("Erro ao deletar o id = " + id + e.getMessage());
		}
	}

	public void listarProdutos() {

		try {
			// tratando a conexão do nosso retorno do select
			// o mysql não é case sensitive
			String query = "SELECT * FROM 	produto";
			this.resulSet = this.statement.executeQuery(query);
			this.statement = this.connection.createStatement();

			// criando um laço de repetição para retornan os registros da nossa tabela
			while (this.resulSet.next()) {
				String id = resulSet.getString("id");
				String nome = resulSet.getString("nome");

				System.out.println("id: " + id + ", nome: " + nome);
				System.out.println();
			}
		} catch (Exception e) {
			System.out.println("Erro: " + e.getMessage());

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
			String query = "DELETE FROM categoria WHERE id = '" + id + "' ;";
			System.out.println(query);
			this.statement.execute(query);
		} catch (Exception e) {
			System.out.println("Erro ao deletar o id = " + id + e.getMessage());
		}
	}

	public void listarCategorias() {

		try {
			// tratando a conexão do nosso retorno do select
			// o mysql não é case sensitive
			String query = "SELECT * FROM 	categoria";
			this.resulSet = this.statement.executeQuery(query);
			this.statement = this.connection.createStatement();

			// criando um laço de repetição para retornan os registros da nossa tabela
			while (this.resulSet.next()) {
				String id = resulSet.getString("id");
				String nome = resulSet.getString("tipo_categoria");

				System.out.println("id: " + id + ", tipo_alimento: " + nome);
				System.out.println();
			}
		} catch (Exception e) {
			System.out.println("Erro: " + e.getMessage());

		}
	}

	public void criarPedido(String endereco, double valorTotal, int idCliente) {
		try {
			// linha de execução da sintaxe de insert em SQL
			String query = "INSERT INTO pedido (endereco_entrega, total_pedido, cliente_id) values ('" + endereco
					+ "', '" + valorTotal + "', '" + idCliente + "');";
			System.out.println(query);
			this.statement.execute(query);
		} catch (Exception e) {
			System.out.println("Erro criar pedido: " + e.getMessage());
		}
	}

	public void atualizarPedido(String endereco, int id) {
		try {

			String query = "UPDATE pedido SET endereco_entrega = '" + endereco + "' WHERE id = '" + id + "';";
			System.out.println(query);
			this.statement.execute(query);
		} catch (Exception e) {
			System.out.println("Erro ao atualizar categoria: " + e.getMessage());
		}
	}

	public void deletarPedido(int id) {
		try {
			String query = "DELETE FROM pedido WHERE id = '" + id + "' ;";
			System.out.println(query);
			this.statement.execute(query);
		} catch (Exception e) {
			System.out.println("Erro ao deletar o id = " + id + e.getMessage());
		}
	}

	public void listarPedido() {

		try {
			// tratando a conexão do nosso retorno do select
			// o mysql não é case sensitive
			String query = "SELECT * FROM 	pedido";
			this.resulSet = this.statement.executeQuery(query);
			this.statement = this.connection.createStatement();

			// criando um laço de repetição para retornan os registros da nossa tabela
			while (this.resulSet.next()) {
				String id = resulSet.getString("id");
				String endereco = resulSet.getString("endereco_entrega");
				Double totalPedido = resulSet.getDouble("total_pedido");
				String idCliente = resulSet.getString("cliente_id");

				System.out.println("id: " + id + ", endereco_entrega: " + endereco + ", total_pedido: " + totalPedido
						+ " ,cliente_id: " + idCliente);
				System.out.println();
			}
		} catch (Exception e) {
			System.out.println("Erro: " + e.getMessage());

		}
	}

	public void addItemPedidoPedido(int pedidoId, int produtoId, int quantidade, double subTotal) {
		try {
			// linha de execução da sintaxe de insert em SQL
			String query = "INSERT INTO item_pedido (pedido_id, produto_id, quantidade, sub_total) values ('" + pedidoId
					+ "', '" + produtoId + "', '" + quantidade + "', '" + subTotal + "');";
			System.out.println(query);
			this.statement.execute(query);
		} catch (Exception e) {
			System.out.println("Erro ao adicionar item pedido: " + e.getMessage());
		}
	}

	public void atualizarItemPedido(int pedidoId, int produtoId, int quantidade, double subTotal, int idItemPedido) {
		try {

			String query = "UPDATE item_pedido SET pedido_id = '" + pedidoId + "', produto_id = '" + produtoId
					+ "', quantidade = '" + quantidade + "', sub_total = '" + subTotal + "'  WHERE id = '"
					+ idItemPedido + "';";
			System.out.println(query);
			this.statement.execute(query);
		} catch (Exception e) {
			System.out.println("Erro ao atualizar Item Pedido: " + e.getMessage());
		}
	}

	public void deletarItemPedido(int id) {
		try {
			String query = "DELETE FROM item_pedido WHERE id = '" + id + "' ;";
			System.out.println(query);
			this.statement.execute(query);
		} catch (Exception e) {
			System.out.println("Erro ao deletar o id = " + id + e.getMessage());
		}
	}

	public void listaItensPedido() {

		try {
			// tratando a conexão do nosso retorno do select
			// o mysql não é case sensitive
			String query = "SELECT * FROM 	item_pedido";
			this.resulSet = this.statement.executeQuery(query);
			this.statement = this.connection.createStatement();

			// criando um laço de repetição para retornan os registros da nossa tabela
			while (this.resulSet.next()) {
				int id = resulSet.getInt("id");
				int pedidoId = resulSet.getInt("pedido_id");
				int produtoId = resulSet.getInt("produto_id");
				int quantidade = resulSet.getInt("quantidade");
				double subTotal = resulSet.getDouble("sub_total");

				System.out.println("id: " + id + ", pedido_id: " + pedidoId + ", produto_id: " + produtoId
						+ " ,quantidade: " + quantidade + ", sub_total: " + subTotal);
				System.out.println();
			}
		} catch (Exception e) {
			System.out.println("Erro: " + e.getMessage());

		}
	}

}
