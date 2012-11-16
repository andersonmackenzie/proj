package clienterepositorio;

import java.util.List;

import br.com.entidade.TipoDeTelefone;

public interface TipoDeTelefoneRepositorio {
	public void adiciona(TipoDeTelefone tipo);

	public void atualiza(TipoDeTelefone tipo);

	public List<TipoDeTelefone> getLista();

	public TipoDeTelefone getTipo(int cod);
}
