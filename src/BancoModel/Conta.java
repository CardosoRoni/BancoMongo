package BancoModel;


public class Conta {
	
	private Integer numero;
	private String senha;
	private Cliente cliente;
	private Double saldo;
	

	public Conta(Integer numero, String senha, BancoModel.Cliente cliente, Double saldo) {
		super();
		this.numero = numero;
		this.senha = senha;
		this.cliente = cliente;
		this.saldo = saldo;
	}

	public Conta() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Double getSaldo() {
		return saldo;
	}

	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}
}
