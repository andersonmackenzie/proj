package br.com.entidade;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "tipo_login")
public class TipoLogin implements Serializable {
	@Transient
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id_tipo")
	private int codTipoLogin;
	@Column(name = "nome_tipo")
	private String nomeTipo;

	public int getcodTipoLogin() {
		return codTipoLogin;
	}

	public void setcodTipoLogin(int codTipoLogin) {
		this.codTipoLogin = codTipoLogin;
	}

	public String getnomeTipo() {
		return nomeTipo;
	}

	public void setnomeTipo(String nomeTipo) {
		this.nomeTipo = nomeTipo;
	}

	@Override
	public int hashCode() {
		return getcodTipoLogin();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TipoLogin other = (TipoLogin) obj;
		if (codTipoLogin != other.codTipoLogin)
			return false;
		if (nomeTipo == null) {
			if (other.nomeTipo != null)
				return false;
		} else if (!nomeTipo.equals(other.nomeTipo))
			return false;
		return true;
	}

}
