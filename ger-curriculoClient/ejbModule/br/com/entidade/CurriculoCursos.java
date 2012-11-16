package br.com.entidade;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity
@Table(name = "curriculo_curso")
public class CurriculoCursos implements Serializable {
	@Transient
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idCurriculoCurso;

	@Temporal(TemporalType.DATE)
	private Date dataInicio;
	@Temporal(TemporalType.DATE)
	private Date datatermino;
	private String horas;
	private boolean exibirCursos;

	@OneToOne
	private Curso curso;

	@ManyToOne(cascade = CascadeType.ALL)
	private Curriculo curriculo;

	public int getIdCurriculoCurso() {
		return idCurriculoCurso;
	}

	public void setIdCurriculoCurso(int idCurriculoCurso) {
		this.idCurriculoCurso = idCurriculoCurso;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	public Date getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}

	public Date getDatatermino() {
		return datatermino;
	}

	public void setDatatermino(Date datatermino) {
		this.datatermino = datatermino;
	}

	public String getHoras() {
		return horas;
	}

	public void setHoras(String horas) {
		this.horas = horas;
	}

	public boolean isExibirCursos() {
		return exibirCursos;
	}

	public void setExibirCursos(boolean exibirCursos) {
		this.exibirCursos = exibirCursos;
	}

	@Override
	public int hashCode() {

		return getIdCurriculoCurso();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CurriculoCursos other = (CurriculoCursos) obj;
		if (idCurriculoCurso != other.idCurriculoCurso)
			return false;
		return true;
	}

	public Curriculo getCurriculo() {
		return curriculo;
	}

	public void setCurriculo(Curriculo curriculo) {
		this.curriculo = curriculo;
	}

}
