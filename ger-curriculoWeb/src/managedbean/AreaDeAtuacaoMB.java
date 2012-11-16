package managedbean;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import clienterepositorio.AreaAtuacaoRepositorio;
import br.com.entidade.AreaAtuacao;

@ManagedBean
@RequestScoped
public class AreaDeAtuacaoMB {
	@EJB
	private AreaAtuacaoRepositorio repositorio3;
	private AreaAtuacao area = new AreaAtuacao();
	private List<AreaAtuacao> areacache;

	public String adiciona() {
		repositorio3.adiciona(this.area);
		this.area = new AreaAtuacao();
		this.areacache = null;
		return "";
	}

	public List<AreaAtuacao> getListaAreas() {
		if (this.areacache == null) {
			this.areacache = this.repositorio3.getListaArea();

		}
		return this.areacache;
	}

	public AreaAtuacao getArea() {
		return area;
	}

	public void setArea(AreaAtuacao area) {
		this.area = area;
	}

}
