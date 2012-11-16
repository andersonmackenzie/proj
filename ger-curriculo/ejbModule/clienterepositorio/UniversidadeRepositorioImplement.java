package clienterepositorio;

import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import br.com.entidade.Universidade;

@Stateless
@Remote(UniversidadeRepositorio.class)
public class UniversidadeRepositorioImplement implements
		UniversidadeRepositorio {

	@PersistenceContext
	private EntityManager manager;

	@Override
	public void adiciona(Universidade universidade) {
		manager.persist(universidade);

	}

	@Override
	public void atualiza(Universidade universidade) {
		manager.merge(universidade);

	}

	@Override
	public List<Universidade> getLista() {
		TypedQuery<Universidade> query = manager.createQuery(
				"select cl from Universidade cl", Universidade.class);

		return query.getResultList();
	}

	@Override
	public Universidade getUniversidade(int cod) {
		return manager.find(Universidade.class, cod);
	}

}
