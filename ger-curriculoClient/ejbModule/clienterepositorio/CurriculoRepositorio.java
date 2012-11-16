package clienterepositorio;

import java.util.List;

import br.com.entidade.Curriculo;


public interface CurriculoRepositorio {
	public void adiciona(Curriculo curriculo);

	public void atualiza(Curriculo curriculo);

	public List<Curriculo> getLista();

	public Curriculo getCurriculo(int cod);
}
