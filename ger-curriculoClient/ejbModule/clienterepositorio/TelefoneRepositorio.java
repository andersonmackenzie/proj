package clienterepositorio;

import java.util.List;

import br.com.entidade.Telefone;

public interface TelefoneRepositorio {
	public void adiciona(Telefone telefone);

	public void atualiza(Telefone telefone);

	public List<Telefone> getLista();

	public Telefone getUsuario(int cod);
}
