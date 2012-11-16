package managedbean;

import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import clienterepositorio.LoginRepositorio;
import br.com.entidade.Login;
import br.com.entidade.Usuario;

@ManagedBean
@SessionScoped
public class LogarMB {
	@EJB
	private LoginRepositorio repositorio;

	private Login login = new Login();

	private List<Login> listaLogin;

	public String verifica() {
		System.out.println("Dentro login: " + this.login.getUser() + "  "
				+ this.login.getSenha());

		for (Login verifica : getListaLogin()) {
			System.out.println("Dentro login no for: " + verifica.getUser()
					+ "  " + verifica.getSenha()
					+ verifica.getUsuario().getNome()
					+ +verifica.getTipo().getcodTipoLogin());

			if ((this.login.getUser().equals(verifica.getUser()))) {
				if ((this.login.getSenha().equals(verifica.getSenha()))) {
					FacesContext.getCurrentInstance().getExternalContext()
							.getSessionMap()
							.put("usuario", verifica.getUsuario());
					if (verifica.getTipo().getcodTipoLogin() == 1)
						return "admin";
					else if (verifica.getTipo().getcodTipoLogin() == 2)
						return "cadastro";
					else
						return "empresa";
					// Logado
				}
			}
		}
		this.login = new Login();

		return "";
	}

	public Login getLogin() {
		return login;
	}

	public void setLogin(Login login) {
		this.login = login;
	}

	public List<Login> getListaLogin() {
		if (listaLogin == null)
			listaLogin = repositorio.getLista();
		return listaLogin;
	}

	public void setListaLogin(List<Login> listaLogin) {
		this.listaLogin = listaLogin;
	}

	public String doLogout() {
		// FacesContext fc = FacesContext.getCurrentInstance();
		// HttpSession session = (HttpSession)
		// fc.getExternalContext().getSession(
		// false);
		//
		// // expira a sessão
		// session.invalidate();
		//
		// FacesContext context = FacesContext.getCurrentInstance();
		// context.getExternalContext().getSessionMap().remove("usuario");
		//
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
				.getExternalContext().getSession(true);
		session.invalidate();
		return "login"; // login
	}
}
