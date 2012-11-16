package managedbean;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import clienterepositorio.UniversidadeRepositorio;
import br.com.entidade.Universidade;

@ManagedBean
@RequestScoped
public class UniversidadeMB {
	@EJB
	private UniversidadeRepositorio repositorio3;
	private Universidade universidade = new Universidade();
	private List<Universidade> univerCache;

	public String adiciona() {
		repositorio3.adiciona(this.universidade);
		this.universidade = new Universidade();
		this.univerCache = null;
		return "";
	}

	public Universidade getUniversidade() {
		return universidade;
	}

	public void setUniversidade(Universidade universidade) {
		this.universidade = universidade;
	}

	public List<Universidade> getUniverCache() {
		if (this.univerCache == null) {
			this.univerCache = this.repositorio3.getLista();

		}
		return this.univerCache;
	}

	public void setUniverCache(List<Universidade> univerCache) {
		this.univerCache = univerCache;
	}

}
