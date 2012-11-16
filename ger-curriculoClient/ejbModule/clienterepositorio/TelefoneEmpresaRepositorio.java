package clienterepositorio;

import java.util.List;

import br.com.entidade.TelefoneEmpresa;

public interface TelefoneEmpresaRepositorio {
	public void adiciona(TelefoneEmpresa telefone);

	public void atualiza(TelefoneEmpresa telefone);

	public List<TelefoneEmpresa> getLista();

	public TelefoneEmpresa getUsuario(int cod);
}
