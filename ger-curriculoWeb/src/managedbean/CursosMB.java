package managedbean;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import clienterepositorio.CursosRepositorio;
import br.com.entidade.Curso;

@ManagedBean
@RequestScoped
public class CursosMB {
	@EJB
	private CursosRepositorio repositorio;
	private Curso curso = new Curso();
	private List<Curso> cursoCache;

	public String adiciona() {
		repositorio.adiciona(this.curso);
		this.curso = new Curso();
		this.curso = null;
		return "";
	}

	public List<Curso> getLista() {
		if (this.cursoCache == null) {
			this.cursoCache = this.repositorio.getLista();

		}
		return this.cursoCache;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

}
