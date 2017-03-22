package BancoDAO;

import BancoModel.Conta;

public interface ContaDAO {
	void update(Conta conta);

	void inserir(Conta conta);

	Conta porNumero(Long numero);

	Conta getConta(String conta);

}
