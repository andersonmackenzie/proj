package clienterepositorio;

import java.util.List;

import br.com.entidade.Login;


public interface LoginRepositorio {
	
	public void adiciona(Login login);

	public void atualiza(Login login);
	
	public List<Login> getLista();
}
