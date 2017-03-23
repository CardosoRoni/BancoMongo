package BancoModel;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import BancoServlet.TipoOpr;



public class Operacao {
	
	private Date data;
	private Double valor;
	private TipoOpr tipoOperacao;
	
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public Double getValor() {
		return valor;
	}
	public void setValor(Double valor) {
		this.valor = valor;
	}
	public TipoOpr getTipoOperacao() {
		return tipoOperacao;
	}
	public void setTipoOperacao(TipoOpr tipoOperacao) {
		this.tipoOperacao = tipoOperacao;
	}
	
}