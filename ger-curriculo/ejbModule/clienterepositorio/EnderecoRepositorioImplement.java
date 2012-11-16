package clienterepositorio;

import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import br.com.entidade.Endereco;
import br.com.entidade.TipoLogin;

@Stateless
@Remote(EnderecoRepositorio.class)
public class EnderecoRepositorioImplement implements EnderecoRepositorio {

	@PersistenceContext
	private EntityManager manager;

	@Override
	public void adiciona(Endereco endereco) {
		manager.persist(endereco);
	}

	@Override
	public void atualiza(Endereco endereco) {

		manager.merge(endereco);
	}

	@Override
	public List<Endereco> getLista() {
		TypedQuery<Endereco> query = manager.createQuery(
				"select cl from Endereco cl", Endereco.class);
		return query.getResultList();
	}

	@Override
	public Endereco getEndereco(int cod) {
		return manager.find(Endereco.class, cod);
	}

}
