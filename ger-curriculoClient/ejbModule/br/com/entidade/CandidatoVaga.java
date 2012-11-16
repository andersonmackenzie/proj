package br.com.entidade;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
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
@Table(name = "candidato_vaga")
public class CandidatoVaga implements Serializable {
	@Transient
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cod_cad_vaga")
	private int codCandVaga;

	@Temporal(TemporalType.DATE)
	private Date dataCriacao;

	@ManyToOne
	private Vagas vaga;

//	@OneToOne(mappedBy = "id_curriculo")
//	private Curriculo curriculo;

	public int getCodCandVaga() {
		return codCandVaga;
	}

	public void setCodCandVaga(int codCandVaga) {
		this.codCandVaga = codCandVaga;
	}

	public Date getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(Date dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	
//
//	public Curriculo getCurriculo() {
//		return curriculo;
//	}
//
//	public void setCurriculo(Curriculo curriculo) {
//		this.curriculo = curriculo;
//	}

	public Vagas getVaga() {
		return vaga;
	}

	public void setVaga(Vagas vaga) {
		this.vaga = vaga;
	}

	@Override
	public int hashCode() {
	
		return getCodCandVaga();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CandidatoVaga other = (CandidatoVaga) obj;
		if (codCandVaga != other.codCandVaga)
			return false;
		return true;
	}

}
