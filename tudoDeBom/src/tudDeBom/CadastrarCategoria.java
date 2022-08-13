package tudDeBom;

import java.util.Scanner;

public class CadastrarCategoria {
	public static ConnectionBancoDeDados sintaxe = new ConnectionBancoDeDados();

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int opcao, id;
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
				System.out.println("Digite o Nome da categoria");
				nome = sc.next();
				System.out.println("Digte o ID da categoria que quer atualizar");
				id = sc.nextInt();
				atualizaCategoria(nome, id);
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
	
	public static void atualizaCategoria(String nome, int id) {
		if (sintaxe.estadoConectado()) {
			sintaxe.atualizarCategoria(nome, id);
			System.out.println("Categoria Atualizado!");

		} else {
			System.out.println("Erro ao atualizar a categoria");
		}
	}

}
