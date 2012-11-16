package br.com.entidade;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity
@Table(name = "vagas")
public class Vagas implements Serializable {
	@Transient
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cod_vaga")
	private int codVaga;
	private String cargo;
	@Temporal(TemporalType.DATE)
	private Date dataCriacao;

//	@OneToOne(mappedBy = "cod_empresa")
//	private Empresa empresa;

//	@OneToOne(mappedBy = "id_curriculo")
//	private Curriculo curriculo;

	

	public int getCodVaga() {
		return codVaga;
	}

	public void setCodVaga(int codVaga) {
		this.codVaga = codVaga;
	}

	public String getcargo() {
		return cargo;
	}

	public void setcargo(String cargo) {
		this.cargo = cargo;
	}


	public Date getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(Date dataCriacao) {
		this.dataCriacao = dataCriacao;
	}
	
//	public Empresa getEmpresa() {
//	return empresa;
//}
//
//public void setEmpresa(Empresa empresa) {
//	this.empresa = empresa;
//}

//public Curriculo getCurriculo() {
//	return curriculo;
//}
//
//public void setCurriculo(Curriculo curriculo) {
//	this.curriculo = curriculo;
//}
	
	@Override
	public int hashCode() {
	
		return getCodVaga();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vagas other = (Vagas) obj;
		if (cargo == null) {
			if (other.cargo != null)
				return false;
		} else if (!cargo.equals(other.cargo))
			return false;
		if (codVaga != other.codVaga)
			return false;
		return true;
	}





}
