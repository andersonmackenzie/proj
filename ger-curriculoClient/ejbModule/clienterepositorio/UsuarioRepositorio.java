package clienterepositorio;

import java.util.List;

import br.com.entidade.Usuario;

public interface UsuarioRepositorio {
	public void adiciona(Usuario user);

	public void atualiza(Usuario user);

	public List<Usuario> getLista();

	public Usuario getUsuario(int cod);
}
