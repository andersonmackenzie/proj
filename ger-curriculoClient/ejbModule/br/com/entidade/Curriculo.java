package br.com.entidade;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "curriculo")
public class Curriculo implements Serializable {
	@Transient
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "curriculo_id")
	private Collection<CurriculoCursos> cursos = new ArrayList<CurriculoCursos>();

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "curriculo_id")
	private Collection<CurriculoEmpresa> empresas = new ArrayList<CurriculoEmpresa>();

	@OneToOne(mappedBy = "curriculo")
	private Usuario usuario;

	@OneToOne
	private AreaAtuacao areaAtuacao;

	@OneToOne
	private Universidade universidade;

	public int getIdCurriculo() {
		return id;
	}

	public void setIdCurriculo(int idCurriculo) {
		this.id = idCurriculo;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public AreaAtuacao getAreaAtuacao() {
		return areaAtuacao;
	}

	public void setAreaAtuacao(AreaAtuacao areaAtuacao) {
		this.areaAtuacao = areaAtuacao;
	}

	public Collection<CurriculoCursos> getCursos() {
		return cursos;
	}

	public void setCursos(Collection<CurriculoCursos> cursos) {
		this.cursos = cursos;
	}

	public Universidade getUniversidade() {
		return universidade;
	}

	public void setUniversidade(Universidade universidade) {
		this.universidade = universidade;
	}

	public Collection<CurriculoEmpresa> getEmpresas() {
		return empresas;
	}

	public void setEmpresas(Collection<CurriculoEmpresa> empresas) {
		this.empresas = empresas;
	}

	@Override
	public int hashCode() {
		return getIdCurriculo();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Curriculo other = (Curriculo) obj;
		if (id != other.id)
			return false;
		return true;
	}

}
