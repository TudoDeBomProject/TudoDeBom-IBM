package tudDeBom;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DecimalFormat;

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
				int estoque = resulSet.getInt("estoque");

				System.out.println("id: " + id + " | nome: " + nome + " | quantidade: " + estoque);

			}
		} catch (Exception e) {
			System.out.println("Erro: " + e.getMessage());

		}
		System.out.println();
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

	public void criarPedido(String endereco, int idCliente) {
		try {

			// linha de execução da sintaxe de insert em SQL
			String query = "INSERT INTO pedido (endereco_entrega, cliente_id) values ('" + endereco
					+ "', '" + idCliente + "');";
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
			String query2 = "SELECT * FROM item_pedido WHERE pedido_id = '"+id+"' ;";
			this.resulSet = this.statement.executeQuery(query2);
			//obrigatorio
			this.statement = this.connection.createStatement();
			
			while(this.resulSet.next()) {
				int idProduto = resulSet.getInt("produto_id");
				int quantidade = resulSet.getInt("quantidade");
				
				String query3 = "UPDATE produto SET estoque = estoque + '"+quantidade+"' WHERE id = '"+idProduto+"';";
				this.statement.execute(query3);
			}
			
			
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

	public void addItemPedidoPedido(int pedidoId, int produtoId, int quantidade) {
		try {
			// linha de execução da sintaxe de insert em SQL

			String query3 = "select * from produto where id = '" + produtoId + "'";
			this.resulSet = this.statement.executeQuery(query3);
			this.statement = this.connection.createStatement();
			double precoUnitario = 0;
			int estoque = 0;
			boolean disponivel = false;
			boolean remedioFlag = false;
			boolean descontoFlag = false;
			if (resulSet.next()) {
				precoUnitario = resulSet.getDouble("preco");
				estoque = resulSet.getInt("estoque");
				disponivel = resulSet.getBoolean("disponibilidade");
				remedioFlag = resulSet.getBoolean("remedio_flag");
				descontoFlag = resulSet.getBoolean("desconto_flag");
			}

			if (estoque > 0 && disponivel) {

				if (remedioFlag == true || descontoFlag == true) {
					String query = "INSERT INTO item_pedido (pedido_id, produto_id, quantidade, sub_total) values ('"
							+ pedidoId + "', '" + produtoId + "', '" + quantidade + "', '"
							+ (quantidade * (precoUnitario -(precoUnitario * 0.2))) + "');";
					this.statement.execute(query);
					System.out.println(query);
					System.out.println("Descontado");
				} else {
					String query = "INSERT INTO item_pedido (pedido_id, produto_id, quantidade, sub_total) values ('"
							+ pedidoId + "', '" + produtoId + "', '" + quantidade + "', '"
							+ (quantidade * precoUnitario) + "');";
					this.statement.execute(query);
					System.out.println(query);
					System.out.println("Sem Desconto");
				}

				// Atualiza o estoque
				String query2 = "UPDATE produto SET estoque = estoque - '" + quantidade + "' WHERE id = '" + produtoId
						+ "';";

				// busca o preco total da entidade pedido
				String query4 = "select total_pedido from pedido where id = '" + pedidoId + "';";
				this.resulSet = this.statement.executeQuery(query4);
				double totalPedido = 0.0;
				if (resulSet.next()) {
					totalPedido = resulSet.getDouble("total_pedido");
				}
				double qtd = Double.valueOf(quantidade);
				double subTotal = (qtd * precoUnitario);
				String query5 = "UPDATE pedido SET total_pedido = '"+totalPedido+"' + '" + subTotal
						+ "'  WHERE id = '" + produtoId + "';";

				System.out.println("QUERY5 " + query5);
//				System.out.println(query);
//				this.statement.execute(query);
				this.statement.execute(query2);
				this.statement.execute(query5);
				System.out.println("Adicionado");
				System.out.println(disponivel);
			} else {
				System.out.println("Produto com estoque 0");
			}

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

	public void deletarItemPedido(int id, int pedidoId) {
		try {
			String query = "DELETE FROM item_pedido WHERE id = '" + id + "' AND pedido_id = '"+pedidoId+"';";
			String query3 = "SELECT *	FROM item_pedido WHERE id = '"+id+"';" ;
			this.resulSet = this.statement.executeQuery(query3);
			this.statement = this.connection.createStatement();
			int produtoId = 0;
			int quantidade = 0;
			System.out.println(query);
			
			
			if (this.resulSet.next()) {
				 produtoId = resulSet.getInt("produto_id");
				 quantidade = resulSet.getInt("quantidade");
//				this.statement = this.connection.createStatement();
//				this.resulSet = this.statement.executeQuery(query2);
//				System.out.println(query2);
			}
			String query2 = "UPDATE produto SET estoque = estoque + '"+quantidade+"' where id = '"+produtoId+"';";
//			this.resulSet = this.statement.executeQuery(query2);

			this.statement.executeUpdate(query2);
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

	public void listaCategoriasProdutos(String categoria) {

		try {

			PreparedStatement pst = this.connection.prepareStatement(
					"select c.tipo_categoria, p.nome, p.estoque from categoria c inner join produto p on p.categoria_id = c.id where c.tipo_categoria like '%"
							+ categoria + "%';");

			String query = "select c.tipo_categoria, p.nome, p.estoque from categoria c inner join produto p on p.categoria_id = c.id where c.tipo_categoria like '%"
					+ categoria + "%';";
			this.resulSet = this.statement.executeQuery(query);
			this.resulSet = pst.executeQuery();
			this.statement = this.connection.createStatement();

			while (this.resulSet.next()) {
				String tipoCategoria = resulSet.getString("c.tipo_categoria");
				String nomeProduto = resulSet.getString("p.nome");
				int estoqueProduto = resulSet.getInt("p.estoque");
				System.out.println(
						"Categoria: " + tipoCategoria + " | Produto: " + nomeProduto + " | Estoque: " + estoqueProduto);
			}
			System.out.println();

		} catch (Exception e) {
			System.out.println("Erro: " + e.getMessage());
		}

	}

}
