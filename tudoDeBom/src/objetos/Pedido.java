package objetos;

import java.util.Date;

public class Pedido {
	int id, clienteId;
	String enderecoEntrega;
	long miliseconds = System.currentTimeMillis();
	Date dataPedido = new Date(miliseconds);
	double totalPedido;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getClienteId() {
		return clienteId;
	}
	public void setClienteId(int clienteId) {
		this.clienteId = clienteId;
	}
	public String getEnderecoEntrega() {
		return enderecoEntrega;
	}
	public void setEnderecoEntrega(String enderecoEntrega) {
		this.enderecoEntrega = enderecoEntrega;
	}
	public Date getDataPedido() {
		return dataPedido;
	}
	public void setDataPedido(Date dataPedido) {
		this.dataPedido = dataPedido;
	}
	public double getTotalPedido() {
		return totalPedido;
	}
	public void setTotalPedido(double totalPedido) {
		this.totalPedido = totalPedido;
	}
	@Override
	public String toString() {
		return "Pedido [id=" + id + ", clienteId=" + clienteId + ", enderecoEntrega=" + enderecoEntrega
				+ ", miliseconds=" + miliseconds + ", dataPedido=" + dataPedido + ", totalPedido=" + totalPedido + "]";
	}
	
	
}
