package br.com.entidade;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity
@Table(name = "curriculo_empresa")
public class CurriculoEmpresa implements Serializable {
	@Transient
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idCurriculo;

	@Temporal(TemporalType.DATE)
	private Calendar dataEntrada;
	@Temporal(TemporalType.DATE)
	private Calendar dataSaida;
	private String atividades;
	private boolean exibirEmpresa;

	@ManyToOne(cascade = CascadeType.ALL)
	private Curriculo curriculo;

	@ManyToOne
	private Empresa empresa;

	public int getIdCurriculo() {
		return idCurriculo;
	}

	public void setIdCurriculo(int idCurriculo) {
		this.idCurriculo = idCurriculo;
	}

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	public Calendar getDataEntrada() {
		return dataEntrada;
	}

	public void setDataEntrada(Calendar dataEntrada) {
		this.dataEntrada = dataEntrada;
	}

	public Calendar getDataSaida() {
		return dataSaida;
	}

	public void setDataSaida(Calendar dataSaida) {
		this.dataSaida = dataSaida;
	}

	public String getAtividades() {
		return atividades;
	}

	public void setAtividades(String atividades) {
		this.atividades = atividades;
	}

	public boolean isExibirEmpresa() {
		return exibirEmpresa;
	}

	public void setExibirEmpresa(boolean exibirEmpresa) {
		this.exibirEmpresa = exibirEmpresa;
	}

	public Curriculo getCurriculo() {
		return curriculo;
	}

	public void setCurriculo(Curriculo curriculo) {
		this.curriculo = curriculo;
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
		CurriculoEmpresa other = (CurriculoEmpresa) obj;
		if (idCurriculo != other.idCurriculo)
			return false;
		return true;
	}

}
