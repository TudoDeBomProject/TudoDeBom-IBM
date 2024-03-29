package objetos;

public class Produto {
	private int id, estoque;
	private double preco, precoDescontado;

	public double getPrecoDescontado() {
		return precoDescontado;
	}

	public void setPrecoDescontado(double precoDescontado) {
		this.precoDescontado = precoDescontado;
	}

	private String nome, categoria;
	private boolean disponibilidade, remedio, generico;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getEstoque() {
		return estoque;
	}

	public void setEstoque(int estoque) {
		this.estoque = estoque;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public boolean isDisponibilidade() {
		return disponibilidade;
	}
	
	public String getDisponibilidade() {
		if(isDisponibilidade()) {
			return "Sim";
		}
			return "N�o";
		
	}

	public void setDisponibilidade(boolean disponibilidade) {
		this.disponibilidade = disponibilidade;
	}

	public boolean isRemedio() {
		return remedio;
	}
	
	public String getRemedio() {
		if(isRemedio()) {
			return "Sim";
		}
		return "N�o";
	}

	public void setRemedio(boolean remedio) {
		this.remedio = remedio;
	}

	public boolean isGenerico() {
		return generico;
	}
	
	public String getGenerico() {
		if(isGenerico()) {
			return "Sim";
		}
		return "N�o";
	}

	public void setGenerico(boolean generico) {
		this.generico = generico;
	}

	@Override
	public String toString() {
		return "Produto [id=" + id + ", estoque=" + estoque + ", preco=" + preco + ", nome=" + nome + ", categoria="
				+ categoria + ", disponibilidade=" + disponibilidade + ", remedio=" + remedio + ", generico=" + generico
				+ "]";
	}

}
