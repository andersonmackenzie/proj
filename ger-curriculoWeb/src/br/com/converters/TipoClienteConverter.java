package br.com.converters;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import clienterepositorio.TipoLoginRepositorio;

import br.com.entidade.TipoLogin;

@FacesConverter(value = "convertetipo", forClass = TipoLogin.class)
public class TipoClienteConverter implements Converter {
	
	@Override
	public Object getAsObject(FacesContext context, UIComponent component,
			String value) {
		if (value.equals(""))
			return null;
		InitialContext ctx;
		TipoLoginRepositorio remote = null;
		try {
			ctx = new InitialContext();
			remote = (TipoLoginRepositorio) ctx
					.lookup("java:global/ger-curriculoEAR/ger-curriculo/TipoLoginRepositorioImplement");

		} catch (NamingException e) {

			e.printStackTrace();
		}

	
		return remote.getTipo(Integer.valueOf(value));
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component,
			Object value) {
		if (value != null && value instanceof TipoLogin) {
			return String.valueOf(((TipoLogin) value).getcodTipoLogin());
		}
		return null;

	}
}
