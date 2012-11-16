package clienterepositorio;

import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import br.com.entidade.CurriculoEmpresa;

@Stateless
@Remote(CurriculoEmpresaRepositorio.class)
public class CurriculoEmpresaRepositorioImplement implements
		CurriculoEmpresaRepositorio {

	@PersistenceContext
	private EntityManager manager;

	@Override
	public List<CurriculoEmpresa> getLista() {
		TypedQuery<CurriculoEmpresa> query = manager.createQuery(
				"select cl from CurriculoEmpresa cl ", CurriculoEmpresa.class);

		return query.getResultList();
	}

	@Override
	public void adiciona(CurriculoEmpresa curCursos) {
		manager.persist(curCursos);

	}

	@Override
	public void atualiza(CurriculoEmpresa curCursos) {
		manager.merge(curCursos);

	}

	@Override
	public CurriculoEmpresa getCurriculoEmpresa(int cod) {
		return manager.find(CurriculoEmpresa.class, cod);
	}

}
