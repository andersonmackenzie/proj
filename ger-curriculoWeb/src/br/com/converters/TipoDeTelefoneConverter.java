package br.com.converters;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import clienterepositorio.TipoDeTelefoneRepositorio;

import br.com.entidade.TipoDeTelefone;

@FacesConverter(value = "convertetipoTel", forClass = TipoDeTelefone.class)
public class TipoDeTelefoneConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext context, UIComponent component,
			String value) {
		if (value.equals(""))
			return null;
		InitialContext ctx;
		TipoDeTelefoneRepositorio remote = null;
		try {
			ctx = new InitialContext();
			remote = (TipoDeTelefoneRepositorio) ctx
					.lookup("java:global/ger-curriculoEAR/ger-curriculo/TipoDeTelefoneRepositorioImplement");

		} catch (NamingException e) {

			e.printStackTrace();
		}

		return remote.getTipo(Integer.valueOf(value));
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component,
			Object value) {
		if (value != null && value instanceof TipoDeTelefone) {
			return String.valueOf(((TipoDeTelefone) value).getCod());
		}
		return null;

	}
}
