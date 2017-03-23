package BancoServlet;

public enum TipoOpr {
	
	DEBITO (true, false), CREDITO (false, true); 
	
	private TipoOpr(boolean debito, boolean credito) {
		this.debito = debito;
		this.credito = credito;
	}

	private boolean debito;
	
	public boolean isDebito() {
		return debito;
	}

	public void setDebito(boolean debito) {
		this.debito = debito;
	}

	public boolean isCredito() {
		return credito;
	}

	public void setCredito(boolean credito) {
		this.credito = credito;
	}

	private boolean credito;

}
