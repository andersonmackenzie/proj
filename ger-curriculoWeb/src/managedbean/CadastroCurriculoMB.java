package managedbean;

import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import com.sun.org.apache.regexp.internal.recompile;

import clienterepositorio.AreaAtuacaoRepositorio;
import clienterepositorio.CurriculoCursosRepositorio;
import clienterepositorio.CurriculoRepositorio;
import clienterepositorio.CursosRepositorio;
import clienterepositorio.EmpresaRepositorio;
import clienterepositorio.EnderecoRepositorio;
import clienterepositorio.UniversidadeRepositorio;
import clienterepositorio.UsuarioRepositorio;
import br.com.entidade.AreaAtuacao;
import br.com.entidade.Curriculo;
import br.com.entidade.CurriculoCursos;
import br.com.entidade.CurriculoEmpresa;
import br.com.entidade.Curso;
import br.com.entidade.Empresa;
import br.com.entidade.Endereco;
import br.com.entidade.Universidade;
import br.com.entidade.Usuario;

@ManagedBean
@RequestScoped
public class CadastroCurriculoMB {
	@EJB
	private UsuarioRepositorio reposUser;
	@EJB
	private AreaAtuacaoRepositorio areaRepositorio;
	@EJB
	private UniversidadeRepositorio universidadeRepositorio;
	@EJB
	private CursosRepositorio cursoRepositorio;
	@EJB
	private EmpresaRepositorio empresaRepositorio;

	private List<Empresa> listaEmpresas;

	private Usuario usuario = new Usuario();

	private Curriculo curriculo = new Curriculo();

	private List<Usuario> usuarioCache;

	private List<AreaAtuacao> listaAreas;

	private List<Universidade> listaUniversidade;

	private List<Curso> listaCursos;

	private CurriculoCursos curriculoCurso = new CurriculoCursos();
	
	private CurriculoEmpresa curriculoEmpresa = new CurriculoEmpresa();

	private int usuarioId;

	public CadastroCurriculoMB() {
		// Usuario session = (Usuario) FacesContext.getCurrentInstance()
		// .getExternalContext().getSessionMap().get("usuario");
		// usuarioId = session.getCodUsuario();

		usuarioId = 1;

	}

	public String adiciona() {
		System.out.println(usuario.toString());

		reposUser.atualiza(this.usuario);
		usuario = new Usuario();
		this.setUsuarioCache(null);
		
		this.listaAreas = null;
		this.listaUniversidade = null;
		
		return "cadastro-curriculo.xhtml?faces-redirect=true";
	}

	public String adicionaCursos() {
		// curriculoCursosRepositorio.adiciona(this.curriculoCurso);
		System.out.println("Dentro do adicionaCursos" + usuario.toString());
		System.out.println("Dentro do adicionaCursos"
				+ usuario.getCurriculo().getIdCurriculo());
		this.getUsuario();
		this.usuario.getCurriculo().getCursos().add(this.curriculoCurso);
		reposUser.atualiza(this.usuario);

		this.curriculoCurso = new CurriculoCursos();
		this.listaCursos = null;

		return "cadastro-curriculo.xhtml?faces-redirect=true";
	}

	public String adicionaEmpresa() {
		// curriculoCursosRepositorio.adiciona(this.curriculoCurso);
		System.out.println("Dentro do adicionaCursos" + usuario.toString());
		System.out.println("Dentro do adicionaCursos"
				+ usuario.getCurriculo().getIdCurriculo());
		this.getUsuario();
		this.usuario.getCurriculo().getEmpresas().add(this.curriculoEmpresa);
		reposUser.atualiza(this.usuario);
		this.curriculoEmpresa = new CurriculoEmpresa();
		this.listaEmpresas = null;
		
		return "cadastro-curriculo.xhtml?faces-redirect=true";
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

	public List<AreaAtuacao> getListaAreas() {
		if (listaAreas == null)
			listaAreas = areaRepositorio.getListaArea();
		return listaAreas;
	}

	public void setListaAreas(List<AreaAtuacao> listaAreas) {
		this.listaAreas = listaAreas;
	}

	public List<Universidade> getListaUniversidade() {
		if (listaUniversidade == null)
			listaUniversidade = universidadeRepositorio.getLista();
		return listaUniversidade;
	}

	public void setListaUniversidade(List<Universidade> listaUniversidade) {
		this.listaUniversidade = listaUniversidade;
	}

	public CurriculoCursos getCurriculoCurso() {
		return curriculoCurso;
	}

	public void setCurriculoCurso(CurriculoCursos curriculoCurso) {
		this.curriculoCurso = curriculoCurso;
	}

	public List<Curso> getListaCursos() {
		if (listaCursos == null)
			listaCursos = cursoRepositorio.getLista();
		return listaCursos;
	}

	public void setListaCursos(List<Curso> listaCursos) {
		this.listaCursos = listaCursos;
	}

	public Curriculo getCurriculo() {
		if (curriculo == null)
			curriculo = this.usuario.getCurriculo();
		return curriculo;
	}

	public void setCurriculo(Curriculo curriculo) {
		this.curriculo = curriculo;
	}

	public CurriculoEmpresa getCurriculoEmpresa() {
		return curriculoEmpresa;
	}

	public void setCurriculoEmpresa(CurriculoEmpresa curriculoEmpresa) {
		this.curriculoEmpresa = curriculoEmpresa;
	}

	public List<Empresa> getListaEmpresas() {
		if (listaEmpresas == null)
			listaEmpresas = empresaRepositorio.getEmpresas();
		return listaEmpresas;
	}

	public void setListaEmpresas(List<Empresa> listaEmpresas) {
		this.listaEmpresas = listaEmpresas;
	}

}
