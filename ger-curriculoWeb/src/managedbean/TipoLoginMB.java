package managedbean;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import clienterepositorio.TipoLoginRepositorio;
import br.com.entidade.TipoLogin;

@ManagedBean
@RequestScoped
public class TipoLoginMB {
	@EJB
	private TipoLoginRepositorio repositorio2;
	private TipoLogin tipoLogin = new TipoLogin();
	private List<TipoLogin> tipoLogincache;

	public String adiciona() {
		repositorio2.adiciona(this.tipoLogin);
		this.tipoLogin = new TipoLogin();
		this.tipoLogincache = null;
		return "";
	}

	public List<TipoLogin> getListaTipoLogin() {
		if (this.tipoLogincache == null) {
			this.tipoLogincache = this.repositorio2.getTipoLogin();

		}
		return this.tipoLogincache;
	}

	public void setTipoLogin(TipoLogin tipoLogin) {
		this.tipoLogin = tipoLogin;
	}

	public TipoLogin getTipoLogin() {
		return tipoLogin;
	}

}
