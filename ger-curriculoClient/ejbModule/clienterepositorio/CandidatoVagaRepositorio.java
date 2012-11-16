package clienterepositorio;

import java.util.List;

import br.com.entidade.CandidatoVaga;

public interface CandidatoVagaRepositorio {

	public void adiciona(CandidatoVaga candVaga);

	public void atualiza(CandidatoVaga candVaga);
	
	public List<CandidatoVaga> getListaCandidatoVaga();
}
