package clienterepositorio;

import java.util.List;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import br.com.entidade.AreaAtuacao;


@Stateless
@Remote(AreaAtuacaoRepositorio.class)
public class AreaAtuacaoRepositorioImplement implements AreaAtuacaoRepositorio {
	@PersistenceContext
	private EntityManager manager2;

	@Override
	public void adiciona(AreaAtuacao area) {
		manager2.persist(area);

	}

	@Override
	public List<AreaAtuacao> getListaArea() {
		TypedQuery<AreaAtuacao> query = manager2.createQuery(
				"select cl from AreaAtuacao cl", AreaAtuacao.class);

		return query.getResultList();
	}

	@Override
	public void atualiza(AreaAtuacao area) {
		manager2.merge(area);
		
	}

	@Override
	public AreaAtuacao getArea(int cod) {
		return manager2.find(AreaAtuacao.class, cod);
	}

}
