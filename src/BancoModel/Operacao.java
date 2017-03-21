package BancoModel;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;



public class Operacao {
	List<Operacao> ListOperacao = new ArrayList<>();
	private SimpleDateFormat data;
	private Double valor;
	private String tipoOperacao;
	public List<Operacao> getListOperacao() {
		return ListOperacao;
	}
	public void setListOperacao(List<Operacao> listOperacao) {
		ListOperacao = listOperacao;
	}
	public SimpleDateFormat getData() {
		return data;
	}
	public void setData(SimpleDateFormat data) {
		this.data = data;
	}
	public Double getValor() {
		return valor;
	}
	public void setValor(Double valor) {
		this.valor = valor;
	}
	public String getTipoOperacao() {
		return tipoOperacao;
	}
	public void setTipoOperacao(String tipoOperacao) {
		this.tipoOperacao = tipoOperacao;
	
	}

}