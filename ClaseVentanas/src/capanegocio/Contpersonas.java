package capanegocio;

import capadata.Catpersonas;
import entidades.Persona;

public class Contpersonas {
	Catpersonas cpers = new Catpersonas();
	
	public Persona searchPersona(int dni){
		return cpers.searchPersona(dni);
	}
	public String addPersona(int dni, String nombre, String apellido, String email){
		Persona p = new Persona();
		String message = "Persona ya existente";
		p = searchPersona(dni);
		if (p == null){
			cpers.addPersona(dni, nombre, apellido, email);
			return (message = "Guardado con exito");
		}
		return message;
	}
	public String deletePersona(int dni){
		return cpers.deletePersona(dni);
	}
	public Persona updatePersona(int dni, String nombre, String apellido, String email){
		return cpers.updatePersona(dni, nombre, apellido, email);
	} 
}
