package clienterepositorio;

import java.util.List;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import br.com.entidade.CandidatoVaga;


@Stateless
@Remote(CandidatoVagaRepositorio.class)
public class CandidatoVagaRepositorioImplement implements CandidatoVagaRepositorio {
	@PersistenceContext
	private EntityManager manager2;

	@Override
	public void adiciona(CandidatoVaga vaga) {
		manager2.persist(vaga);

	}

	@Override
	public List<CandidatoVaga> getListaCandidatoVaga() {
		TypedQuery<CandidatoVaga> query = manager2.createQuery(
				"select cl from CandidatoVaga cl", CandidatoVaga.class);

		return query.getResultList();
	}

	@Override
	public void atualiza(CandidatoVaga vaga) {
		manager2.merge(vaga);

	}

	

}
