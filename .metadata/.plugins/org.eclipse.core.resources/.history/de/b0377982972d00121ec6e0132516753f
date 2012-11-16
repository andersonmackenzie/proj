package managedbean;

import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import clienterepositorio.EnderecoRepositorio;
import clienterepositorio.UsuarioRepositorio;
import br.com.entidade.Endereco;
import br.com.entidade.Usuario;

@ManagedBean
@RequestScoped
public class CadastroMB {
	@EJB
	private UsuarioRepositorio reposUser;
	
	
	private Usuario usuario = new Usuario();

	private List<Usuario> usuarioCache;

	private int usuarioId;

	public CadastroMB() {
		Usuario session = (Usuario) FacesContext.getCurrentInstance()
				.getExternalContext().getSessionMap().get("usuario");
		usuarioId = session.getCodUsuario();
	}

	public String adiciona() {
		System.out.println(usuario.toString());

		reposUser.atualiza(this.usuario);
		usuario = new Usuario();
		this.setUsuarioCache(null);
		return "cadastro.xhtml?faces-redirect=true";
	}

	public Usuario getUsuario() {
		System.out.println("Dentro do GetUsuario" + usuario.toString());
		if (usuario.getCodUsuario() != usuarioId)
			usuario = reposUser.getUsuario(usuarioId);
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<Usuario> getUsuarioCache() {
		if (this.usuarioCache == null) {
			this.usuarioCache = this.reposUser.getLista();

		}
		return this.usuarioCache;
	}

	public void setUsuarioCache(List<Usuario> usuarioCache) {
		this.usuarioCache = usuarioCache;
	}

}
