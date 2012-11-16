package clienterepositorio;

import java.util.List;

import br.com.entidade.Vagas;

public interface VagasRepositorio {

	public void adiciona(Vagas vaga);

	public void atualiza(Vagas vaga);

	public List<Vagas> getLista();

	public Vagas getUsuario(int cod);
}
