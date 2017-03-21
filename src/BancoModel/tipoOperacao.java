package BancoModel;

public enum tipoOperacao {

	
	CREDITO(true, false),
	DEBITO(false, true);

	private boolean credito;
	private boolean debito;
	
	private tipoOperacao(boolean credito, boolean debito) {
		this.credito = credito;
		this.debito = debito;
	}

	public boolean isCredito() {
		return credito;
	}

	public void setCredito(boolean credito) {
		this.credito = credito;
	}

	public boolean isDebito() {
		return debito;
	}

	public void setDebito(boolean debito) {
		this.debito = debito;
	}

	
}
