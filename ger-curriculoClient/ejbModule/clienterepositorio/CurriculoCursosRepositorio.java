package clienterepositorio;

import java.util.List;

import br.com.entidade.CurriculoCursos;

public interface CurriculoCursosRepositorio {
	public void adiciona(CurriculoCursos curCursos);

	public void atualiza(CurriculoCursos curCursos);

	public List<CurriculoCursos> getLista();

	public CurriculoCursos getCurriculoCurso(int cod);
}
