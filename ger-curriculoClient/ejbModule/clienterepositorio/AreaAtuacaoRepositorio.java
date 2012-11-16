package clienterepositorio;

import java.util.List;

import br.com.entidade.AreaAtuacao;
import br.com.entidade.Usuario;

public interface AreaAtuacaoRepositorio {

	public void adiciona(AreaAtuacao area);

	public void atualiza(AreaAtuacao area);
	
	public List<AreaAtuacao> getListaArea();
	
	public AreaAtuacao getArea(int cod);
}
