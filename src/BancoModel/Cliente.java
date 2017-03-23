package BancoModel;

public class Cliente {
	private Conta conta;
	
	public Cliente() {
		
	}
	public Cliente(Conta conta, String nome, String cpf, Double renda) {
		super();
		this.conta = conta;
		this.nome = nome;
		this.cpf = cpf;
		this.renda = renda;
	}

	public Conta getConta() {
		return conta;
	}

	public void setConta(Conta conta) {
		this.conta = conta;
	}

	private String nome;
	private String cpf;
	private Double renda;


	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Double getRenda() {
		return renda;
	}

	public void setRenda(Double renda) {
		this.renda = renda;
	}

}