package clienterepositorio;

import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import br.com.entidade.CurriculoCursos;


@Stateless
@Remote(CurriculoCursosRepositorio.class)
public class CurriculoCursosRepositorioImplement implements
		CurriculoCursosRepositorio {

	@PersistenceContext
	private EntityManager manager;

	@Override
	public List<CurriculoCursos> getLista() {
		TypedQuery<CurriculoCursos> query = manager.createQuery(
				"select cl from CurriculoCursos cl ", CurriculoCursos.class);

		return query.getResultList();
	}

	@Override
	public void adiciona(CurriculoCursos curCursos) {
		manager.persist(curCursos);

	}

	@Override
	public void atualiza(CurriculoCursos curCursos) {
		manager.merge(curCursos);

	}

	@Override
	public CurriculoCursos getCurriculoCurso(int cod) {
		return manager.find(CurriculoCursos.class, cod);
	}

}
