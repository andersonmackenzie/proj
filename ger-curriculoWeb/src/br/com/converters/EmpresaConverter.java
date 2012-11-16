package br.com.converters;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import clienterepositorio.EmpresaRepositorio;
import br.com.entidade.Empresa;



@FacesConverter(value = "converteEmpresa", forClass = Empresa.class)
public class EmpresaConverter implements Converter {
	
	@Override
	public Object getAsObject(FacesContext context, UIComponent component,
			String value) {
		if (value.equals(""))
			return null;
		InitialContext ctx;
		EmpresaRepositorio remote = null;
		try {
			ctx = new InitialContext();
			remote = (EmpresaRepositorio) ctx
					.lookup("java:global/ger-curriculoEAR/ger-curriculo/EmpresaRepositorioImplement");

		} catch (NamingException e) {

			e.printStackTrace();
		}

	
		return remote.getEmpresa(Integer.valueOf(value));
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component,
			Object value) {
		if (value != null && value instanceof Empresa) {
			return String.valueOf(((Empresa) value).getCodEmpresa());
		}
		return null;

	}
}
