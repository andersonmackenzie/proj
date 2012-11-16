package clienterepositorio;

import java.util.List;

import br.com.entidade.Endereco;

public interface EnderecoRepositorio {

	public void adiciona(Endereco endereco);

	public void atualiza(Endereco endereco);

	public List<Endereco> getLista();

	public Endereco getEndereco(int cod);
}
