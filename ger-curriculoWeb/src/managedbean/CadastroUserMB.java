package managedbean;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import clienterepositorio.UsuarioRepositorio;
import br.com.entidade.Usuario;

@ManagedBean
@RequestScoped
public class CadastroUserMB {
	@EJB
	private UsuarioRepositorio repositorio;
	private Usuario usuario = new Usuario();
	private List<Usuario> usuarioCache;

	public String adiciona() {
		repositorio.adiciona(this.usuario);
		this.usuario = new Usuario();
		this.usuarioCache = null;
		return "";
	}
	public String modifica() {
		
		return "";
	}
	public List<Usuario> getListaUsuario() {
		if (this.usuarioCache == null) {
			this.usuarioCache = this.repositorio.getLista();

		}
		return this.usuarioCache;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}
