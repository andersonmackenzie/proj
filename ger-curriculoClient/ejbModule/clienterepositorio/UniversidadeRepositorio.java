package clienterepositorio;

import java.util.List;


import br.com.entidade.Universidade;

public interface UniversidadeRepositorio {
	public void adiciona(Universidade universidade);

	public void atualiza(Universidade universidade);

	public List<Universidade> getLista();

	public Universidade getUniversidade(int cod);
}
