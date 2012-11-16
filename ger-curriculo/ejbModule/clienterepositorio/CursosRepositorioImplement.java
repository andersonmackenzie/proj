package clienterepositorio;

import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import br.com.entidade.Curso;

@Stateless
@Remote(CursosRepositorio.class)
public class CursosRepositorioImplement implements CursosRepositorio {

	@PersistenceContext
	private EntityManager manager;

	@Override
	public void adiciona(Curso curso) {
		manager.persist(curso);

	}

	@Override
	public List<Curso> getLista() {
		TypedQuery<Curso> query = manager.createQuery(
				"select cl from Curso cl", Curso.class);

		return query.getResultList();
	}

	@Override
	public void atualiza(Curso curso) {
		manager.merge(curso);
		
	}

	@Override
	public Curso getCurso(int cod) {
		return manager.find(Curso.class, cod);
	}

}
