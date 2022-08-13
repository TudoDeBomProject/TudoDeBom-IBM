package tudDeBom;
import java.util.Scanner;

public class CadastroProduto {
	
	public static ConnectionBancoDeDados sintaxe = new ConnectionBancoDeDados();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String nome;
		int opcao, id, estoque;
		double preco;
		boolean disponibilidade, descontoFlag, remedioFlag;
		do {
			System.out.println("Escolha uma das opções: ");
			System.out.println("1 - Adicionar produto");
			System.out.println("2 - Atualizar produto");
			System.out.println("3 - Deletar produto");
			System.out.println("4 - Lista de produtos");
			System.out.println("5 - Sair");
			opcao = sc.nextInt();

			switch (opcao) {
			case 1:
				System.out.println("Digite o ID da categoria");
				id = sc.nextInt();
				System.out.println("Digite o Nome do produto");
				nome = sc.next();
				System.out.println("Digite a quantidade do ESTOQUE do produto");
				estoque = sc.nextInt();
				System.out.println("Digite o PREÇO do produto");
				preco = sc.nextDouble();
				System.out.println("Digite TRUE ou FALSE se o produto esta DISPONIVEL");
				disponibilidade = sc.hasNext();
				System.out.println("Digite TRUE ou FALSE se o produto esta com Desconto se for um item qualquer");
				descontoFlag = sc.hasNext();
				System.out.println("Digite TRUE se o produto for um remedio generico");
				remedioFlag = sc.hasNext();
				adicionarProduto(id, nome, estoque, preco, disponibilidade, descontoFlag, remedioFlag);
				break;
			case 2:
				System.out.println("Digite o nome do cliente");
				nome = sc.next();
				System.out.println("Digite o id do cliente");
				id = sc.nextInt();

				break;
			case 3:
				System.out.println("Digite o id do cliente para deletar");
				id = sc.nextInt();

				break;
			case 4:

				break;
			case 5:
				System.out.println("Saindo...");
				break;
			default:
				System.out.println("Opção invalida");

				break;
			}
		} while (opcao != 5);
		sc.close();
	}
	
	public static void adicionarProduto(int id, String nome, int estoque, double preco, boolean disponibilidade,
			boolean descontoFlag, boolean remedioFlag) {
		if (sintaxe.estadoConectado()) {
			sintaxe.adicionarProduto(id, nome, estoque, preco, disponibilidade, descontoFlag, remedioFlag);
			System.out.println("Cliente Adicionado!");
		} else {
			System.out.println("Erro ao Adicionar o produto");
		}
	}
}
