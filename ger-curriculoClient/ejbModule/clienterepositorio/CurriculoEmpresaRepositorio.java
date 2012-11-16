package clienterepositorio;

import java.util.List;

import br.com.entidade.CurriculoEmpresa;


public interface CurriculoEmpresaRepositorio {
	public void adiciona(CurriculoEmpresa curEmpresa);

	public void atualiza(CurriculoEmpresa curEmpresa);

	public List<CurriculoEmpresa> getLista();

	public CurriculoEmpresa getCurriculoEmpresa(int cod);
}
