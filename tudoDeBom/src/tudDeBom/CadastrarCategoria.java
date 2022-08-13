package tudDeBom;

import java.util.Scanner;

public class CadastrarCategoria {
	public static ConnectionBancoDeDados sintaxe = new ConnectionBancoDeDados();

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int opcao;
		String nome;
		sintaxe.conectar();
		do {
			System.out.println("Escolha uma das opções: ");
			System.out.println("1 - Adicionar categoria");
			System.out.println("2 - Atualizar categoria");
			System.out.println("3 - Deletar categoria");
			System.out.println("4 - Lista de categorias");
			System.out.println("5 - Sair");
			opcao = sc.nextInt();

			switch (opcao) {
			case 1:
				System.out.println("Digite o NOME da categoria");
				nome = sc.next();
				adicionarCategoria(nome);
				break;
			case 2:
				System.out.println("Digite ");
				break;

			case 3:

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
	
	public static void adicionarCategoria(String nome) {
		if (sintaxe.estadoConectado()) {
			sintaxe.adicionarCategoria(nome);
			System.out.println("Categoria Adicionado!");

		} else {
			System.out.println("Erro ao Adicionar a categoria");
		}
	}

}
