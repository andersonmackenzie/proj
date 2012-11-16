package managedbean;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import clienterepositorio.EmpresaRepositorio;

import br.com.entidade.Empresa;

@ManagedBean
@RequestScoped
public class EmpresaMB {
	@EJB
	private EmpresaRepositorio repositorio;
	private Empresa empresa = new Empresa();
	private List<Empresa> empresaCache;

	public String adiciona() {
		repositorio.adiciona(this.empresa);
		this.empresa = new Empresa();
		this.empresaCache = null;
		return "";
	}

	public List<Empresa> getEmpresas() {
		if (this.empresaCache == null) {
			this.empresaCache = this.repositorio.getEmpresas();

		}
		return this.empresaCache;
	}

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

}
