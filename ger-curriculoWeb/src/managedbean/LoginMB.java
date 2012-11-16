package managedbean;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.model.SelectItem;
import clienterepositorio.LoginRepositorio;
import br.com.entidade.Login;
import br.com.entidade.Usuario;
import clienterepositorio.TipoLoginRepositorio;
import br.com.entidade.TipoLogin;

@ManagedBean
@RequestScoped
public class LoginMB {
	@EJB
	private LoginRepositorio repositorio;
	@EJB
	private TipoLoginRepositorio repositorioTipoLogin;

	private Login Login = new Login();
	private Login listaTodos;
	private List<Login> loginCache;
	private List<SelectItem> tipoLogin;

	private List<TipoLogin> listateste;

	public String adiciona() {
		this.Login.setUsuario(new Usuario());
		repositorio.adiciona(this.Login);

		this.Login = new Login();

		this.loginCache = null;
		System.out.print("Adicionado");
		return "";
	}

	public List<Login> getLogins() {
		if (this.loginCache == null) {
			this.loginCache = this.repositorio.getLista();

		}
		return this.loginCache;
	}

	public List<SelectItem> getTipoLogin() {
		if (this.tipoLogin == null) {
			this.tipoLogin = new ArrayList<SelectItem>();
			List<TipoLogin> tipos = this.repositorioTipoLogin.getTipoLogin();

			this.tipoLogin.add(new SelectItem(null, "Selecione"));

			for (TipoLogin tipo : tipos)
				this.tipoLogin.add(new SelectItem(tipo, tipo.getnomeTipo()));

		}
		return this.tipoLogin;
	}

	public Login getLogin() {
		return Login;
	}

	public void setLogin(Login Login) {
		this.Login = Login;
	}

	public List<TipoLogin> getListateste() {
		return listateste = repositorioTipoLogin.getTipoLogin();
	}

	public Login getListaTodos() {
		return listaTodos;
	}

	public void setListaTodos(Login listaTodos) {
		this.listaTodos = listaTodos;
	}

}
